package PriorityQueue;

import java.util.Comparator;
import java.util.Map.Entry;

import List.DoublyLinkedList;



public class SortedListPriorityQueue<K, V> implements PriorityQueue<K, V> {
    private DoublyLinkedList<Entry<K,V>> entries;
    private Comparator<K> comparator;

    public SortedListPriorityQueue(){
        entries = new DoublyLinkedList<>();
        comparator = new DefaultComparator<K>();
    }
    public SortedListPriorityQueue(Comparator<K> comparator){
        entries = new DoublyLinkedList<>();
        this.comparator = comparator;
    }
    @Override
    public int size() {
        return entries.getSize();
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public Entry<K,V> min() throws Exception {
        if(entries.isEmpty()){
            throw new Exception("empty priority queue");
        }
        return entries.get(0);
    }

    @Override
    public Entry<K,V> insert(K key, V value) throws Exception {
        if( key == null || value == null){
            throw new Exception("null input");
        }
        Entry<K,V> entry = new CustomEntry<>(key, value);
        insertEntry(entry);
        return entry;
    }
    private void insertEntry(Entry<K,V> e){
        if(entries.isEmpty()){
            entries.addFirst(e);
        }else if(comparator.compare(e.getKey(), entries.get(entries.getSize()-1).getKey()) > 0){
            entries.addLast(e);
        }else{
            int i =0;
            Entry<K,V> curr = entries.get(i);
            while(comparator.compare(e.getKey(), curr.getKey()) > 0){
                curr = entries.get(++i);
            }
            entries.addBefore(i, e);
        }
    }
    @Override
    public Entry<K,V> removeMin() throws Exception {
        if(entries.isEmpty()){
            throw new Exception("empty queue");
        }
        return entries.removeFirst();
    }

    public String toString(){
        return entries.toString();
    }
    private static class CustomEntry<K,V> implements Entry<K,V>{
        private K key;
        private V value;

        public CustomEntry(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return this.value = value;
        }
        
        public String toString(){
            return "( "+key + ", "+value+" )";
        }
    }
}