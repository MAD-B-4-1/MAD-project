package com.example.modulemanagementpro.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class ModuleDetails implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="moduleID")
    private String moduleID;

    @ColumnInfo(name="payment")
    private String payment;

    @ColumnInfo(name="credit")
    private String credit;

    @ColumnInfo(name="lecturer")
    private String lecturer;

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    @NonNull
    @Override
    public String toString() {
        return "ModuleDetails{" +
                "moduleID='" + moduleID + '\'' +
                ", payment='" + payment + '\'' +
                ", credit=" + credit +
                ", lecturer='" + lecturer + '\'' +
                '}';
    }
}

