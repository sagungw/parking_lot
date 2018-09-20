package com.agung.parking_lot.command;

import com.agung.parking_lot.ApplicationContext;
import com.agung.parking_lot.model.ParkingSlot;

import java.util.ArrayList;

public class Init implements Command {

    @Override
    public String toString() {
        return "create_parking_lot";
    }

    @Override
    public void execute(ApplicationContext applicationContext, String... args) {
        if (args.length < 1)
            return;

        try {
            applicationContext.parkingLot = new ArrayList<>();
            for (int i = 0; i < Integer.valueOf(args[0]); i++)
                applicationContext.parkingLot.add(new ParkingSlot(i + 1));

            System.out.println("Created a parking lot with " + args[0] + " slots");
        } catch (NumberFormatException e) {
        }
    }
}
