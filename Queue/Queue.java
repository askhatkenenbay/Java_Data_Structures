package Queue;

public interface Queue<E>{
    int size();

    boolean isEmpty();

    E peek() throws EmptyQueueException;

    void enqueue(E element) throws Exception;

    E dequeue() throws EmptyQueueException;
}