package LeetCode.design.DesignPhoneDirectory_379_;

public class Main {
    public static void main(String[] args) {
        PhoneDirectory s = new PhoneDirectory(3);
        int first = s.get();
        System.out.println(first);
        System.out.println(s.check(first));
        s.release(first);
        System.out.println(s.check(first));
    }
}


