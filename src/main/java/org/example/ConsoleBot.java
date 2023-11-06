package org.example;

import java.io.InputStream;

import java.util.Scanner;

/**
 * Класс консольного бота для 1 задания.
 */
public class ConsoleBot implements BotInterface  {
    /**
     * Переменная status характеризует статус работы бота
     * При значении true бот работает
     * При значении false бот не работает
     */
    private boolean status;

    /**
     *  Возвращает Сообщение-приветствие
     * @return Сообщение-приветствие
     *
     */
    @Override
    public String  sayInfo(){
        return "Привет! Меня зовут Бот-Фёдор!\n" +
                "Я ещё мало что умею делать, но со временем стану более функциональным.\n" +
                "А пока я просто умею выводить твои сообщения на экран.\n" +
                "Чтобы начать пользоваться мною, начни писать мне сообщения!\n" +
                "Если у тебя возникли вопросы, напиши команду \"/help\", и я расскажу тебе, что я умею!";
    }

    /**
     * Возвращает строку-справку функционала бота
     * @return
     * возвращает справку о функционале бота
     */
    @Override
    public String guide(){
        return "В своём арсенале я имею следующие функции:\n" +
                "\"/stop\" - если вы хотите завершить работу с ботом\n" +
                "\"/help\" - если вы хотите узнать, на что я споособен";
    }

    /**
     * Возвращает строку-прощание
     * @return Строка-прощание
     */
    @Override
    public String farewell()
    {
        return "Что ж! Приятно было пообщаться!";
    }

    /**
     * функция, обрабатывающая входящие сообщения
     *<p> @param message</p>
     *<p> /help - возвращает справку о боте.<p>
     *<p> /stop - возвращает сообщение с прощанием и завершает работу.<p>
     *<p> /start - возвращает сообщение с приветствием
     * @return
     */
@Override
    public String handleMessage(String message) {
        switch (message) {
            case "/help" -> {
                return  guide();
            }
            case "/stop" -> {
                status = false;
                return farewell();
            }
            case "/start" -> {
                return sayInfo();
            }
        }
        return message;
    }

    /**
     * Функция, которая содержит цикл для работы бота.
     * Выход из цикла осуществляется командой.
     */
    public void startBot()
    {
        println(sayInfo());
        Scanner sc = new Scanner(System.in);
        String strCheck;
        String answer;
        while (status)
        {
            strCheck = sc.nextLine();
            answer = handleMessage(strCheck);
            println(answer);
        }
    }

    /**
     * Функция-конструктор класса ConsoleBot.
     * @param status boolean значение. Если true, то запускает бота, если false, то нет.
     */
    public ConsoleBot(boolean status)
    {
        this.status = status;
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
