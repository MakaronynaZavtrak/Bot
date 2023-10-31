package org.example;

/**
 * Интерфейс для бота
 */
public interface BotInterface
{
    /**
     * Функция для ответа на введенную пользователем строку.
     * @param inStr строка, введеная пользователем.
     */
    public void answer(String inStr);

    /**
     * Фунция, хранящяя приветствие.
     * @return строка-приветствие.
     */
    public String sayInfo();
    /**
     * Фунция, хранящяя help-сообщение.
     * @return help-строка со всеми функциями бота.
     */
    public String guide();

    /**
     * Фунция, хранящяя сообщение-прощание.
     * @return строка-прощание.
     */
    public String farewell();
}
