package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsoleBotTest{
@Test
    public void writeTest()
    {
        ConsoleBot bot = new ConsoleBot();
        String[] strIn = new String[3];
        strIn[0] = "Some message";
        strIn[1] = "/help";
        strIn[2] = "/stop";

        String[] expectedOut = new String[3];
        expectedOut[0] = "Some message";
        expectedOut[1] = bot.guide();
        expectedOut[2] = "Что ж! Приятно было пообщаться!";

        for (int i = 0; i < 3; i++)
        {
            assertEquals(expectedOut[i], bot.write(strIn[i]));
        }
    }
}
