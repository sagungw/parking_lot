package com.agung.parking_lot.command;

import com.agung.parking_lot.model.ParkingSlot;
import org.junit.Test;

import static org.junit.Assert.*;

public class InitTest extends BaseCommandTest {

    private Command initCmd = new Init();

    @Test
    public void testApplicationContextInitialized() {
        assertNull(applicationContext.parkingLot);
        assertTrue(applicationContext.appRun);
    }

    @Test
    public void testParkingLotInitialized() {
        initCmd.execute(applicationContext, "10");

        for (ParkingSlot p: applicationContext.parkingLot)
            assertNull(p.getCar());
        assertEquals(10, applicationContext.parkingLot.size());
        assertEquals("Created a parking lot with 10 slots\n", outContent.toString());
    }

    @Test
    public void testCommandIgnoredWhenNoArgs() {
        assertNull(applicationContext.parkingLot);
        assertEquals("", outContent.toString());
    }

}
