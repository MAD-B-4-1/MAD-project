package com.example.lecturemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lecturemanagement.Adapter.LectureAdapter;
import com.example.lecturemanagement.Database.LecturerDetails;
import com.example.lecturemanagement.Helper.DBHelper;

import java.util.List;

public class timetableLec_Activity extends AppCompatActivity {

    RecyclerView recycler_view;
    LectureAdapter lectureradapter;
    DBHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_lec);

        helper=DBHelper.getInstance(this);
        recycler_view =findViewById(R.id.recycler_view);
        helper.getAlldata();
    }

    public void setRecyclerview(List<LecturerDetails> lecturerDetailsList){
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        lectureradapter=new LectureAdapter(this,lecturerDetailsList);
        recycler_view.setAdapter(lectureradapter);
    }

    public void adddetail(View view){
        Intent intent=new Intent(this,AddLec_Activity.class);
        startActivity(intent);
    }


}


