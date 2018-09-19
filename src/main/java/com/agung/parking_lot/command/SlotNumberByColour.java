package com.agung.parking_lot.command;

import com.agung.parking_lot.ApplicationContext;
import com.agung.parking_lot.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class SlotNumberByColour implements Command {

    @Override
    public String toString() {
        return "slot_numbers_for_cars_with_colour";
    }

    @Override
    public void execute(ApplicationContext applicationContext, String... args) {
        if (args.length < 1)
            return;

        List<String> slotNumber = applicationContext.parkingLot.stream().filter(s -> {
            Car car = s.getCar();
            return car != null && car.getColour().equals(args[0]);
        }).map(s -> s.getSlotNumber().toString()).collect(Collectors.toList());

        if (slotNumber.isEmpty()) {
            System.out.println("Not found");
            return;
        }

        System.out.println(String.join(", ", slotNumber));
    }
}
