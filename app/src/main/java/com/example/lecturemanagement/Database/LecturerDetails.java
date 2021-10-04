package com.example.lecturemanagement.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class LecturerDetails implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "LectureID")
    private String LectureID;

    @ColumnInfo(name = "Name")
    private String Name;

    @ColumnInfo(name = "ModuleID")
    private String ModuleID;

    @ColumnInfo(name = "E-Mail")
    private String Mail;

    @ColumnInfo(name = "Lecturer_incharge")
    private String lecturer_incharge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLectureID() {
        return LectureID;
    }

    public void setLectureID(String lectureID) {
        LectureID = lectureID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getModuleID() {
        return ModuleID;
    }

    public void setModuleID(String moduleID) {
        ModuleID = moduleID;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getLecturer_incharge() {
        return lecturer_incharge;
    }

    public void setLecturer_incharge(String lecturer_incharge) {
        this.lecturer_incharge = lecturer_incharge; }

    @NonNull
    @Override
    public String toString() {
        return "LecturerDetails{" +
                "id=" + id +
                ", LectureID='" + LectureID + '\'' +
                ", Name='" + Name + '\'' +
                ", ModuleID='" + ModuleID + '\'' +
                ", Mail='" + Mail + '\'' +
                ", lecturer_incharge='" + lecturer_incharge + '\'' +
                '}';
    }
}
