package com.example.modulemanagementpro.Helper;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.modulemanagementpro.DataViewerActivity;
import com.example.modulemanagementpro.Database.DatabaseClient;
import com.example.modulemanagementpro.Database.ModuleDetails;

import java.util.List;

public class DBHelper {
    Context context;

    public DBHelper(Context context) {
        this.context = context;
    }

    public static DBHelper getInstance(Context context){
        return new DBHelper(context);
    }

    //insert details
    public void addNew( String moduleID, String payment, String credit, String lecturer){
        class NewRec extends AsyncTask<Void,Void, ModuleDetails> {
            @Override
            protected ModuleDetails doInBackground(Void... voids) {
                ModuleDetails moduleDetails=new ModuleDetails();
                moduleDetails.setModuleID(moduleID);
                moduleDetails.setCredit(credit);
                moduleDetails.setPayment(payment);
                moduleDetails.setLecturer(lecturer);
                DatabaseClient.getInstance(context)
                        .getModuleDatabase()
                        .moduleDAD()
                        .insertData(moduleDetails);
                return moduleDetails; }
            @Override
            protected void onPostExecute(ModuleDetails moduleDetails) {
                super.onPostExecute(moduleDetails);
                if(moduleDetails !=null){
                    Toast.makeText(context,"Added"+"\n"+ moduleDetails.getModuleID()+"\n"+ moduleDetails.getCredit()+"\n"+
                            moduleDetails.getPayment()+"\n"+moduleDetails.getLecturer(),Toast.LENGTH_SHORT).show(); }
            }}
        NewRec newRec=new NewRec();
        newRec.execute();
    }

    //show data
    public void getAlldata(){
        class AllData extends AsyncTask<Void,Void, List<ModuleDetails>>{

            @Override
            protected List<ModuleDetails> doInBackground(Void... voids) {
                List<ModuleDetails> list=DatabaseClient.getInstance(context)
                        .getModuleDatabase()
                        .moduleDAD()
                        .selectAll();
                return list;
            }
            @Override
            protected void onPostExecute(List<ModuleDetails> moduleDetails){
                super.onPostExecute(moduleDetails);
                if(moduleDetails!=null && moduleDetails.size()>0){
                    ((DataViewerActivity)context).setRecyclerview(moduleDetails);
                }
            }
        }
        AllData alldata=new AllData();
        alldata.execute();
    }

    //update
    public void UpdateData(ModuleDetails table,String moduleid,String credit,String payment,String lecture){
        class UpdateModuleData extends AsyncTask<Void,Void,ModuleDetails>{

            @Override
            protected ModuleDetails doInBackground(Void... voids) {
                table.setModuleID(moduleid);
                table.setCredit(credit);
                table.setPayment(payment);
                table.setLecturer(lecture);

                DatabaseClient.getInstance(context)
                        .getModuleDatabase()
                        .moduleDAD()
                        .UpdateData(table);
                return table;
            }
            @Override
            protected void onPostExecute(ModuleDetails moduleDetails){
                super.onPostExecute(moduleDetails);
                if(table !=null){
                    Toast.makeText(context,"Updated"+"\n"+ table.getModuleID()+"\n"+
                            table.getPayment()+"\n"+table.getCredit()+"\n"+table.getPayment(),Toast.LENGTH_SHORT).show();
                }
            }
        }
        UpdateModuleData updateModuleData=new UpdateModuleData();
        updateModuleData.execute();
    }

    //Delete
    public void DeleteData(ModuleDetails moduleDetails){
        class DeleteData extends AsyncTask<Void,Void,Void>{

            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient.getInstance(context)
                        .getModuleDatabase()
                        .moduleDAD()
                        .DeleteData(moduleDetails);
                return null;
            }
        }
        DeleteData deleteData=new DeleteData();
        deleteData.execute();
    }
}


