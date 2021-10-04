package com.example.modulemanagementpro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.modulemanagementpro.Adapter.ModuleAdapter;
import com.example.modulemanagementpro.Database.ModuleDetails;
import com.example.modulemanagementpro.Helper.DBHelper;

import java.util.List;

public class DataViewerActivity extends AppCompatActivity {
    RecyclerView recycler_view;
    ModuleAdapter moduleadapter;
    DBHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_viewer);
        helper=DBHelper.getInstance(this);
        recycler_view =findViewById(R.id.recycler_view);
        helper.getAlldata();
    }

    public void setRecyclerview(List<ModuleDetails> moduleDetailsList){
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        moduleadapter=new ModuleAdapter(this,moduleDetailsList);
        recycler_view.setAdapter(moduleadapter);
    }


    public void adddetail(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}