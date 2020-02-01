/*
Name: NGUYEN, Minh Tien
ID  : 1810445
Time: 2020/02/01
*/

public class NeQueue<E> implements Queue<E> {
    private E head;
    private Queue<E> tail;

    public NeQueue(E e, Queue<E> q) {
        this.head = e;
        this.tail = q;
    }

    public NeQueue<E> enq(E e) {
        return new NeQueue<E>(head, tail.enq(e));
    }

    public Queue<E> deq() {
        return tail;
    }

    public E top() {
        return head;
    }
}