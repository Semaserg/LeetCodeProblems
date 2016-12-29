package LeetCode.design.UniqueWordAbbreviation_288;

public class Main {
    public static void main(String[] args) {
         ValidWordAbbr vwa = new ValidWordAbbr(new String[] {"deer", "door", "cake", "card" });
         System.out.println(vwa.isUnique("dppr"));
        System.out.println(vwa.isUnique("anotherWord"));
    }
}


