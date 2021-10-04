package com.example.modulemanagementpro.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities={ModuleDetails.class},version=1)
    public abstract class ModuleDatabase extends RoomDatabase {
        public abstract ModuleDAD moduleDAD();
    }


