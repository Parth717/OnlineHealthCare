package com.example.ohc;

public class Medicine {
    private String name;
    private String cost;

    public Medicine() {
    }

    public Medicine(String name, String cost) {
        this.name = name;
        this.cost = cost;
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
