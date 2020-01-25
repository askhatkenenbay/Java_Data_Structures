package Tree;

public class BTNode<E>{
    private E element;
    private BTNode<E> parent;
    private BTNode<E> left;
    private BTNode<E> right;
    public BTNode(E element, BTNode<E> parent, BTNode<E> left, BTNode<E> right){
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    public E getElement(){
        return element;
    }
    public BTNode<E> getParent(){
        return parent;
    }
    public BTNode<E> getLeft(){
        return left;
    }
    public BTNode<E> getRight(){
        return right;
    }
    public void setElement( E element){
        this.element = element;
    }
    public void setParent( BTNode<E> parent){
        this.parent = parent;
    }
    public void setLeft( BTNode<E> left ){
        this.left = left;
    }
    public void setRight( BTNode<E> right ){
        this.right = right;
    }
}