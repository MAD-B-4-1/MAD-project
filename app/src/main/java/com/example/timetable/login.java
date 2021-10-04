package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timetable.database.DBHelper;

public class login extends AppCompatActivity {

    EditText username,password;
    Button login;
    DBHelper DB;
    TextView signup1,forgetpass1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=  findViewById(R.id.username);
        password=  findViewById(R.id.loginpassword);
        login= findViewById(R.id.btnLogin);
        signup1 = findViewById(R.id.donthaveacc);
        forgetpass1 =  findViewById(R.id.forgetPassword);
        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(login.this,"please fill all the fields",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true) {
                        Toast.makeText(login.this, "sign in successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), lecturer_profile.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(login.this,"Invalid credentials",Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });

        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent (getApplicationContext(),register.class);
                startActivity(intent);

            }
        });

        forgetpass1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent (getApplicationContext(),password.class);
                startActivity(intent);

            }
        });

    }
}