package Tree;


public interface BinaryTree<E> extends Tree<E> {

    BTNode<E> left( BTNode<E> v ) throws Exception;

    BTNode<E> right( BTNode<E> v ) throws Exception;

    boolean hasLeft( BTNode<E> v ) throws Exception;
    
    boolean hasRight( BTNode<E> v ) throws Exception;
}