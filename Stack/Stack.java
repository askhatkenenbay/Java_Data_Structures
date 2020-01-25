package Stack;

import java.util.EmptyStackException;

public interface Stack<E>{
    int size();
    boolean isEmpty();
    E peek() throws EmptyStackException;
    void push(E element);
    E pop() throws EmptyStackException;
}