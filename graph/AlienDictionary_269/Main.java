package LeetCode.graph.AlienDictionary_269;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"}; // "wertf"
        //String[] words = new String[]{"wrtkj","wrt"};
        String result = s.alienOrder(words);
        System.out.print(result);
    }
}


