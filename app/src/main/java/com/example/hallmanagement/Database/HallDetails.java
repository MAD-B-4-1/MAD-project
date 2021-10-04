package com.example.hallmanagement.Database;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class HallDetails implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="hallID")
    private String hallID;

    @ColumnInfo(name="time")
    private String time;

    @ColumnInfo(name="module_id")
    private String module_id;

    @ColumnInfo(name="module_name")
    private String module_name;

    @ColumnInfo(name="lecturer_name")
    private String lecturer_name ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHallID() {
        return hallID;
    }

    public void setHallID(String hallID) {
        this.hallID = hallID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getModule_id() {
        return module_id;
    }

    public void setModule_id(String module_id) {
        this.module_id = module_id;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getLecturer_name() {
        return lecturer_name;
    }

    public void setLecturer_name(String lecturer_name) {
        this.lecturer_name = lecturer_name;
    }

    @NonNull
    @Override
    public String toString() {
        return "HallDetails{" +
                "id=" + id +
                ", hallID='" + hallID + '\'' +
                ", time='" + time + '\'' +
                ", module_id='" + module_id + '\'' +
                ", module_name='" + module_name + '\'' +
                ", lecturer_name='" + lecturer_name + '\'' +
                '}';
    }
}


