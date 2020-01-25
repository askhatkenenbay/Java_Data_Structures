package Stack;
import java.util.EmptyStackException;
import Node.SNode;
/**
 * Advantages:
 *  -> memory efficient, O(N) where N is the number of elements in stack
 *  -> all methods perform in O(1)
 * Drawbacks:
 *  -> hard to access elements other than top
 */
public class NodeStack<E> implements Stack<E> {
    private SNode<E> top;
    private int size;
    public NodeStack() {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public E peek() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.getElement();
    }

    @Override
    public void push(E element) {
        SNode<E> temp = new SNode<>(element, top);
        top = temp;
        size++;
    }

    @Override
    public E pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E temp = top.getElement();
        top = top.getNext();
        size--;
        return temp;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        SNode<E> temp = top;
        while(temp != null ){
            str.append(temp.getElement());
            if(temp.getNext() != null){
                str.append("<--");
            }
            temp = temp.getNext();
        }
        str.append("]");
        return str.toString();
    }
}