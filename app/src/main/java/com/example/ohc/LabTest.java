package com.example.ohc;

public class LabTest {
    private String name;
    private String cost;

    public LabTest(String name, String cost) {
        this.name = name;
        this.cost = cost;
    }

    public LabTest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
