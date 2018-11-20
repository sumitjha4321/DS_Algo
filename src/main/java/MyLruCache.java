import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by sumit.jha on 14/06/18.
 */

interface Cache<K, V> {
    V get (K key);
    void put(K key, V value);
}

/*
class Node <K, V>{
     K key;
     V value;
    public Node (K key, V value){
        this.key = key;
        this.value = value;
    }
}
*/

class Node <T> {
    T value;
}
public class MyLruCache<K, V> implements Cache <K, V> {

    private final int SIZE;

    public MyLruCache(int SIZE){
        this.SIZE = SIZE;
    }


    public V get(K key) {
        return null;
    }

    public void put(K key, V value) {

    }
}
