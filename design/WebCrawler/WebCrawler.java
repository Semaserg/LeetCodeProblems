package LeetCode.design.WebCrawler;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class WebCrawler {
    private FileUpdater updater = new FileUpdater();
    private static final int MAX_RETRIES = 5;

    public void run() {
        String path = "C:\\GitHub\\LeetCode\\src\\LeetCode\\design\\WebCrawler\\resources.txt";
        List<String> urls = parseFile(path);

        int retries = 1;
        ConcurrentMap<String, ParseResult> urlsToRetry = bulkExec(urls);
        try {
            while (!urlsToRetry.isEmpty() && retries < MAX_RETRIES) {
                System.out.println("RETRY #: " + retries);
                TimeUnit.SECONDS.sleep(1);
                List<String> nextUrlPortion = new ArrayList<>(urlsToRetry.keySet());
                urlsToRetry = bulkExec(nextUrlPortion);
                retries++;
            }
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException. " + ex.getMessage());
        }
    }

    private ConcurrentMap<String, ParseResult> bulkExec(List<String> urls) {
        List<Callable<ParseResult>> jobs = new ArrayList<>();
        ConcurrentMap<String, ParseResult> urlsToRetry = new ConcurrentHashMap<>();
        ExecutorService execService = Executors.newWorkStealingPool();

        urls.stream().forEach((url) -> {
            jobs.add(() -> {
                ParseResult res = new HttpParser().parse(url);
                if (!res.success && !urlsToRetry.containsKey(url)) {
                    urlsToRetry.put(url, res);
                }
                System.out.println(res);
                updater.writeUpdateToFile(res);
                return res;
            });
        });

        try {
            List<Future<ParseResult>> futures = execService.invokeAll(jobs);
            for (Future<ParseResult> future : futures) {
                ParseResult r = future.get();
            }
            execService.shutdown();
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException. " + ex.getMessage());
        } catch (ExecutionException ex) {
            System.out.println("ExecutionException. " + ex.getMessage());
        }
        return urlsToRetry;
    }

    private List<String> parseFile(String path) {
        List<String> res = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                res.add(line.trim());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found. " + ex.getMessage());
        }
        return res;
    }

}

class ParseResult {
    public final String url;
    public final int time;
    public final String title;
    public final boolean success;
    ParseResult(String url, int time, String title, boolean success) {
        this.url = url;
        this.time = time;
        this.title = title;
        this.success = success;
    }

    @Override
    public String toString() {
        return String.format("URL: %s;\nTIME: %s;\nTITLE: %s;\nSUCCESS: %s;\n\n", url, time, title, success);
    }
}
class HttpParser {
    ParseResult parse(String link) {
        long start = System.currentTimeMillis();
        String title = "EMPTY";
        boolean success = false;
        try {
            URL url = new URL(link);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.indexOf("<title>") >= 0 && line.indexOf("</title>") >= 0 ) {
                    title = line.substring(line.indexOf("<title>")+7, line.lastIndexOf("</title>"));
                    break;
                }
            }
            reader.close();
            success = true;
        } catch (MalformedURLException ex){
            System.out.println("MalformedURLException. " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException. " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception. " + ex.getMessage());
        }
        int timeInMillis = (int)((System.currentTimeMillis() - start));
        return new ParseResult(link, timeInMillis, title, success);
    }
}

class FileUpdater {
    public synchronized void  writeUpdateToFile(ParseResult parseResult) {
        String path = "C:\\GitHub\\LeetCode\\src\\LeetCode\\design\\WebCrawler\\results.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.append(parseResult.toString());
            writer.close();
        } catch (IOException ex) {
            System.out.println("IOException. " + ex.getMessage());
        }
    }
}