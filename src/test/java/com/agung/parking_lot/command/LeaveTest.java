package com.agung.parking_lot.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeaveTest extends BaseCommandTest {

    private Command initCmd = new Init();

    private Command parkCmd = new Park();

    private Command leaveCmd = new Leave();

    @Before
    public void setup() {
        super.setup();
        initCmd.execute(applicationContext, "1");
    }

    @Test
    public void testParkingSlotNullified() {
        parkCmd.execute(applicationContext, new String[]{"123", "Red"});
        leaveCmd.execute(applicationContext, "1");

        assertNull(applicationContext.parkingLot.get(1 - 1).getCar());
        assertEquals("Slot number 1 is free", getLastLineOutput());
    }

    @Test
    public void testCommandIgnoredWhenLackArgs() {
        parkCmd.execute(applicationContext, new String[]{"123", "Red"});
        leaveCmd.execute(applicationContext, new String[]{});

        assertNotNull(applicationContext.parkingLot.get(1 - 1).getCar());
        assertNotEquals("Slot number 1 is free", getLastLineOutput());
    }

}
