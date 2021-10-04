package com.example.lecturemanagement.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LecturerDAD {
    @Insert
    void insertData(LecturerDetails lecturerDetails);

    @Query("SELECT * FROM lecturerDetails")
    List<LecturerDetails> selectAll();

    @Update
    void UpdateData(LecturerDetails lecturerDetails);

    @Delete
    void DeleteData(LecturerDetails lecturerDetails);
}