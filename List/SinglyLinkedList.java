package List;
import Node.SNode;
public class SinglyLinkedList<E>{
    private SNode<E> head;
    private SNode<E> tail;
    private int size;
    public SinglyLinkedList(){
        head=null;
        tail=null;
        size=0;
    }
    public void addFirst(E str){
        SNode<E> temp = new SNode<>(str);
        temp.setNext(head);
        head = temp;
        if(size==0){
            tail = temp;
        }
        size++;
    }
    public void addLast(E str){
        SNode<E> temp = new SNode<>(str);
        if(size == 0){
            head = temp;
            tail = temp;
            size++;
            return;
        }
        tail.setNext(temp);
        tail = temp;
        size++;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        SNode<E> temp = head;
        while(temp != null){
            str.append(temp.getElement());
            str.append("-->");
            temp = temp.getNext();
        }
        str.append("]");
        return str.toString();
    }
    public int getSize(){
        return size;
    }
    public void removeFirst(){
        if( size == 0 ){
            return;
        }
        SNode<E> temp = head;
        head = head.getNext();
        temp.setNext(null);
        size--;
    }
    public void removeLast(){
        if ( size == 0 ){
            return;
        }
        SNode<E> temp = head;
        for(int i = 0; i < size - 2 ; i++ ) {
            temp = temp.getNext();
        }
        temp.setNext(null);
        size--;
    }
}