/**
 * Счетчик
 */
public class StateObject {
    private volatile int i; // Добавлено volatile для гарантии видимости изменений между потоками

    synchronized void increment() {
        i++;
        //DebugLogger.log("increment -> %d", i);
    }

    public int getI() {
        return i;
    }
}