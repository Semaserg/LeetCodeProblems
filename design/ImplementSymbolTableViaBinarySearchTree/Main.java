package LeetCode.design.ImplementSymbolTableViaBinarySearchTree;

public class Main {
    public static void main(String[] args) {
        SymbolTable<Integer, String> table = new SymbolTable<>();
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
        System.out.println(table.rank(5));

        table.deleteMin();
        table.deleteMax();
        for(Integer k : table.keys()) {
            System.out.println(k + "->" + table.get(k));
        }

        System.out.println("");
        table.delete(8);
        for(Integer k : table.keys()) {
            System.out.println(k + "->" + table.get(k));
        }

        System.out.println("");
        table.delete(5);
        for(Integer k : table.keys()) {
            System.out.println(k + "->" + table.get(k));
        }

        System.out.println("");
        table.delete(4);
        for(Integer k : table.keys()) {
            System.out.println(k + "->" + table.get(k));
        }

        System.out.println("");
        table.delete(6);
        for(Integer k : table.keys()) {
            System.out.println(k + "->" + table.get(k));
        }
    }
}


