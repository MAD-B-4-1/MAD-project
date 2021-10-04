package com.example.hallmanagement;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hallmanagement.Adapter.HallAdapter;
import com.example.hallmanagement.Database.HallDetails;
import com.example.hallmanagement.Helper.DBHelper;

import java.util.List;

public class DataViewerActivity extends AppCompatActivity {
    RecyclerView recycler_view;
    HallAdapter halladapter;
    DBHelper helper;

    @Override
    protected void onCreate( Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_viewer);

        helper=DBHelper.getInstance(this);
        recycler_view =findViewById(R.id.recycler_view);
        helper.getAlldata();
    }

    public void setRecyclerview(List<HallDetails> hallDetailsList){
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        halladapter=new HallAdapter(this,hallDetailsList);
        recycler_view.setAdapter(halladapter);
    }

    public void adddetail(View view){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}

