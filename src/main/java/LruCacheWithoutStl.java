import java.util.*;

public class LruCacheWithoutStl {
    private Deque<Integer> list = new LinkedList<Integer>();
    private Map<Integer, Iterator<Integer>> map = new HashMap<Integer, Iterator<Integer>>();

    private final int MAX_SIZE;

    public LruCacheWithoutStl(int SIZE){
        this.MAX_SIZE = SIZE;
    }

    private void refer(int key){
        if (map.containsKey(key)){
            // present already in list
            // move to front
            // first remove from list
            Iterator<Integer> itr = map.get(key);
            itr.remove();

            list.addFirst(key);
            map.put(key, list.iterator());
        } else {
            if (list.size()>MAX_SIZE){
                list.pollLast();
            }
            list.addFirst(key);
            map.put(key, list.iterator());
        }
    }

    private void display(){
        System.out.println(list);
    }

    public static void main(String[] args) {
        LruCacheWithoutStl lruCache = new LruCacheWithoutStl(4);
        int [] arr = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        for (int element : arr){
            lruCache.refer(element);
            lruCache.display();
        }
    }



}