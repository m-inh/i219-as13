public interface Queue<E> {
    Queue<E> enq(E e);

    Queue<E> deq();

    E top();
}