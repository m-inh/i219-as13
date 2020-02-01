public class SimpInc extends Thread {
    private static int count = 0;
    private static int count2 = 0;

    public void run() {
        count2++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new SimpInc();
        t.start();
        count++;
        t.join();
        System.out.println("count: " + count);
        assert count == 2;
    }
}