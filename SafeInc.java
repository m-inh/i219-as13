public class SafeInc extends Thread {
    public void run() {
        (new GCounter()).inc();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new SafeInc();
        Thread t2 = new SafeInc();
        t1.start();
        Thread.sleep(1000);
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count: " + GCounter.get());
        assert GCounter.get() == 2;
    }
}