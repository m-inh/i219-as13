/*
Name: NGUYEN, Minh Tien
ID  : 1810445
Time: 2020/02/01
*/

import java.util.List;

public class FMonitorBBuf1<E> {
    private List<E> log;
    private Queue<E> queue;
    private int noe = 0;
    private final int capacity;

    public FMonitorBBuf1(int cap, List<E> log) {
        this.queue = new EmpQueue<E>();
        this.capacity = cap;
        this.log = log;
    }

    public synchronized void put(E e) throws InterruptedException {
        while (noe >= capacity) {
            this.wait();
        }
        if (noe < capacity) {
            queue = queue.enq(e);
            log.add(e);
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