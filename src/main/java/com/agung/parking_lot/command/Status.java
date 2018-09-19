package com.agung.parking_lot.command;

import com.agung.parking_lot.ApplicationContext;

public class Status implements Command {

    @Override
    public String toString() {
        return "status";
    }

    @Override
    public void execute(ApplicationContext applicationContext, String... args) {
        String format = "%-12s%-19s%-6s\n";
        System.out.printf(format, "Slot No.", "Registration No", "Colour");
        applicationContext.parkingLot.forEach(s -> {
            if (s.getCar() != null)
                System.out.printf(format, s.getSlotNumber().toString(), s.getCar().getNumber(), s.getCar().getColour());
        });
    }
}
