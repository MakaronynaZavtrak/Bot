package org.example;

/**
 * Интерфейс для бота
 */
public interface BotInterface
{
    /**
     * Функция для ответа на введенную пользователем строку.
     *
     * @param message строка, введеная пользователем.
     */
    String handleMessage(String message);

    /**
     * Фунция, хранящяя приветствие.
     *
     * @return строка-приветствие.
     */
    String sayInfo();

    /**
     * Фунция, хранящяя help-сообщение.
     *
     * @return help-строка со всеми функциями бота.
     */
    String guide();

    /**
     * Фунция, хранящяя сообщение-прощание.
     *
     * @return строка-прощание.
     */
    String farewell();
}
