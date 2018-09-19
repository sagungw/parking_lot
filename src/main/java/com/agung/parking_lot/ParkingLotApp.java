package com.agung.parking_lot;

import com.agung.parking_lot.command.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotApp {

    private static ApplicationContext applicationContext;

    private static Map<String, Command> availableCommands;

    public static void main(String[] args) {
        init();

        if (args.length > 0) {
            try {
                Files.lines(FileSystems.getDefault().getPath(args[1])).forEach(ParkingLotApp::processInput);
            } catch (IOException e) {
            }
        }

        while (applicationContext.appRun) {
            try {
                BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
                processInput(r.readLine());
            } catch (IOException e) {
            }
        }
    }

    private static void processInput(String inputLine) {
        String[] input = inputLine.split(" ");
        if (input.length > 0)
            availableCommands.get(input[0]).execute(applicationContext, Arrays.copyOfRange(input, 0, input.length));
    }

    private static void init() {
        applicationContext = new ApplicationContext();

        availableCommands = new HashMap<>();
        Command c = new Exit();
        availableCommands.put(c.toString(), c);
        c = new Init();
        availableCommands.put(c.toString(), c);
        c = new Leave();
        availableCommands.put(c.toString(), c);
        c = new Park();
        availableCommands.put(c.toString(), c);
        c = new RegNumberByColour();
        availableCommands.put(c.toString(), c);
        c = new SlotNumberByColour();
        availableCommands.put(c.toString(), c);
        c = new SlotNumberByRegNumber();
        availableCommands.put(c.toString(), c);
        c = new Status();
        availableCommands.put(c.toString(), c);
    }

}
