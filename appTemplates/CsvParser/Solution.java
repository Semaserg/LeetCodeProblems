package LeetCode.appTemplates.CsvParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
    Parse csv file. Each row has int priority in the first column and the title in the second.
 */
public class Solution {
    private final String path = "C:\\GitHub\\LeetCode\\src\\LeetCode\\appTemplates\\CsvParser\\data.csv";

    public void parseData() {
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 0) continue;
                try {
                    Integer priority = Integer.valueOf(parts[0]);
                    String title = parts[1];
                    System.out.println(priority + " " + title);
                } catch (NumberFormatException ex) {
                    // skip comments
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(String.format("File is not found: %s", path));
        }
    }
}