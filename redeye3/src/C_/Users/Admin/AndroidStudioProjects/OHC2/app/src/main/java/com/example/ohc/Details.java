package com.example.ohc;

public class Details {
    private String date;
    private String name;
    private String age;
    private String dob;
    private String weight;
    private String height;
    private String temp;
    private String pulse;
    private String spo;
    private String bp;
    private String sugar;

    public Details() {
    }

    public Details(String date,String name, String age, String dob, String weight, String height, String temp, String pulse, String spo, String bp, String sugar) {
        this.date=date;
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.weight = weight;
        this.height = height;
        this.temp = temp;
        this.pulse = pulse;
        this.spo = spo;
        this.bp = bp;
        this.sugar = sugar;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getSpo() {
        return spo;
    }

    public void setSpo(String spo) {
        this.spo = spo;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }
}
