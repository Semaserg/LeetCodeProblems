package LeetCode.design.RemoveItemFromMapWhileIterating;

import LeetCode.design.QuickSort.QuickSort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        removeFromMap();
        removeFromSet();
    }

    private static void removeFromMap() {
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cucumber");

        // https://stackoverflow.com/questions/6092642/how-to-remove-a-key-from-hashmap-while-iterating-over-it
        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Integer,String> e = iterator.next();
            if (e.getValue().equals("Cucumber")) {
                iterator.remove();
            }
        }

        for (int k: map.keySet()) {
            System.out.println(map.get(k));
        }
        System.out.println("-------------");

        map.entrySet().removeIf( x -> x.getValue().equals("Banana"));
        for (int k: map.keySet()) {
            System.out.println(map.get(k));
        }
        System.out.println("-------------");
    }

    private static void removeFromSet() {
        // https://stackoverflow.com/questions/1110404/remove-elements-from-a-hashset-while-iterating
        Set<String> set = new HashSet<>(Arrays.asList("NY", "SF", "LA", "SJ"));
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()) {
            String curr = iterator.next();
            if (curr.equals("LA")) iterator.remove();
        }

        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("-------------");

        set.removeIf(x -> x.equals("NY"));
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("-------------");

        set.removeAll(Arrays.asList("DC", "MC", "WDC", "SJ"));
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("-------------");
    }
}


