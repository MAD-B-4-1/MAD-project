package com.example.modulemanagementpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.modulemanagementpro.Adapter.ModuleAdapter;
import com.example.modulemanagementpro.Database.ModuleDetails;
import com.example.modulemanagementpro.Helper.DBHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText moduleid;
    EditText payment;
    EditText credit;
    EditText lecture;
    DBHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = DBHelper.getInstance(this);

        moduleid= findViewById(R.id.moduleid);
        payment = findViewById(R.id.payment);
        credit = findViewById(R.id.credit);
        lecture = findViewById(R.id.lecture);

    }


    public void checkData(View view) {
//        if (!moduleid.getText().toString().isEmpty() && !payment.getText().toString().isEmpty()
//                && !credit.getText().toString().isEmpty() && !lecture.getText().toString().isEmpty()) {
            String modid_val = moduleid.getText().toString().trim();
            if (modid_val.isEmpty()) {
                moduleid.setError("ModuleID Cannot be Empty");
            } else if (modid_val.length() == 4) {
                if (modid_val.startsWith("M")) {
                }else{
                        moduleid.setError("ModuleID Starts with M");
                    }
                } else {
                    moduleid.setError("ModuleID contain 4 digit");
                }

            String payment_val = payment.getText().toString().trim();
            if (payment_val.isEmpty()) {
                payment.setError("Required Field");
            } else if (payment_val.length() == 5) {
                if (payment_val.startsWith("RS")) {
                } else {
                    payment.setError("Payment start with RS Format");
                }
            } else {
                payment.setError("Payment contain 5 digit");
            }

            String lect_val = lecture.getText().toString().trim();
            if (lect_val.isEmpty()) {
                lecture.setError("Required Field");
            }

            String credit_val = credit.getText().toString().trim();
            if (credit_val.isEmpty()) {
                credit.setError("Required Field");
            } else if (credit_val.length() == 0) {
                credit.setError("Only contain one digit");
            }
        }


    public void submitData(View view) {
        if (!moduleid.getText().toString().isEmpty() && !payment.getText().toString().isEmpty() && !credit.getText().toString().isEmpty() && !lecture.getText().toString().isEmpty()) {
            helper.addNew(moduleid.getText().toString(), payment.getText().toString(), credit.getText().toString(), lecture.getText().toString());
        }
    }


    public void showData (View view){
            startActivity(new Intent(this, DataViewerActivity.class));
        }

    }