package com.example.hallmanagement;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import com.example.hallmanagement.Database.HallDetails;
import com.example.hallmanagement.Helper.DBHelper;



public class UpdateActivity extends AppCompatActivity {
    EditText hall_id, time,module_id,module_name, lecture_name;
    HallDetails hallDetails;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        helper=DBHelper.getInstance(this);

        hall_id=findViewById(R.id.hallIDupdate);
        time=findViewById(R.id.timeupdate);
        module_id=findViewById(R.id.moduleIDupdate);
        module_name=findViewById(R.id.moduleNameupdate);
        lecture_name=findViewById(R.id.lectureNameupdate);

        if(getIntent()!=null){
            hallDetails=(HallDetails) getIntent().getSerializableExtra("HallDatabase");
            hall_id.setText(hallDetails.getHallID());
            time.setText(hallDetails.getTime());
            module_id.setText(hallDetails.getModule_id());
            module_name.setText(hallDetails.getModule_name());
            lecture_name.setText(hallDetails.getLecturer_name());

        }
    }

    public void UpdateData(View view) {
//        if(!hall_id.getText().toString().isEmpty() && !time.getText().toString().isEmpty() &&
//                !module_id.getText().toString().isEmpty() && !module_name.getText().toString().isEmpty())  && !lecture_name.getText().toString().isEmpty())
        String halid_val = hall_id.getText().toString().trim();
        if (halid_val.isEmpty()) {
            hall_id.setError("HallID Cannot be Empty");
        } else if (halid_val.length()==5) {
            if (halid_val.startsWith("H")) {
            } else {
                hall_id.setError("HallID Starts with H");
            }}
        else{
            hall_id.setError("HallID contain 5 digit");
        }


        String time_val=time.getText().toString().trim();
        if(time_val.isEmpty()){
            time.setError("Required Field");
        }else if(time_val.length()==6 ){
            if(time_val.endsWith("AM/PM")) {
            } else{
                 time.setError("Time ends with AM/PM Format");
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
        if(lecname_val.isEmpty())
            lecture_name.setError("Required Field");


        helper.UpdateData(hallDetails,hall_id.getText().toString(),time.getText().toString(),
                module_id.getText().toString(),module_name.getText().toString(),lecture_name.getText().toString());

    }

    public void showData(View view) {

        startActivity(new Intent(this, DataViewerActivity.class));
    }
}