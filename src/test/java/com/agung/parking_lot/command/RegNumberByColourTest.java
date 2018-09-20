package com.agung.parking_lot.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegNumberByColourTest extends BaseCommandTest {

    private Command initCmd = new Init();

    private Command parkCmd = new Park();

    private Command regNumberByColourCmd = new RegNumberByColour();

    @Before
    public void setup() {
        super.setup();
        initCmd.execute(applicationContext, "4");
    }

    @Test
    public void testRegNumberByColour() {
        parkCmd.execute(applicationContext, new String[]{"123", "Red"});
        parkCmd.execute(applicationContext, new String[]{"1234", "White"});
        parkCmd.execute(applicationContext, new String[]{"12345", "White"});
        parkCmd.execute(applicationContext, new String[]{"123456", "Black"});

        regNumberByColourCmd.execute(applicationContext, "White");

        assertEquals("1234, 12345", getLastLineOutput());
    }

    @Test
    public void testRegNumberByColourNotFound() {
        parkCmd.execute(applicationContext, new String[]{"123", "Red"});
        parkCmd.execute(applicationContext, new String[]{"1234", "White"});
        parkCmd.execute(applicationContext, new String[]{"12345", "White"});
        parkCmd.execute(applicationContext, new String[]{"123456", "Black"});

        regNumberByColourCmd.execute(applicationContext, "Blue");

        assertEquals("Not found", getLastLineOutput());
    }

}
