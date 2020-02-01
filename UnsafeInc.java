public class UnsafeInc extends Thread {
    public void run() {
        (new FCounter()).inc();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new UnsafeInc();
        Thread t2 = new UnsafeInc();
        t1.start();
        Thread.sleep(1000);
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count: " + FCounter.get());
        assert FCounter.get() == 2;
    }
}