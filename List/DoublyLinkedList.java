package List;

import java.util.Iterator;

import Node.DNode;

public class DoublyLinkedList<E> implements Iterable<E> {
    private DNode<E> head;
    private DNode<E> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void addFirst(E str) {
        DNode<E> temp = new DNode<>(str);
        if (size == 0) {
            head = temp;
            tail = temp;
            size++;
            return;
        }
        temp.setNext(head);
        head.setPrev(temp);
        head = temp;
        size++;
    }

    public void addLast(E str) {
        DNode<E> temp = new DNode<E>(str);
        if (size == 0) {
            head = temp;
            tail = temp;
            size++;
            return;
        }
        tail.setNext(temp);
        temp.setPrev(tail);
        tail = temp;
        size++;
    }

    /*
     * DoublyLinkedList starts from 0 index; Adds new node after node with given
     * index
     */
    public void addAfter(int index, E str) {
        if (index > size - 1 || index < 0) {
            return;
        }
        DNode<E> temp = new DNode<E>(str);
        if(index == size -1){
            temp.setPrev(tail);
            tail.setNext(temp);
            tail = temp;
            size++;
            return;
        }
        DNode<E> before;
        DNode<E> after;
        if (index < size / 2) {
            before = head;
            after = head;
            for (int i = 0; i < index; i++) {
                before = before.getNext();
            }
            after = before.getNext();
        } else {
            before = tail;
            after = tail;
            for (int i = size - index - 2; i > 0; i--) {
                after = after.getPrev();
            }
            before = after.getPrev();
        }
        before.setNext(temp);
        temp.setPrev(before);
        after.setPrev(temp);
        temp.setNext(after);
        size++;
    }
    public void addBefore(int index, E str){
        if (index > size - 1 || index < 0) {
            return;
        }
        DNode<E> temp = new DNode<E>(str);
        if(index == 0){
            temp.setNext(head);
            head.setPrev(temp);
            head = temp;
            size++;
            return;
        }
        DNode<E> before;
        DNode<E> after;
        if (index < size / 2) {
            before = head;
            after = head;
            for (int i = 0; i < index; i++) {
                after = after.getNext();
            }
            before = after.getPrev();
        } else {
            before = tail;
            after = tail;
            for (int i = size - index - 1; i > 0; i--) {
                after = after.getPrev();
            }
            before = after.getPrev();
        }
        before.setNext(temp);
        temp.setPrev(before);
        after.setPrev(temp);
        temp.setNext(after);
        size++;
    }
    public E get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        DNode<E> res;
        if (index < size / 2) {
            res = head;
            for (int i = 0; i < index; i++) {
                res = res.getNext();
            }
        } else {
            res = tail;
            for (int i = size - index - 1; i > 0; i--) {
                res = res.getPrev();
            }
        }
        return res.getElement();
    }

    public E remove(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        if (index == size - 1) {
            return removeLast();
        } else if (index == 0) {
            return removeFirst();
        }
        DNode<E> before;
        DNode<E> after;
        DNode<E> temp;
        if (index < size / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        } else {
            temp = tail;
            for (int i = size - index - 1; i > 0; i--) {
                temp = temp.getPrev();
            }
        }
        after = temp.getNext();
        before = temp.getPrev();
        before.setNext(after);
        after.setPrev(before);
        E res = temp.getElement();
        temp = null;
        size--;
        return res;
    }

    public E removeFirst() {
        DNode<E> temp = head;
        if(size == 1){
            E res = temp.getElement();
            head = null;
            tail = null;
            size--;
            return res;
        }
        head = head.getNext();
        head.setPrev(null);
        temp.setNext(null);
        size--;
        return temp.getElement();
    }

    public E removeLast() {
        DNode<E> temp = tail;
        tail = tail.getPrev();
        tail.setNext(null);
        temp.setPrev(null);
        size--;
        return temp.getElement();
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        DNode<E> temp = head;
        while (temp != null) {
            str.append(temp.getElement());
            str.append("-->");
            temp = temp.getNext();
        }
        str.append("]");
        return str.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator<>(this);
    }
}