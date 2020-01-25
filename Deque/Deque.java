package Deque;

public interface Deque<E>{
    int size();

    boolean isEmpty();

    E getFirst() throws EmptyDequeException;

    E getLast() throws EmptyDequeException;

    void addFirst(E e);

    void addLast(E e);

    E removeFirst() throws EmptyDequeException;

    E removeLast() throws EmptyDequeException;
}