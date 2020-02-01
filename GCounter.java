public class GCounter {
    private static int x = 0;
    private static Object lock = new Object();

    public static int get() {
        return x;
    }

    public void inc() {
        synchronized (lock) {
            x++;
        }
    }
}