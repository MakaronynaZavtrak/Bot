package org.example;

import java.io.InputStream;

import java.util.Scanner;

/**
 * Класс консольного бота для 1 задания.
 */
public class ConsoleBot implements BotInterface  {
    @Override
    public String  sayInfo(){
        return "Привет! Меня зовут Бот-Фёдор!\n" +
                "Я ещё мало что умею делать, но со временем стану более функциональным.\n" +
                "А пока я просто умею выводить твои сообщения на экран.\n" +
                "Чтобы начать пользоваться мною, начни писать мне сообщения!\n" +
                "Если у тебя возникли вопросы, напиши команду \"/help\", и я расскажу тебе, что я умею!";
    }
    @Override
    public String guide(){
        return "В своём арсенале я имею следующие функции:\n" +
                "\"/stop\" - если вы хотите завершить работу с ботом\n" +
                "\"/help\" - если вы хотите узнать, на что я споособен";
    }
    @Override
    public String farewell()
    {
        return "Что ж! Приятно было пообщаться!";
    }
    @Override
    public void answer(String instr)
    {
        if (instr.equals("/help"))
        {
            println(guide());
        } else if (instr.equals("/stop")){
            print(farewell());
        } else {
            println(instr);
        }
    }

    /**
     * Функция, которая содержит цикл для работы бота.
     * Выход из цикла осуществляется командой.
     */
    public void startBot()
    {
        println(sayInfo());
        boolean isOn = true;
        Scanner sc = new Scanner(System.in);
        String strCheck;
        while (isOn)
        {
            strCheck = sc.nextLine();
            answer(strCheck);
            if (strCheck.equals("/stop"))
            {
                isOn = false;
            }
        }
    }

    /**
     * Функция-конструктор класса ConsoleBot.
     * @param status boolean значение. Если 1, то запускает бота, если 0, то нет.
     */
    public ConsoleBot(boolean status)
    {
        if (status)
        {
            startBot();
        }
    };

    /**
     * Функция, печатающая строку и переводящая курсор на начало новой строки.
     * @param str строка для печати.
     */
    private void println(String str)
    {
        System.out.println(str);
    }
    /**
     * Функция, печатающая строку и оставляющая курсор на конце той же строки.
     * @param str строка для печати.
     */
    private void print(String str)
    {
        System.out.print(str);
    }
}
