/**
 * Класс для инкрементирования переменной
 */
public class InterferenceThread extends Thread {
    private final InterferenceExample checker;
    private final StateObject stateObject;

    InterferenceThread(InterferenceExample checker, StateObject stateObject) {
        this.checker = checker;
        this.stateObject = stateObject;
    }

    public void run() {
        while (!checker.stop()) {
            stateObject.increment();
        }
    }
}
