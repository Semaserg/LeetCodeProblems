package LeetCode.design.LRUCache_146;

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.put(2,10);
        cache.remove(3);

        System.out.println(cache.toString());
    }
}


