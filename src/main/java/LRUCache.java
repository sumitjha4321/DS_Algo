import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by sumit.jha on 14/06/18.
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int size;

    public LRUCache(int size) {
        super(size, 0.75f, true);
        this.size = size;
    }

    public int getKey(int key) {
        return super.get(key) == null ? -1 : key;
    }

    public void put(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > this.size; // size of map is greater than size of LRU cache
    }

    public void printCache(){
        System.out.println(this);
    }


    public static void main(String[] args) {


        LRUCache lruCache = new LRUCache(4);
        int [] arr = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        for (int element : arr){
            lruCache.put(element, element);
            lruCache.printCache();
        }
    }
}
