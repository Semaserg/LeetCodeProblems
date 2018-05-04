package LeetCode.appTemplates.FileIO;

import java.io.*;
import java.util.Scanner;

public class Main {
    private final static String path = "C:\\GitHub\\LeetCode\\src\\LeetCode\\appTemplates\\FileIO\\temp.txt";

    public static void main(String[] args) {
        read();
        write();
        read();
    }

    private static void read() {
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(String.format("Line is: %s", line));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        }
    }

    private static void readEx() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(String.format("Line is: %s", line));
        }
    }

    private static void write() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.append(" appended data");
            writer.close();
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }

    private static void writeEx() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
        writer.append(" appended data");
        writer.close();
    }
}


