package LeetCode.design.ImplementRedBlackTree;


public class Main {
    public static void main(String[] args) {
        LeanLeftRedBlackTree<Integer, String> table = new LeanLeftRedBlackTree<>();
        table.put(6, "A");
        table.put(3, "B");
        table.put(5, "C");
        table.put(8, "D");
        table.put(2, "E");
        table.put(4, "F");
        table.put(9, "G");
        table.put(1, "X");
        System.out.println(table.get(8));
        System.out.println(table.get(4));
        System.out.println(table.max());
        System.out.println(table.min());
        System.out.println(table.isEmpty());
        System.out.println(table.size());

        for(Integer k : table.keys()) {
            System.out.println(k + "->" + table.get(k));
        }
        System.out.println(table.contains(9));
        System.out.println(table.contains(10));
    }
}


