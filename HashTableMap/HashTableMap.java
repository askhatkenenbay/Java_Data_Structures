package HashTableMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.management.openmbean.InvalidKeyException;

//collisions solved via open addressing:linear probing
public class HashTableMap<K, V> implements Map<K, V> {
    private static class HashEntry<K,V> implements Entry<K,V>{
        private K key;
        private V value;
        public HashEntry(K key, V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
        public V setValue(V value){
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
        public boolean equals(Object o){
            HashEntry<K,V> entry;
            try{
                entry = (HashEntry<K,V>) o;
            }catch(ClassCastException e){
                return false;
            }
            return entry.getKey() == this.key && entry.getValue() == this.value;
        }
    }
    private final Entry<K,V> AVAILABLE = new HashEntry<K,V>(null,null);
    private static final int DEFAULT_PRIME = 109_345_121;
    private int size = 0;
    private int prime;
    private int capacity;
    private Entry<K,V>[] bucket;//bucket array
    private long scale;
    private long shift;
    public HashTableMap(int capacity){
        this( DEFAULT_PRIME, capacity );
    }
    public HashTableMap(int prime, int capacity){
        this.prime = prime;
        this.capacity = capacity;
        bucket = (Entry<K,V>[]) new Entry[this.capacity];
        Random random = new Random();
        this.scale = random.nextInt(prime-1)+1;
        this.shift = random.nextInt(prime);
    }
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private void checkKey(K key){
        if( key == null ){
            throw new InvalidKeyException("null key");
        }
    }

    //Hash function applying MAD method to default hash code
    // [ (a * i + b) mod p ] mod N
    public int hashValue(K key){
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    private int findEntry(K key) throws InvalidKeyException{
        checkKey(key);
        int available = -1;
        int i = hashValue(key);
        int j = i;
        do{
            Entry<K,V> entry = bucket[i];
            if( entry == null ){
                if( available < 0 ){
                    available = i;   // key is not in table
                }
                break;
            }
            if( key.equals( entry.getKey()) ){
                return i;
            }
            if( entry == AVAILABLE){
                if( available < 0 ){
                    available = i;  //remember that this slot is available
                }
            }
            i = (++i) % capacity;
        }while( i != j );
        return -(available + 1);
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for(int i =0; i<bucket.length;i++){
            if(bucket[i].getValue() == (V) value){
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) throws InvalidKeyException{
        int i = findEntry( (K) key);
        if( i < 0 ){
            return null;
        }
        return bucket[i].getValue();
    }

    @Override
    public V put(K key, V value) throws InvalidKeyException{
        int i = findEntry(key);
        if( i >= 0 ){
            return bucket[i].setValue(value);
        }
        if( size >= capacity / 2 ){
            rehash();
            i = findEntry(key);
        }
        bucket[-i-1] = new HashEntry<K,V>(key,value);
        size++;
        return null;
    }
    
    private void rehash(){
        capacity *= capacity;
        Entry<K,V>[] oldBucket = bucket;
        bucket = (Entry<K,V>[]) new Entry[capacity];
        Random random = new Random();
        scale = random.nextInt(prime-1)+1;
        shift = random.nextInt(prime);
        for(int i=0;i<oldBucket.length;i++){
            Entry<K,V> entry = oldBucket[i];
            if(entry != null && entry != AVAILABLE){
                int j = -1 - findEntry(entry.getKey());
                bucket[j] = entry;
            }
        }
    }

    @Override
    public V remove(Object key) throws InvalidKeyException{
        int i = findEntry( (K) key);
        if( i < 0 ){
            return null;    //nothing to remove
        }
        V temp = bucket[i].getValue();
        bucket[i] = AVAILABLE;
        size--;
        return temp;
    }

    @Override
    public void clear() {
        bucket = (Entry<K,V>[]) new Entry[capacity];
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> res = new HashSet<>();
        for( int i = 0; i < capacity; i++ ){
            if(bucket[i] != null && bucket[i] != AVAILABLE){
                res.add(bucket[i].getKey());
            }
        }
        return res;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> res = new HashSet<>();
        for(int i=0;i<bucket.length;i++){
            res.add(bucket[i]);
        }
        return res;
    }
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        
    }

}