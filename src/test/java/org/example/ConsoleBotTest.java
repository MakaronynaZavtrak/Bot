package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
     * <p>Тестирует метод handleMessage класса ConsoleBot.</p>
     * Сравнивает handleMessage() с аргументами "Some message", "/help", "/stop"
     * со строками, которые должны быть выбраны методом после его работы.
     */

    @Test
    public void handleMessageTest()
    {
        //создаем экземпляр бота
        ConsoleBot cBot = new ConsoleBot(false);
        //заводим массив входных и заполняем его
        String[] strIn = new String[3];
        strIn[0] = "Some message";
        strIn[1] = "/help";
        strIn[2] = "/stop";
        //заводим массив ожидаемого отклика метода и заполняем его
        String[] expectedOut = new String[3];
        expectedOut[0] = "Some message";
        expectedOut[1] = "В своём арсенале я имею следующие функции:\n" +
                "\"/stop\" - если вы хотите завершить работу с ботом\n" +
                "\"/help\" - если вы хотите узнать, на что я споособен";//текст из метода guide()
        expectedOut[2] = "Что ж! Приятно было пообщаться!";//текст из метода farewell()
        //сравниваем метод от аргументов из массива strIn с массивом expectedOut поэлементно.
        for (int i = 0; i < 3; i++)
        {
            assertEquals(expectedOut[i], cBot.handleMessage(strIn[i]));
        }
    }
}
