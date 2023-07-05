package com.example.software_project;

public class MedicalReportModel {
    String Name;
    String Date;
    String Time;
    String Systolic;
    String Diastolic;
    String HeartRate;
    String Comment;

    public MedicalReportModel(String name, String date, String time, String systolic,String diastolic,String heartRate,String comment) {
        Name = name;
        Date = date;
        Time = time;
        Systolic = systolic;
        Diastolic = diastolic;
        HeartRate = heartRate;
        Comment = comment;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSystolic() {
        return Systolic;
    }

    public void setSystolic(String systolic) {
        Systolic = systolic;
    }

    public String getDiastolic() {
        return Diastolic;
    }

    public void setDiastolic(String diastolic) {
        Diastolic = diastolic;
    }

    public String getHeartRate() {
        return HeartRate;
    }

    public void setHeartRate(String heartRate) {
        HeartRate = heartRate;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
