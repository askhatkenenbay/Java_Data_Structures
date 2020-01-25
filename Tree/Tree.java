package Tree;

import java.util.Iterator;

/**
 * An interface for a tree where nodes can have an arbitrary number of children
 * @param <E> generic type
 */
public interface Tree<E> extends Iterable<E>{
    /** Returns the number of nodes in tree */
    int size();

    /** Returns whether the tree is empty */
    boolean isEmpty();

    /** Returns an iterator of the elements stored in the tree */
    Iterator<E> iterator();

    /** Returns an iterable collection of the nodes 
     * @throws Exception */
    Iterable<BTNode<E>> positions() throws Exception;

    /** Replace the element stored in the given node 
     * @throws Exception */
    E replace(BTNode<E> v, E e) throws Exception;

    /** Returns the root of the tree */
    BTNode<E> root();

    /** Returns the parent of the given node 
     * @throws Exception */
    BTNode<E> parent( BTNode<E> v) throws Exception;

    /** Returns an iterable collection of the children of a given node 
     * @throws Exception */
    Iterable<BTNode<E>> children( BTNode<E> v) throws Exception;

    /** Returns whether a given node is internal 
     * @throws Exception */
    boolean isInternal( BTNode<E> v) throws Exception;

    /** Returns whether a given node is external 
     * @throws Exception */
    boolean isExternal( BTNode<E> v) throws Exception;

    /** Returns whether a given node is the root of the tree 
     * @throws Exception */
    boolean isRoot( BTNode<E> v) throws Exception;
}