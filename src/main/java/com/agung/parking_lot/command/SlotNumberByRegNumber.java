package com.agung.parking_lot.command;

import com.agung.parking_lot.ApplicationContext;
import com.agung.parking_lot.model.Car;
import com.agung.parking_lot.model.ParkingSlot;

public class SlotNumberByRegNumber implements Command {

    @Override
    public String toString() {
        return "slot_number_for_registration_number";
    }

    @Override
    public void execute(ApplicationContext applicationContext, String... args) {
        if (args.length < 1)
            return;

        ParkingSlot slot = applicationContext.parkingLot.stream().filter(s -> {
            Car car = s.getCar();
            return car != null && car.getNumber().equals(args[0]);
        }).findFirst().orElse(null);

        if (slot == null) {
            System.out.println("Not found");
            return;
        }

        System.out.println(slot.getSlotNumber());
    }
}
