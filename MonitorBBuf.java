/*
Name: NGUYEN, Minh Tien
ID  : 1810445
Time: 2020/02/01
*/

public class MonitorBBuf<E> {
    private Queue<E> queue;
    private int noe = 0;
    private final int capacity;

    public MonitorBBuf(int cap) {
        this.queue = new EmpQueue<E>();
        this.capacity = cap;
    }

    public synchronized void put(E e) throws InterruptedException {
        while (noe >= capacity) {
            this.wait();
        }
        if (noe < capacity) {
            queue = queue.enq(e);
            noe++;
            this.notifyAll();
        }
    }

    public synchronized E get() throws InterruptedException {
        while (noe <= 0) {
            this.wait();
        }
        if (noe > 0) {
            E e = queue.top();
            queue = queue.deq();
            noe--;
            this.notifyAll();
            return e;
        }

        return null;
    }
}