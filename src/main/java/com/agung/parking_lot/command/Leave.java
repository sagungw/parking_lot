package com.agung.parking_lot.command;

import com.agung.parking_lot.ApplicationContext;
import com.agung.parking_lot.model.ParkingSlot;

public class Leave implements Command {

    @Override
    public String toString() {
        return "leave";
    }

    @Override
    public void execute(ApplicationContext applicationContext, String... args) {
        if (args.length < 1)
            return;

        try {
            ParkingSlot s = applicationContext.parkingLot.get(Integer.valueOf(args[0]) - 1);
            if (s != null) {
                if (s.getCar() != null) {
                    s.setCar(null);
                    System.out.println("Slot number " + args[0] + " is free");
                }
            }
        } catch (NumberFormatException e) {
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
