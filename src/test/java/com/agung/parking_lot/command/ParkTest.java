package com.agung.parking_lot.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkTest extends BaseCommandTest {

    private Command initCmd = new Init();

    private Command parkCmd = new Park();

    @Before
    public void setup() {
        super.setup();
        initCmd.execute(applicationContext, "2");
    }

    @Test
    public void testNearestSlotFilled() {
        parkCmd.execute(applicationContext, new String[]{"123", "White"});

        assertEquals("123", applicationContext.parkingLot.stream().filter(s -> s.getSlotNumber() == 1).findFirst().get().getCar().getNumber());
        assertEquals("Allocated slot number: 1", getLastLineOutput());
    }

    @Test
    public void testParkingLotFull() {
        parkCmd.execute(applicationContext, new String[]{"123", "White"});
        parkCmd.execute(applicationContext, new String[]{"1234", "White"});
        parkCmd.execute(applicationContext, new String[]{"12345", "White"});

        assertEquals("Sorry, parking lot is full", getLastLineOutput());
    }
}
