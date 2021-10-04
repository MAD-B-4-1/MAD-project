package com.example.lecturemanagement.Helper;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.lecturemanagement.timetableLec_Activity;
import com.example.lecturemanagement.Database.DatabaseClient;
import com.example.lecturemanagement.Database.LecturerDetails;

import java.util.List;



public class DBHelper {
    Context context;

    public DBHelper(Context context) {
        this.context = context;
    }

    public static DBHelper getInstance(Context context){
        return new DBHelper(context);
    }

    //insert
    public void addNew( String lectureID, String name, String moduleID, String mail, String lecIncha){
        class NewRec extends AsyncTask<Void,Void, LecturerDetails> {

            @Override
            protected LecturerDetails doInBackground(Void... voids) {
                LecturerDetails lecturerDetails=new LecturerDetails();
                lecturerDetails.setLectureID(lectureID);
                lecturerDetails.setName(name);
                lecturerDetails.setModuleID(moduleID);
                lecturerDetails.setMail(mail);
                lecturerDetails.setLecturer_incharge(lecIncha);

                DatabaseClient.getInstance(context)
                        .getLecturerDatabase()
                        .LectureDAD()
                        .insertData(lecturerDetails);
                return lecturerDetails;
            }

            @Override
            protected void onPostExecute(LecturerDetails lecturerDetails) {
                super.onPostExecute(lecturerDetails);
                if(lecturerDetails !=null){
                    Toast.makeText(context, lecturerDetails.getLectureID()+"\n"+ lecturerDetails.getName()+"\n"+
                            lecturerDetails.getModuleID()+"\n"+ lecturerDetails.getMail()+"\n"+
                            lecturerDetails.getLecturer_incharge(),Toast.LENGTH_SHORT).show();
                }
            }
        }

        NewRec newRec=new NewRec();
        newRec.execute();
    }

    //show data
    public void getAlldata(){
        class AllData extends AsyncTask<Void,Void, List<LecturerDetails>>{

            @Override
            protected List<LecturerDetails> doInBackground(Void... voids) {
                List<LecturerDetails> list=DatabaseClient.getInstance(context)
                        .getLecturerDatabase()
                        .LectureDAD()
                        .selectAll();
                return list;
            }

            @Override
            protected void onPostExecute(List<LecturerDetails> lecturerDetails){
                super.onPostExecute(lecturerDetails);
                if(lecturerDetails!=null && lecturerDetails.size()>0){
                    ((timetableLec_Activity)context).setRecyclerview(lecturerDetails);
                }
            }
        }

        AllData alldata=new AllData();
        alldata.execute();
    }

    //update
    public void UpdateData(LecturerDetails table,String lecid,String name,String modid,
                           String mail,String lecinchg){
        class UpdateLecturerData extends AsyncTask<Void,Void,LecturerDetails>{

            @Override
            protected LecturerDetails doInBackground(Void... voids) {
                table.setLectureID(lecid);
                table.setName(name);
                table.setModuleID(modid);
                table.setMail(mail);
                table.setLecturer_incharge(lecinchg);

                DatabaseClient.getInstance(context)
                        .getLecturerDatabase()
                        .LectureDAD()
                        .UpdateData(table);
                return table;
            }

            @Override
            protected void onPostExecute(LecturerDetails lecturerDetails){
                super.onPostExecute(lecturerDetails);
                if(table !=null){
                    Toast.makeText(context,"Updated"+"\n"+ table.getLectureID()+"\n"+
                            table.getName()+"\n"+ table.getModuleID()+"\n"+ table.getMail()+
                            "\n"+table.getLecturer_incharge(),Toast.LENGTH_SHORT).show();
                }
            }
        }
        UpdateLecturerData updateLecturerData=new UpdateLecturerData();
        updateLecturerData.execute();
    }

    //Delete
    public void DeleteData(LecturerDetails lecturerDetails){
        class DeleteData extends AsyncTask<Void,Void,Void>{

            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient.getInstance(context)
                        .getLecturerDatabase()
                        .LectureDAD()
                        .DeleteData(lecturerDetails);
                return null;
            }
        }
        DeleteData deleteData=new DeleteData();
        deleteData.execute();
    }
}



