/**
 * Запуск потоков по порядку
 */
public class SeriesRunExample extends Thread {
    private static volatile int currentMax = 1; // Добавлено volatile
    private int mainId;
    private final Object waitObject;

    private SeriesRunExample(int mainId, Object waitObject) {
        this.mainId = mainId;
        this.waitObject = waitObject;
    }

    public static void example() {
        Object waitObject = new Object();
        for (int i = currentMax; i <= 10; ++i) { // Исправлено условие цикла
            Thread thread = new SeriesRunExample(i, waitObject);
            thread.start();
        }
    }

    public void run() {
        System.out.println("Стартовал поток " + mainId);
        synchronized (waitObject) {
            while (mainId > currentMax) {
                try {
                    waitObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            currentMax++;
            System.out.println("Отработал поток " + mainId);
            waitObject.notifyAll();
        }
    }
}