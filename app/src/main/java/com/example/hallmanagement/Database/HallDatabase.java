package com.example.hallmanagement.Database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities={HallDetails.class},version=1)
public abstract class HallDatabase extends RoomDatabase {
    public abstract HallDAD hallDAD();
}