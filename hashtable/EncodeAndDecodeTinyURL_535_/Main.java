package LeetCode.hashtable.EncodeAndDecodeTinyURL_535_;

public class Main {
    public static void main(String[] args) {
        Codec s = new Codec();
        String result = s.decode(s.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.print(result);
    }
}


