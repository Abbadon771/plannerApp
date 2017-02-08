package com.example.abbadon.moblieappsfinal2;

/**
 * Created by Abbadon on 12/12/2016.
 */

public class MedicalSorter {

    private String Title;
    private String Date;
    private String Time;
    private String Profession;
    private String Reason;

    public MedicalSorter(String title, String day, String month, String time, String profession, String reason)
    {
        Title = "Title: " + title;
        Date = month + ", " + day;
        Time = time;
        Profession = "Medical: " + profession;
        Reason = "Reason: " + reason;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }
}