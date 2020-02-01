public class Counter {
    private int x = 0;

    public synchronized int get() {
        return x;
    }

    public synchronized void inc() {
        x++;
    }
}