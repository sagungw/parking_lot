package com.agung.parking_lot.model;

public class Car {

    private String number;

    private String colour;

    public Car(String number, String colour) {
        this.number = number;
        this.colour = colour;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
