package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timetable.database.DBHelper;
import com.google.android.material.textfield.TextInputEditText;


public class student_profile extends AppCompatActivity {
    DBHelper DB;
    TextView name, ID;
    TextInputEditText inname, inmail, inedu;
    Button updatebtn, btnchangepass;
    String nam,user,email,edu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        DB = new DBHelper(this);
        name =  findViewById(R.id.stuname);
        ID =  findViewById(R.id.studentid);
        inname = findViewById(R.id.inputfirst);
        inmail =  findViewById(R.id.inputmail);
        inedu =  findViewById(R.id.inputeduqua);
        updatebtn =  findViewById(R.id.btnupdate);
        btnchangepass =  findViewById(R.id.btnpasschn);


        nam = getIntent().getExtras().getString("name");
        name.setText(nam);
        inname.setText(nam);
        user = getIntent().getExtras().getString("username");
        ID.setText(user);
        email = getIntent().getExtras().getString("mail");
        inmail.setText(email);
        edu = getIntent().getExtras().getString("education");
        inedu.setText(edu);


        btnchangepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), password.class);
                startActivity(intent);
            }
        });


        updatebtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View view){
        String iname = inname.getText().toString();
        String imail = inmail.getText().toString();
        String iedu = inedu.getText().toString();

        Boolean checkupdatedata = DB.updateData(iname, imail, iedu);
        if (checkupdatedata == true)
            Toast.makeText(student_profile.this, "entry updated", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(student_profile.this, "new entry not inserted", Toast.LENGTH_SHORT).show();
    }

    });

    /*Cursor cursor = DB.getdata();

    showAlldata();*/

}
   /* private void showAlldata() {
            Intent intent = getIntent();
            String user_username = intent.getStringExtra("username");
            String user_name = intent.getStringExtra("name");
            String user_mail = intent.getStringExtra("mail");
            String user_educa = intent.getStringExtra("education");

            name.setText(user_name);
            ID.setText(user_username);
            inname.setText(user_name);
            inmail.setText(user_mail);
            inedu.setText(user_educa);
    }*/
}

