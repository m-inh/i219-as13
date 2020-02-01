/*
Name: NGUYEN, Minh Tien
ID  : 1810445
Time: 2020/02/01
*/

public class EmpQueue<E> implements Queue<E> {
    public Queue<E> enq(E e) {
        return new NeQueue<E>(e, this);
    }

    public Queue<E> deq() {
        return this;
    }

    public E top() {
        return null;
    }
}
