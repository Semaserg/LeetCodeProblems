package LeetCode.appTemplates.HttpReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            URL geo = new URL("http://json-schema.org/example/geo.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(geo.openStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (MalformedURLException ex) {
            System.out.println("MalformedURLException");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }
}


