package Deque;
import Node.DNode;
public class NodeDeque<E> implements Deque<E>{
    private DNode<E> head;
    private DNode<E> tail;
    private int size;
    public NodeDeque(){
        tail = null;
        head = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public E getFirst() throws EmptyDequeException {
        if(isEmpty()){
            throw new EmptyDequeException();
        }
        return head.getElement();
    }

    @Override
    public E getLast() throws EmptyDequeException {
        if(isEmpty()){
            throw new EmptyDequeException();
        }
        return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        DNode<E> temp = new DNode<>(e);
        if(isEmpty()){
           tail = temp;
        }else{
            temp.setNext(head);
            head.setPrev(temp);
        }
        head = temp;
        size++;
    }

    @Override
    public void addLast(E e) {
        DNode<E> temp = new DNode<>(e);
        if(isEmpty()){
           head = temp;
        }else{
            tail.setNext(temp);
            temp.setPrev(tail);
        }
        tail = temp;
        size++;
    }

    @Override
    public E removeFirst() throws EmptyDequeException {
        E res = getFirst();
        DNode<E> temp = head.getNext();
        head.setNext(null);
        temp.setPrev(null);
        head = temp;
        size--;
        return res;
    }

    @Override
    public E removeLast() throws EmptyDequeException {
        E res = getLast();
        DNode<E> temp = tail.getPrev();
        tail.setPrev(null);
        temp.setNext(null);
        tail = temp;
        size--;
        return res;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        DNode<E> temp = head;
        while(temp != null){
            str.append(temp.getElement());
            if(temp.getNext() != null){
                str.append("-");
            }
            temp = temp.getNext();
        }
        str.append("]");
        return str.toString();
    }
    
}