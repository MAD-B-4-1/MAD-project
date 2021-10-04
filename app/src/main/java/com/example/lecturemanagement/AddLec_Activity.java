package com.example.lecturemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.lecturemanagement.Helper.DBHelper;

public class AddLec_Activity extends AppCompatActivity {

    EditText moduleid,namelec,idlec,maillec,inchalec;

    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lec);


        helper = DBHelper.getInstance(this);

        moduleid= findViewById(R.id.moduleid);
        namelec = findViewById(R.id.lecname);
        idlec = findViewById(R.id.lectID);
        maillec = findViewById(R.id.lecmail);
        inchalec = findViewById(R.id.lecincha);

    }

    public void submitData(View view) {
        // if (!moduleid.getText().toString().isEmpty() && !namelec.getText().toString().isEmpty() && !idlec.getText().toString().isEmpty() && !maillec.getText().toString().isEmpty() && !inchalec.getText().toString().isEmpty() )


        String lecid_val = idlec.getText().toString().trim();
        if (lecid_val.isEmpty()) {
            idlec.setError("LecturerID Cannot be Empty");
        } else if (lecid_val.length()==6) {
            if (lecid_val.startsWith("LR")) {
            } else {
                idlec.setError("LecturerID Starts with LR");
            }}
        else{
            idlec.setError("LecturerID contain 6 digit");
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

        String name_val=namelec.getText().toString().trim();
        if(name_val.isEmpty()){
            namelec.setError("Required Field");
        }

        String mail_val=maillec.getText().toString().trim();
        if(mail_val.isEmpty()){
            maillec.setError("Required Field");
       /* }else if(mail_val.length()==0){
            credit.setError("Only contain one digit");*/
        }
        String incharge_val=inchalec.getText().toString().trim();
        if(incharge_val.isEmpty()){
            inchalec.setError("Required Field");
        }

        helper.addNew( idlec.getText().toString(), namelec.getText().toString(),  moduleid.getText().toString(), maillec.getText().toString(),inchalec.getText().toString());
    }

    public void showData(View view){

        startActivity(new Intent(this,timetableLec_Activity.class));
    }



}
