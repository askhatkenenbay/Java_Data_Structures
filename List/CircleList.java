package List;
import Node.SNode;
public class CircleList<E>{
    private SNode<E> cursor;
    private int size;
    public CircleList(){
        cursor = null;
        size = 0;
    }
    public int getSize(){
        return size;
    }
    public SNode<E> getCursor(){
        return cursor;
    }
    public void advance(){
        if(size==0){
            return;
        }
        cursor = cursor.getNext();
    }
    public void add(SNode<E> node){
        if(cursor == null){
            node.setNext(node);
            cursor = node;
        }else{
            node.setNext(cursor.getNext());
            cursor.setNext(node);
        }
        size++;
    }
    public void add(E str){
        add(new SNode<E>(str));
    }
    public SNode<E> remove(){
        if(size==0){
            return null;
        }
        SNode<E> oldNode = cursor.getNext();
        if(oldNode==cursor){
            cursor=null;
        }else{
            cursor.setNext(oldNode.getNext());
            oldNode.setNext(null);
        }
        size--;
        return oldNode;
    }
    public String toString(){
        if(cursor == null){
            return "[]";
        }
        StringBuilder str = new StringBuilder();
        str.append("[...");
        str.append(cursor.getElement());
        SNode<E> oldCursor = cursor;
        for(advance();oldCursor!=cursor;advance()){
            str.append(", ");
            str.append(cursor.getElement());
        }
        str.append("...]");
        return str.toString();
    }
}