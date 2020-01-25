package Node;
public class SNode<E>{
    private E element;
    private SNode<E> next;
    public SNode(E k, SNode<E> n){
        element = k;
        next = n;
    }
    public SNode(E k){
        element = k;
    }
    public SNode(SNode<E> n){
        next = n;
    }
    public SNode(){

    }
    public E getElement(){
        return element;
    }
    public SNode<E> getNext(){
        return next;
    }
    public void setElement(E k){
        element = k;
    }
    public void setNext(SNode<E> n){
        next = n;
    }
}