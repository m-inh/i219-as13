public class FCounter {
    private static int x = 0;

    public static int get() {
        return x;
    }

    public synchronized void inc() {
        x++;
    }
}