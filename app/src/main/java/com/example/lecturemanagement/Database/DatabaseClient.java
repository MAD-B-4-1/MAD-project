package com.example.lecturemanagement.Database;

import android.content.Context;
import androidx.room.Room;

public class DatabaseClient {
    Context context;
    static DatabaseClient client;
    com.example.lecturemanagement.Database.LecturerDatabase LecturerDatabase;

    public DatabaseClient(Context context){
        this.context=context;

        LecturerDatabase = Room.databaseBuilder(context, LecturerDatabase.class,"LecturerDatabase").build();
    }

    public static synchronized DatabaseClient getInstance(Context context){
        if(client==null){
            client=new DatabaseClient(context);
        }
        return client;
    }

    public LecturerDatabase getLecturerDatabase(){

        return LecturerDatabase;
    }
}


