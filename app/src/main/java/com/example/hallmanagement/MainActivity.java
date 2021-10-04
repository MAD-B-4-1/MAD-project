package com.example.hallmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.example.hallmanagement.Helper.DBHelper;


public class MainActivity extends AppCompatActivity {


    EditText hall_id;
    EditText time;
    EditText module_id;
    EditText module_name;
    EditText lecture_name;
    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = DBHelper.getInstance(this);

        hall_id= findViewById(R.id.hallID);
        time = findViewById(R.id.time);
        module_id= findViewById(R.id.moduleID);
        module_name = findViewById(R.id.moduleName);
        lecture_name = findViewById(R.id.lectureName);
    }


    public void submitData(View view) {

        String hallid_val = hall_id.getText().toString().trim();
        if (hallid_val.isEmpty()) {
            hall_id.setError("HallID Cannot be Empty");
        } else if (hallid_val.length()==5) {
            if (hallid_val.startsWith("H")) {
            } else {
                hall_id.setError("HallID Starts with H");
            }
        }
        else{
            hall_id.setError("HallID contain 5 digit");
        }

        String time_val=time.getText().toString().trim();
        if(time_val.isEmpty()){
            time.setError("Required Field");
        }else if(time_val.length()==6 ){
            if(time_val.endsWith("AM||PM")) {
            } else{
                time.setError("Time must be in AM/PM Format");
            }
        }else{
             time.setError("Time contain 6 digit");
        }

        String mid_val = module_id.getText().toString().trim();
        if (mid_val.isEmpty()) {
            module_id.setError("ModuleID Cannot be Empty");
        } else if (mid_val.length()==5) {
            if (mid_val.startsWith("M")) {
            } else {
                module_id.setError("ModuleID Starts with M");
            }}
        else{
            module_id.setError("ModuleID contain 5 digit");
        }

        String modname_val=module_name.getText().toString().trim();
        if(modname_val.isEmpty())
            module_name.setError("Required Field");

        String lecname_val=lecture_name.getText().toString().trim();
        if(lecname_val.isEmpty()){
            lecture_name.setError("Required Field");
        }

        helper.addNew(hall_id.getText().toString(), time.getText().toString(), module_id.getText().toString(), module_name.getText().toString(), lecture_name.getText().toString());

    }

    public void showData(View view){

        startActivity(new Intent(this, DataViewerActivity.class));
    }



}