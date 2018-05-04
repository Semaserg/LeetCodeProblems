package LeetCode.appTemplates.ConsoleApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("What is your name?");
            String line = reader.readLine();
            System.out.println(String.format("Hello %s", line));
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }
}


