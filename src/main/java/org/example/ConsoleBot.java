package org.example;
public class ConsoleBot implements BotInterface  {
    @Override
    public String write(String instr){
        if (instr.equals("/help")){
       return guide();
    } else if (instr.equals("/stop")){
        return "Что ж! Приятно было пообщаться!";
    } else {
        return instr;
    }
}
@Override
    public String  sayInfo(){
        return "Привет! Меня зовут Бот-Фёдор!\n" +
                "Я ещё мало что умею делать, но со временем стану более функциональным.\n" +
                "А пока я просто умею выводить твои сообщения на экран.\n" +
                "Чтобы начать пользоваться мною, начни писать мне сообщения!\n" +
                "Если у тебя возникли вопросы, напиши команду \"/help\", и я расскажу тебе, что я умею!   ";
    }
@Override
    public String guide(){
        return "В своём арсенале я имею следующие функции:\n" +
                "\"/stop\" - если вы хотите завершить работу с ботом\n" +
                "\"/help\" - если вы хотите узнать, на что я споособен";
    }
}