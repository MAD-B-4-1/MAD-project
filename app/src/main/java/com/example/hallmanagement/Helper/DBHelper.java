package com.example.hallmanagement.Helper;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.hallmanagement.DataViewerActivity;
import com.example.hallmanagement.Database.DatabaseClient;
import com.example.hallmanagement.Database.HallDetails;

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
    public void addNew( String hallID, String time, String moduleID, String module_name, String lecturer_name){
        class NewRec extends AsyncTask<Void,Void, HallDetails> {
            @Override
            protected HallDetails doInBackground(Void... voids) {
                HallDetails hallDetails=new HallDetails();
                hallDetails.setHallID(hallID);
                hallDetails.setTime(time);
                hallDetails.setModule_id(moduleID);
                hallDetails.setModule_name(module_name);
                hallDetails.setLecturer_name(lecturer_name);
                DatabaseClient.getInstance(context)
                        .getHallDatabase()
                        .hallDAD()
                        .insertData(hallDetails);
                return hallDetails; }
            @Override
            protected void onPostExecute(HallDetails hallDetails) {
                super.onPostExecute(hallDetails);
                if(hallDetails !=null){
                    Toast.makeText(context,hallDetails.getHallID()+"\n"+ hallDetails.getTime()+"\n"+
                            hallDetails.getModule_id()+"\n"+hallDetails.getModule_name()+"\n"+hallDetails.getLecturer_name(),Toast.LENGTH_SHORT).show(); }
            }}
        NewRec newRec=new NewRec();
        newRec.execute();
    }

    //show data
    public void getAlldata(){
        class AllData extends AsyncTask<Void,Void, List<HallDetails>>{

            @Override
            protected List<HallDetails> doInBackground(Void... voids) {
                List<HallDetails> list=DatabaseClient.getInstance(context)
                        .getHallDatabase()
                        .hallDAD()
                        .selectAll();
                return list;
            }
            @Override
            protected void onPostExecute(List<HallDetails> hallDetails){
                super.onPostExecute(hallDetails);
                if(hallDetails!=null && hallDetails.size()>0){
                    ((DataViewerActivity)context).setRecyclerview(hallDetails);
                }
            }
        }
        AllData alldata=new AllData();
        alldata.execute();
    }

    //update
    public void UpdateData(HallDetails table,String hall_id,String time,String module_id,String module_name,String lecturer_name){
        class UpdateHallData extends AsyncTask<Void,Void,HallDetails>{

            @Override
            protected HallDetails doInBackground(Void... voids) {
                table.setHallID(hall_id);
                table.setTime(time);
                table.setModule_id(module_id);
                table.setModule_name(module_name);
                table.setLecturer_name(lecturer_name);

                DatabaseClient.getInstance(context)
                        .getHallDatabase()
                        .hallDAD()
                        .UpdateData(table);
                return table;
            }
            @Override
            protected void onPostExecute(HallDetails hallDetails){
                super.onPostExecute(hallDetails);
                if(table !=null){
                    Toast.makeText(context,"Updated"+"\n"+ table.getHallID()+"\n"+
                            table.getTime()+"\n"+table.getModule_id()+"\n"+table.getModule_name()+"\n"+table.getLecturer_name(),Toast.LENGTH_SHORT).show();
                }
            }
        }
        UpdateHallData updateHallData=new UpdateHallData();
        updateHallData.execute();
    }

    //Delete
    public void DeleteData(HallDetails hallDetails){
        class DeleteData extends AsyncTask<Void,Void,Void>{

            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient.getInstance(context)
                        .getHallDatabase()
                        .hallDAD()
                        .DeleteData(hallDetails);
                return null;
            }
        }
        DeleteData deleteData=new DeleteData();
        deleteData.execute();
    }
}


