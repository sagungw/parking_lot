package com.agung.parking_lot;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

public class FileTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("fixture.txt").getFile());

        FileHelper fileHelper = Mockito.mock(FileHelper.class);
        Mockito.when(fileHelper.getFileAsPath(Mockito.anyString())).thenReturn(file.toPath());

        ParkingLotApp.fileHelper = fileHelper;
    }

    @After
    public void cleanup() {
        System.setOut(originalOut);
    }

    @Test
    public void testFile() {
        String[] args = new String[1];
        args[0] = "";
        ParkingLotApp.main(args);

        String expected =
            "Created a parking lot with 6 slots\n" +
            "Allocated slot number: 1\n" +
            "Allocated slot number: 2\n" +
            "Allocated slot number: 3\n" +
            "Allocated slot number: 4\n" +
            "Allocated slot number: 5\n" +
            "Allocated slot number: 6\n" +
            "Slot number 4 is free\n" +
            "Slot No.    Registration No    Colour\n" +
            "1           KA-01-HH-1234      White \n" +
            "2           KA-01-HH-9999      White \n" +
            "3           KA-01-BB-0001      Black \n" +
            "5           KA-01-HH-2701      Blue  \n" +
            "6           KA-01-HH-3141      Black \n" +
            "Allocated slot number: 4\n" +
            "Sorry, parking lot is full\n" +
            "KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333\n" +
            "1, 2, 4\n" +
            "6\n" +
            "Not found\n";

        Assert.assertEquals(expected, outContent.toString());
    }

}
