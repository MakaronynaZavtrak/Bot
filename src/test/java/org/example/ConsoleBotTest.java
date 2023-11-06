package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

/**
 * Класс для тестирования методов ConsoleBot
 */
public class ConsoleBotTest{
    /**
     * Поток, который будет использоваться для текста, выводящегося в консоль.
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    /**
     * Поток, который будет использоваться для текста об ошибках, выводящихся в консоль.
     */
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    /**
     * Стандартный поток вывода.
     */
    private final PrintStream originalOut = System.out;
    /**
     * Стандартный поток вывода для ошибок.
     */
    private final PrintStream originalErr = System.err;

    /**
     * Метод, который срабатывает перед тестами и заменяет потоки вывода.
     */
    @Before
    public void setUpStreams()
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    /**
     * Метод, который срабатывает после тестов и устанавливает стандартные потоки вывода.
     */
    @After
    public void restoreStreams()
    {
        System.setOut(originalOut);
        System.setOut(originalErr);
    }

    /**
     * Тестирует answer на ответы
     */
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
