package Queue;
import Node.SNode;
public class NodeQueue<E> implements Queue<E>{
    private int size;
    private SNode<E> head;
    private SNode<E> tail;
    public NodeQueue(){
        size = 0;
        head = null;
        tail = null;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E peek() throws EmptyQueueException {
        if( size == 0 ){
            throw new EmptyQueueException();
        }
        return head.getElement();
    }

    @Override
    public void enqueue(E element) {
        SNode<E> temp = new SNode<>(element);
        if( size == 0 ){
            head = temp;
        }else{
            tail.setNext(temp);
        }
        tail = temp;
        size++;
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if( size == 0 ){
            throw new EmptyQueueException();
        }
        E temp = head.getElement();
        head = head.getNext();
        size--;
        if( size == 0 ){
            tail = null;
        }
        return temp;
    }

}