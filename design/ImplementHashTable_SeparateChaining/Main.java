package LeetCode.design.ImplementHashTable_SeparateChaining;

public class Main {
    public static void main(String[] args) {
        SeparateChainingHashTable<Integer, String> map = new SeparateChainingHashTable<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));

        map.remove(3);
        System.out.println(map.get(3));
    }
}


