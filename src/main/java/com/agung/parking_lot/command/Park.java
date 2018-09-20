package com.agung.parking_lot.command;

import com.agung.parking_lot.ApplicationContext;
import com.agung.parking_lot.model.Car;
import com.agung.parking_lot.model.ParkingSlot;

public class Park implements Command {

    @Override
    public String toString() {
        return "park";
    }

    @Override
    public void execute(ApplicationContext applicationContext, String... args) {
        if (args.length < 2 || applicationContext.parkingLot == null)
            return;

        ParkingSlot slot = applicationContext.parkingLot.stream().filter(p -> p.getCar() == null).findFirst().orElse(null);
        if (slot == null) {
            System.out.println("Sorry, parking lot is full");
            return;
        }

        slot.setCar(new Car(args[0], args[1]));
        System.out.println("Allocated slot number: " + slot.getSlotNumber());
    }
}
