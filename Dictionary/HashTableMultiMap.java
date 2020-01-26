package Dictionary;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class HashTableMultiMap<K, V> implements MultiMap<K, V> {
    Map<K,LinkedList<Map.Entry<K,V>>> map;
    int mapSize;

    public HashTableMultiMap(){
        map = new HashMap<K,LinkedList<Map.Entry<K,V>>>();
        mapSize = 0;
    }
    @Override
    public int size() {
        return mapSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Entry<K, V> put(K key, V v) throws IllegalArgumentException {
        if(key==null){
            throw new IllegalArgumentException();
        }
        LinkedList<Map.Entry<K,V>> temp =map.get(key);
        if(temp==null){
            temp = new LinkedList<Map.Entry<K,V>>();
            map.put(key, temp);
        }
        Map.Entry<K,V> entry = new AbstractMap.SimpleEntry<K,V>(key,v);
        temp.add(entry);
        mapSize++;
        return entry;
    }

    @Override
    public Entry<K, V> get(K k) throws IllegalArgumentException {
        if(k == null){
            throw new IllegalArgumentException();
        }
        LinkedList<Map.Entry<K,V>> temp = map.get(k);
        if(temp == null){
            return null;
        }
        return temp.peekFirst();
    }

    @Override
    public Iterable<Entry<K, V>> getAll(K k) throws IllegalArgumentException {
        if(k == null){
            throw new IllegalArgumentException();
        }
        LinkedList<Map.Entry<K,V>> temp = map.get(k);
        if(temp == null){
            return null;
        }
        return temp;
    }



    @Override
    public Entry<K, V> remove(Entry<K, V> e) throws IllegalArgumentException {
        if(e == null){
            throw new IllegalArgumentException();
        }
        K key = e.getKey();
        LinkedList<Map.Entry<K,V>> temp = map.get(key);
        if(temp == null){
            throw new IllegalArgumentException("no such key");
        }
        if(temp.remove(e)){
            mapSize--;
            if(isEmpty()){
                map.remove(key);
            }
            return e;
        }else{
            throw new IllegalArgumentException("input is not in map");
        }
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        LinkedList<Map.Entry<K,V>> temp = new LinkedList<>();
        for( LinkedList<Map.Entry<K,V>> sub : map.values() ){
            temp.addAll(sub);
        }
        return temp;
    }
    
}