package Node;
public class DNode<E>{
    private E element;
    private DNode<E> next;
    private DNode<E> prev;
    public DNode(E e, DNode<E> n, DNode<E> p){
        element = e;
        next = n;
        prev = p;
    }
    public DNode(E e){
        element = e;
        next = null;
        prev = null;
    }
    public DNode<E> getNext(){
        return next;
    }
    public DNode<E> getPrev(){
        return prev;
    }
    public E getElement(){
        return element;
    }
    public void setElement(E str){
        element = str;
    }
    public void setNext(DNode<E> n){
        next = n;
    }
    public void setPrev(DNode<E> p){
        prev = p;
    }
    public String toString(){
        return " "+element;
    }
}