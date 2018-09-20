package com.agung.parking_lot.command;

import com.agung.parking_lot.ApplicationContext;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BaseCommandTest {

    protected ApplicationContext applicationContext;

    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    protected final PrintStream originalOut = System.out;

    @Before
    public void setup() {
        applicationContext = new ApplicationContext();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanup() {
        System.setOut(originalOut);
    }

    protected String getLastLineOutput() {
        String[] lines = outContent.toString().split("\n");
        if (lines.length < 1)
            return "";

        return lines[lines.length - 1];
    }

}
