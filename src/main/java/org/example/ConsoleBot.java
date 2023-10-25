package org.example;

import java.io.InputStream;

import java.util.Scanner;

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
    public ConsoleBot(boolean status)
    {
        if (status)
        {
            startBot();
        }
    };

    private void println(String str)
    {
        System.out.println(str);
    }
    private void print(String str)
    {
        System.out.print(str);
    }

    //TODO: сделать метод для работы бота в консоли. и тест к нему
}
