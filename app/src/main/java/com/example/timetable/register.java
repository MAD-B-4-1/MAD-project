package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText username,password,repassword,name,mail,education;
    Button signup;
    TextView signin;
DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username= (EditText) findViewById(R.id.inputStudentID);
        password= (EditText) findViewById(R.id.inputPassword);
        repassword= (EditText) findViewById(R.id.inputConfPas);
        name= (EditText) findViewById(R.id.inputName);
        mail= (EditText) findViewById(R.id.inputEmailAdd);
        education= (EditText) findViewById(R.id.edu);

        signup= (Button) findViewById(R.id.btnsignup);
        signin= (TextView) findViewById(R.id.havacc);
        DB= new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String nam = name.getText().toString();
                String email = mail.getText().toString();
                String edu = education.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals("")||nam.equals("")||email.equals("")||edu.equals(""))
                    Toast.makeText(register.this,"please fill all the fields",Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user,nam, pass, email, edu);
                            if (checkuser == true) {
                                Toast.makeText(register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent1 = new Intent(getApplicationContext(),student_profile.class);
                                intent1.putExtra("username",user);
                                intent1.putExtra("name",nam);
                                intent1.putExtra("mail",email);
                                intent1.putExtra("education",edu);

                                Intent intent = new Intent(getApplicationContext(), student_profile.class);
                               startActivity(intent);
                            } else {
                                Toast.makeText(register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(register.this, "User Already Exists! Please sign-in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(register.this, "Password not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent (getApplicationContext(),login.class);
                startActivity(intent);

            }
        });
    }
}