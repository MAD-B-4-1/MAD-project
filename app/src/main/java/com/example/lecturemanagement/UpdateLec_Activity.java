package com.example.lecturemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.lecturemanagement.Database.LecturerDetails;
import com.example.lecturemanagement.Helper.DBHelper;

public class UpdateLec_Activity extends AppCompatActivity {

    EditText lectureid,lecturename,moduleid,lecemail,lecindet;
    LecturerDetails lecturerDetails;
    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_lec);

        helper=DBHelper.getInstance(this);

        lectureid=findViewById(R.id.lecid);
        lecturename=findViewById(R.id.lecname);
        moduleid=findViewById(R.id.modid);
        lecemail=findViewById(R.id.lecmail);
        lecindet=findViewById(R.id.lecinch);


        if(getIntent()!=null){
            lecturerDetails=(LecturerDetails) getIntent().getSerializableExtra("LecturerDatabase");

            lectureid.setText(lecturerDetails.getLectureID());
            lecturename.setText(lecturerDetails.getName());
            moduleid.setText(lecturerDetails.getModuleID());
            lecemail.setText(lecturerDetails.getMail());
            lecindet.setText(lecturerDetails.getLecturer_incharge());


        }
    }

    public void UpdateData(View view) {
      /*  if( !lectureid.getText().toString().isEmpty() && !lecturename.getText().toString().isEmpty()
                && !moduleid.getText().toString().isEmpty() && !lecemail.getText().toString().isEmpty() &&
                !lecindet.getText().toString().isEmpty())*/

        String lecid_val = lectureid.getText().toString().trim();
        if (lecid_val.isEmpty()) {
            lectureid.setError("LecturerID Cannot be Empty");
        } else if (lecid_val.length()==6) {
            if (lecid_val.startsWith("LR")) {
            } else {
                lectureid.setError("LecturerID Starts with LR");
            }}
        else{
            lectureid.setError("LecturerID contain 6 digit");
        }

        String name_val=lecturename.getText().toString().trim();
        if(name_val.isEmpty()){
            lecturename.setError("Required Field");
        }

        String modid_val=moduleid.getText().toString().trim();
        if(modid_val.isEmpty()){
            moduleid.setError("Required Field");
        }else if(modid_val.length()==6 ){
            if(modid_val.startsWith("IT")) {
            } else{
                moduleid.setError("ModuleID start with IT Format");
            }
        }else{
            moduleid.setError("ModuleID contain 6 digit");
        }


        String mail_val=lecemail.getText().toString().trim();
        if(mail_val.isEmpty())
            lecemail.setError("Required Field");


        String incharge_val=lecindet.getText().toString().trim();
        if(incharge_val.isEmpty()){
            lecindet.setError("Required Field");
        }

        helper.UpdateData(lecturerDetails, lectureid.getText().toString(), lecturename.getText().toString(),
                moduleid.getText().toString(),lecemail.getText().toString(),lecindet.getText().toString());

    }

    public void showdata(View view) {

        startActivity(new Intent(this,timetableLec_Activity.class));
    }
}


