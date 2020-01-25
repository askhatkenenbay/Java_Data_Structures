package PriorityQueue;

import java.util.Map.Entry;

public interface PriorityQueue<K, V> {
    int size();

    boolean isEmpty();

    Entry<K,V> min() throws Exception;
    
    Entry<K,V> insert(K key, V value) throws Exception;

    Entry<K,V> removeMin() throws Exception;
}