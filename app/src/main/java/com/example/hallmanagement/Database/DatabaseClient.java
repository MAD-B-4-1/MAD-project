package com.example.hallmanagement.Database;


import android.content.Context;
import androidx.room.Room;

public class DatabaseClient {
    Context context;
    static DatabaseClient client;
    HallDatabase hallDatabase;

    public DatabaseClient(Context context){
        this.context=context;

        hallDatabase= Room.databaseBuilder(context,HallDatabase.class,"HallDatabase").build();
    }

    public static synchronized DatabaseClient getInstance(Context context){
        if(client==null){
            client=new DatabaseClient(context);
        }
        return client;
    }

    public HallDatabase getHallDatabase(){

        return hallDatabase;
    }
}
