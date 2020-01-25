package Tree;

import java.util.Iterator;

import List.DoublyLinkedList;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
    private BTNode<E> root;
    private int size;

    public LinkedBinaryTree() {
        root = null;
        size = 0;
    }

    public LinkedBinaryTree(BTNode<E> root) {
        this.root = root;
        size = 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private BTNode<E> checkNode(BTNode<E> v) throws Exception {
        if (v == null || !(v instanceof BTNode)) {
            throw new Exception("The node is invalid");
        }
        return v;
    }

    @Override
    public Iterator<E> iterator() {
        try {
            Iterable<BTNode<E>> nodes = positions();
            DoublyLinkedList<E> elements = new DoublyLinkedList<>();
            for(BTNode<E> node : nodes){
                elements.addLast(node.getElement());
            }
            return elements.iterator();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<BTNode<E>> positions() throws Exception {
        DoublyLinkedList<BTNode<E>> nodes = new DoublyLinkedList<>();
        if( size != 0 ){
            preorderNodes(root(), nodes);
        }
        return nodes;
    }
    private void preorderNodes(BTNode<E> v, DoublyLinkedList<BTNode<E>> nod) throws Exception {
        nod.addLast(v);
        if(hasLeft(v)){
            preorderNodes(left(v), nod);
        }
        if(hasRight(v)){
            preorderNodes(right(v),nod);
        }
    }
    @Override
    public E replace(BTNode<E> v, E e) throws Exception {
        E temp = checkNode(v).getElement();
        v.setElement(e);
        return temp;
    }

    @Override
    public BTNode<E> root() {
        return root;
    }

    @Override
    public BTNode<E> parent(BTNode<E> v) throws Exception {
        if( checkNode(v).getParent() == null ){
            throw new Exception("No parent node");
        }
        return v.getParent();
    }

    @Override
    public Iterable<BTNode<E>> children(BTNode<E> v) throws Exception {
        DoublyLinkedList<BTNode<E>> children = new DoublyLinkedList<>();
        if(hasLeft(v)){
            children.addLast(left(v));
        }
        if(hasRight(v)){
            children.addLast(right(v));
        }
        return children;
    }

    @Override
    public boolean isInternal(BTNode<E> v) throws Exception {
        checkNode(v);
        return ( hasLeft(v) || hasRight(v) );
    }

    @Override
    public boolean isExternal(BTNode<E> v) throws Exception {
        return !isInternal(v);
    }

    @Override
    public boolean isRoot(BTNode<E> v) throws Exception {
        checkNode(v);
        return v == root;
    }

    @Override
    public BTNode<E> left(BTNode<E> v) throws Exception {
        if( checkNode(v).getLeft() == null ){
            throw new Exception("No left child");
        }
        return v.getLeft();
    }

    @Override
    public BTNode<E> right(BTNode<E> v) throws Exception {
        if( checkNode(v).getRight() == null ){
            throw new Exception("No right child");
        }
        return v.getRight();
    }

    @Override
    public boolean hasLeft(BTNode<E> v) throws Exception {
        return checkNode(v).getLeft() != null;
    }

    @Override
    public boolean hasRight(BTNode<E> v) throws Exception {
        return checkNode(v).getRight()!= null;
    }

    public BTNode<E> addRoot(E e) throws Exception {
        if(!isEmpty()){
            throw new Exception("Treealready has a root");
        }
        size = 1;
        root = new BTNode(e,null,null,null);
        return root;
    }

    public BTNode<E> insertLeft(BTNode<E> v, E e) throws Exception {
        if(hasLeft(checkNode(v))){
            throw new Exception("Node already has left child");
        }
        BTNode<E> leftChild = new BTNode(e,v,null,null);
        v.setLeft(leftChild);
        size++;
        return leftChild;
    }
    public BTNode<E> insertRight(BTNode<E> v, E e) throws Exception {
        if(hasRight(checkNode(v))){
            throw new Exception("Node already has right child");
        }
        BTNode<E> rightChild = new BTNode(e,v,null,null);
        v.setRight(rightChild);
        size++;
        return rightChild;
    }
    public E remove(BTNode<E> v) throws Exception {
        checkNode(v);
        BTNode<E> leftChild = v.getLeft();
        BTNode<E> rightChild = v.getRight();
        if(leftChild != null && rightChild != null){
            throw new Exception("cannot remove node with two children");
        }
        BTNode<E> onlyChild;
        if(leftChild != null){
            onlyChild = leftChild;
        }else if( rightChild != null){
            onlyChild = rightChild;
        }else{
            onlyChild = null;
        }
        if(v == root){
            if( onlyChild != null){
                onlyChild.setParent(null);
            }
            root = onlyChild;
        }else{
            BTNode<E> parent = v.getParent();
            if(v == parent.getLeft()){
                parent.setLeft(onlyChild);
            }else{
                parent.setRight(onlyChild);
            }
            if(onlyChild != null){
                onlyChild.setParent(parent);
            }
        }
        size--;
        return v.getElement();
    }
}