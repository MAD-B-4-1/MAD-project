package com.example.modulemanagementpro.Database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
    public interface ModuleDAD {
        @Insert
        void insertData(ModuleDetails moduleDetails);

        @Query("SELECT * FROM moduleDetails")
        List<ModuleDetails> selectAll();

        @Update
        void UpdateData(ModuleDetails moduleDetails);

        @Delete
        void DeleteData(ModuleDetails moduleDetails);
    }


