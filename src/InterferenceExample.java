import java.util.concurrent.atomic.AtomicInteger;

/**
 * Пример совместного использования ресурсов
 */
public class InterferenceExample {
    private static final int HUNDRED_MILLION = 100000000;
    private AtomicInteger counter = new AtomicInteger();
    private StateObject stateObject = new StateObject();

    boolean stop() {
        return counter.incrementAndGet() > HUNDRED_MILLION;
    }

    public void example() throws InterruptedException {
        InterferenceThread thread1 = new InterferenceThread(this, stateObject);
        InterferenceThread thread2 = new InterferenceThread(this, stateObject);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join(); // Добавлено ожидание завершения второго потока
        System.out.println("Expected: " + HUNDRED_MILLION);
        System.out.println("Result: " + stateObject.getI());
    }
}