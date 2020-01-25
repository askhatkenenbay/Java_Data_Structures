package Queue;

public class ArrayQueue<E> implements Queue<E>{
    private int size;
    private int head;
    private int tail;
    private E[] array;
    private static final int CAPACITY = 1000;
    private int capacity;
    public ArrayQueue(){
        capacity = CAPACITY;
        size = 0;
        head = 0;
        tail = -1;
        array = (E[]) new Object[capacity];
    }
    public ArrayQueue(int capacity){
        this.capacity = capacity;
        size = 0;
        head = 0;
        tail = -1;
        array = (E[]) new Object[capacity];
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
    public E peek() throws EmptyQueueException {
        if( size == 0 ){
            throw new EmptyQueueException();
        }
        return array[head];
    }

    private void increaseCapacity(){
        capacity*=2;
        E[] newArray = (E[]) new Object[capacity];
        int i = 0;
        while(head != tail){
            newArray[i] = array[head];
            head = (head+1)%array.length;
            i++;
        }
        newArray[i] = array[head];
        array = newArray;
        head = 0;
        tail = i;
    }

    @Override
    public void enqueue(E element) throws Exception{
        if(size == capacity){
            increaseCapacity();
        }
        array[ (tail+1) % capacity] = element;
        tail = (tail+1) % capacity;
        size++;
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if( size == 0 ){
            throw new EmptyQueueException();
        }
        E temp = array[head];
        array[head] = null;
        head = (head+1)%capacity;
        size--;
        if( size == 0 ){
            head = 0;
            tail = -1;
        }
        return temp;
    }

    public String toString(){
        if(size()==0){
            return "[]";
        }
        StringBuilder str = new StringBuilder();
        str.append("[");
        int tempHead = head;
        System.out.println("head: "+ head);
        System.out.println("tail: " + tail);
        System.out.println("array Size: "+array.length);
        System.out.println("size: " + size());
        while(tempHead != tail){
            str.append(array[tempHead]);
            str.append("<--");
            tempHead = (tempHead+1)%capacity;
        }
        str.append(array[tempHead]);
        str.append("]");
        return str.toString();
    }
}