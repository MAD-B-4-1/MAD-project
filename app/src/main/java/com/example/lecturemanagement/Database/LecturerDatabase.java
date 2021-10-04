package com.example.lecturemanagement.Database;


import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities={LecturerDetails.class},version=1)
public  abstract class LecturerDatabase extends RoomDatabase {
    public abstract LecturerDAD LectureDAD();
}
