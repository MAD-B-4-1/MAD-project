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

public class register extends AppCompatActivity {

    //initialize variable
    EditText username,password,repassword,name,mail,education;
    Button signup;
    TextView signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //assign variable
        DB= new DBHelper(this);
        username=  findViewById(R.id.inputStudentID);
        password=  findViewById(R.id.inputPassword);
        repassword=  findViewById(R.id.inputConfPas);
        name=  findViewById(R.id.inputName);
        mail=  findViewById(R.id.inputEmailAdd);
        education=  findViewById(R.id.edu);

        signup=  findViewById(R.id.btnsignup);
        signin= findViewById(R.id.havacc);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nam = name.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String email = mail.getText().toString();
                String edu = education.getText().toString();


                if( nam.equals("")|| user.equals("")||pass.equals("")||repass.equals("")||email.equals("")||edu.equals(""))
                    Toast.makeText(register.this, "please fill all the fields", Toast.LENGTH_SHORT).show();
                 else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            if (user.length() == 6) {
                                Boolean insert = DB.insertData(nam, user, pass, email, edu);
                                if (insert == true) {
                                    Toast.makeText(register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent1 = new Intent(getApplicationContext(), student_profile.class);
                                    intent1.putExtra("username", user);
                                    intent1.putExtra("name", nam);
                                    intent1.putExtra("mail", email);
                                    intent1.putExtra("education", edu);

                                    startActivity(intent1);
                                } else {
                                    Toast.makeText(register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                }
                            } else{
                                Toast.makeText(register.this, "Username contain only 6 digits", Toast.LENGTH_SHORT).show();
                            }
                        }

                        else {
                            Toast.makeText(register.this, "User Already Exists! Please sign-in", Toast.LENGTH_SHORT).show();
                             }
                    }
                    else {
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