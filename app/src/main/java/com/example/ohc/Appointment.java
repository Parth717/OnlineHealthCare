package com.example.ohc;

public class Appointment {
    private String title;
    private String fullname;
    private String address;
    private String contact;
    private String fees;
    private String date;
    private String time;
    private String key;

    public Appointment(String title, String fullname, String address, String contact, String fees, String date, String time) {
        this.title = title;
        this.fullname = fullname;
        this.address = address;
        this.contact = contact;
        this.fees = fees;
        this.date = date;
        this.time = time;
        this.key=key;
    }

    public Appointment() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
