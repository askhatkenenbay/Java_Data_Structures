package Stack;

import java.util.Arrays;
import java.util.EmptyStackException;
/**
 * Advantages:
 *  ->simple & efficient
 *  ->good if we know estimate number of items to be stored
 *  ->if we need direct access to other elements than top one
 * 
 * Drawbacks:
 *  ->method push can take O(N) time to copy current elements to new bigger array
 *  ->mempry waste, memory complexity is O(N) where N is the current array size, while
 * stack can have much less items in it
 * @param <E> stored type
 */
public class ArrayStack<E> implements Stack<E>{
    private static final int CAPACITY = 100;
    private int capacity;
    private E stack[];
    private int topIndex = -1;
    public ArrayStack(int capacity){
        stack = (E[]) new Object[capacity];
        this.capacity = capacity;
    }
    public ArrayStack(){
        stack  = (E[]) new Object[CAPACITY];
        this.capacity = CAPACITY;
    }
    public int size(){
        return topIndex+1;
    }
    public boolean isEmpty(){
        return topIndex<0;
    }
    public void push(E element){
        if(size() == capacity){
            capacity*=2;
            stack = Arrays.copyOf(stack, capacity);
        }
        stack[++topIndex] = element;
    }
    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack[topIndex];
    }
    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E element = stack[topIndex];
        stack[topIndex--] = null;
        return element;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        if(size()>0){
            str.append(stack[0]);
            str.append(", ");
        }
        if(size()>1){
            for(int i =1; i< size()-1;i++){
                str.append(stack[i]);
                str.append(", ");
            }
            str.append(stack[size()-1]);
        }
        str.append("]");
        return str.toString();
    }
}