public class Pair<K, V> {
    K key;
    V value;
    public void set(K k, V v){
        key = k;
        value = v;
    }
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        str.append(key);
        str.append(":");
        str.append(value);
        str.append("]");
        return str.toString();
    }
}