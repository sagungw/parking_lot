package com.agung.parking_lot.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SlotNumberByColourTest extends BaseCommandTest {

    private Command initCmd = new Init();

    private Command parkCmd = new Park();

    private Command slotNumberByColourCmd = new SlotNumberByColour();

    @Before
    public void setup() {
        super.setup();
        initCmd.execute(applicationContext, "4");
    }

    @Test
    public void testSlotNumberByColour() {
        parkCmd.execute(applicationContext, new String[]{"123", "Red"});
        parkCmd.execute(applicationContext, new String[]{"1234", "White"});
        parkCmd.execute(applicationContext, new String[]{"12345", "White"});
        parkCmd.execute(applicationContext, new String[]{"123456", "Black"});

        slotNumberByColourCmd.execute(applicationContext, "White");

        assertEquals("2, 3", getLastLineOutput());
    }

    @Test
    public void testSlotNumberByColourNotFound() {
        parkCmd.execute(applicationContext, new String[]{"123", "Red"});
        parkCmd.execute(applicationContext, new String[]{"1234", "White"});
        parkCmd.execute(applicationContext, new String[]{"12345", "White"});
        parkCmd.execute(applicationContext, new String[]{"123456", "Black"});

        slotNumberByColourCmd.execute(applicationContext, "Blue");

        assertEquals("Not found", getLastLineOutput());
    }

}
