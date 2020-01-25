package List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedListIterator<E> implements Iterator<E> {
    private DoublyLinkedList<E> list;
    private int cursor;
    public DoublyLinkedListIterator(DoublyLinkedList<E> list){
        this.list = list;
        cursor = -1;
    }
    @Override
    public boolean hasNext() {
        return list.get(cursor+1) != null;
    }

    @Override
    public E next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        E res = list.get(cursor+1);
        cursor++;
        return res;
    }
    
}