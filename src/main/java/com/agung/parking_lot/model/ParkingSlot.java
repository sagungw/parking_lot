package com.agung.parking_lot.model;

public class ParkingSlot {

    private Car car;

    private Integer slotNumber;

    public ParkingSlot(int slotNumber){
        this.slotNumber = slotNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }
}
