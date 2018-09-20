package com.agung.parking_lot.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SlotNumberByRegNumberTest extends BaseCommandTest {

    private Command initCmd = new Init();

    private Command parkCmd = new Park();

    private Command slotNumberByRegNumber = new SlotNumberByRegNumber();

    @Before
    public void setup() {
        super.setup();
        initCmd.execute(applicationContext, "4");
    }

    @Test
    public void testSlotNumberByRegNumber() {
        parkCmd.execute(applicationContext, new String[]{"123", "Red"});
        parkCmd.execute(applicationContext, new String[]{"1234", "White"});
        parkCmd.execute(applicationContext, new String[]{"12345", "White"});
        parkCmd.execute(applicationContext, new String[]{"123456", "Black"});

        slotNumberByRegNumber.execute(applicationContext, "12345");

        assertEquals("3", getLastLineOutput());
    }

    @Test
    public void testSlotNumberByRegNumberNotFound() {
        parkCmd.execute(applicationContext, new String[]{"123", "Red"});
        parkCmd.execute(applicationContext, new String[]{"1234", "White"});
        parkCmd.execute(applicationContext, new String[]{"12345", "White"});
        parkCmd.execute(applicationContext, new String[]{"123456", "Black"});

        slotNumberByRegNumber.execute(applicationContext, "12345111");

        assertEquals("Not found", getLastLineOutput());
    }

}
