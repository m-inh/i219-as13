public class SafeInc2 extends Thread {
    private static Counter counter = new Counter();

    public void run() {
        counter.inc();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new SafeInc2();
        Thread t2 = new SafeInc2();
        t1.start();
        Thread.sleep(1000);
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count: " + counter.get());
        assert counter.get() == 2;
    }
}