import java.util.concurrent.atomic.AtomicInteger;

/**
 * Пример совместного использования ресурсов
 */
public class InterferenceExample {
    private static final int expect = 10000;
    private AtomicInteger counter = new AtomicInteger();
    private StateObject stateObject = new StateObject();

    boolean stop() {
        return counter.incrementAndGet() > expect;
    }

    public void example() throws InterruptedException {
        CounterMonitor monitor = new CounterMonitor(stateObject, 1);
        monitor.start();

        InterferenceThread thread1 = new InterferenceThread(this, stateObject);
        InterferenceThread thread2 = new InterferenceThread(this, stateObject);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        monitor.stopMonitoring();

        System.out.println("Expected: " + expect);
        System.out.println("Result: " + stateObject.getI());
    }
}