package com.agung.parking_lot.command;

import com.agung.parking_lot.ApplicationContext;

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
            applicationContext.parkingLot.get(Integer.valueOf(args[0]) - 1).setCar(null);

            System.out.println("Slot number " + args[0] + " is free");
        } catch (NumberFormatException e) {
        }
    }
}
