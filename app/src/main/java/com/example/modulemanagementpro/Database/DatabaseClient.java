package com.example.modulemanagementpro.Database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {
    Context context;
    static DatabaseClient client;
    ModuleDatabase moduleDatabase;

    public DatabaseClient(Context context){
        this.context=context;

        moduleDatabase= Room.databaseBuilder(context,ModuleDatabase.class,"ModuleDatabase").build();
    }

    public static synchronized DatabaseClient getInstance(Context context){
        if(client==null){
            client=new DatabaseClient(context);
        }
        return client;
    }

    public ModuleDatabase getModuleDatabase(){
        return moduleDatabase;
    }
}

