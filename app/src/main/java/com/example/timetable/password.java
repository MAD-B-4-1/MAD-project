package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.timetable.database.DBHelper;

public class password extends AppCompatActivity {

     EditText newpass,confirmpass,username;
     Button resetpass;
     DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        username= findViewById(R.id.usernamepass);
        newpass= (EditText) findViewById(R.id.passnew);
        confirmpass = (EditText) findViewById(R.id.passconf);
        resetpass = (Button) findViewById(R.id.btnreset);
        DB = new DBHelper(this);

        resetpass.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String user = username.getText().toString();
             String password = newpass.getText().toString();
             String repassword = confirmpass.getText().toString();

             Boolean checkuser= DB.checkusername(user);
             if(checkuser==true) {

                 if (password.equals(repassword)) {

                 Boolean checkpasswordupdate = DB.updatepassword(user, password);
                 if (checkpasswordupdate == true) {
                     Intent intent = new Intent(getApplicationContext(), login.class);
                     startActivity(intent);
                     Toast.makeText(password.this, "password updated successfully", Toast.LENGTH_SHORT).show();
                 } else {
                     Toast.makeText(password.this, "password not updated", Toast.LENGTH_SHORT).show();
                 }
             }
                 else{
                     Toast.makeText(password.this,"password not match",Toast.LENGTH_SHORT).show();
                 }
             }
             else {
                 Toast.makeText(password.this,"username does not exist",Toast.LENGTH_SHORT).show();
             }


              }
        });


    }
}