/**
 * Утилита для отладочного логирования.
 * Позволяет включать/отключать вывод и добавляет к сообщению
 * временную метку и имя потока.
 */
public class DebugLogger {
    private static boolean enabled = true;

    /**
     * Включить/отключить логирование.
     * @param enable true – логирование включено, false – выключено
     */
    public static void setEnabled(boolean enable) {
        enabled = enable;
    }

    /**
     * Вывести отладочное сообщение.
     * @param message текст сообщения
     */
    public static void log(String message) {
        if (enabled) {
            System.out.printf("[%tT] [%s] %s%n",
                    System.currentTimeMillis(),
                    Thread.currentThread().getName(),
                    message);
        }
    }

    /**
     * Вывести отладочное сообщение с форматированием.
     * @param format строка формата
     * @param args   аргументы форматирования
     */
    public static void log(String format, Object... args) {
        if (enabled) {
            log(String.format(format, args));
        }
    }
}