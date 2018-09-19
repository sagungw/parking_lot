package com.agung.parking_lot.command;

import com.agung.parking_lot.ApplicationContext;
import com.agung.parking_lot.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RegNumberByColour implements Command {

    @Override
    public String toString() {
        return "registration_numbers_for_cars_with_colour";
    }

    @Override
    public void execute(ApplicationContext applicationContext, String... args) {
        if (args.length < 1)
            return;

        List<String> carNumber = applicationContext.parkingLot.stream().filter(s -> {
            Car car = s.getCar();
            return car != null && car.getColour().equals(args[0]);
        }).map(s -> s.getCar().getNumber()).collect(Collectors.toList());

        if (carNumber.isEmpty()) {
            System.out.println("Not found");
            return;
        }

        System.out.println(String.join(", ", carNumber));
    }
}
