package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UserInputsTest {

    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams(){
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void userSelectsListBooksTest()
    {
        String input = "List Books";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserInputs ui = new UserInputs();
        assertEquals(ui.menuUserInput(), "List Books");
    }

    @Test
    public void userSelectsQuitTest()
    {
        String input = "Quit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserInputs ui = new UserInputs();
        assertEquals(ui.menuUserInput(), "Quit");
    }

    @Test
    public void userSelectsInvalidThenValidInputQuitTest()
    {
        String input = "Invalid input\nQuit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String expectedResult = "\r\nSelect a valid option!: ";

        UserInputs ui = new UserInputs();
        assertEquals(ui.menuUserInput(), "Quit");
        assertEquals(expectedResult, outContent.toString());
    }
}
