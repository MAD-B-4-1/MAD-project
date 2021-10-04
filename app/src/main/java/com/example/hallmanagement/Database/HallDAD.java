package com.example.hallmanagement.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface HallDAD {
    @Insert
    void insertData(HallDetails hallDetails);

    @Query("SELECT * FROM hallDetails")
    List<HallDetails> selectAll();

    @Update
    void UpdateData(HallDetails hallDetails);

    @Delete
    void DeleteData(HallDetails hallDetails);
}



