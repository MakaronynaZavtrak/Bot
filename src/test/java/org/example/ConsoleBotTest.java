package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class ConsoleBotTest{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    @Before
    public void setUpStreams()
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    @After
    public void restoreStreams()
    {
        System.setOut(originalOut);
        System.setOut(originalErr);
    }
@Test
    public void answerTest()
    {
        ConsoleBot cBot = new ConsoleBot(false);

        String[] strIn = new String[3];
        strIn[0] = "Some message";
        strIn[1] = "/help";
        strIn[2] = "/stop";

        String[] expectedOut = new String[3];
        expectedOut[0] = "Some message" + "\r\n";
        expectedOut[1] = "В своём арсенале я имею следующие функции:\n" +
                "\"/stop\" - если вы хотите завершить работу с ботом\n" +
                "\"/help\" - если вы хотите узнать, на что я споособен"+"\r\n";
        expectedOut[2] = "Что ж! Приятно было пообщаться!";

        for (int i = 0; i < 3; i++)
        {
            cBot.answer(strIn[i]);
            assertEquals(expectedOut[i], outContent.toString());
            outContent.reset();
        }
    }
}
