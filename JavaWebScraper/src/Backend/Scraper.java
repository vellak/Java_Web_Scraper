package Backend;

import Backend.WebsiteDetails;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Scraper {


    private static String tag = "<a href=";
    public List<WebsiteDetails> listOfWebsites;
    public String websitesVisited;
    public  Scanner scanner;



    public void Scrape(String text, int depthOfSearchText) throws MalformedURLException {
        URL pageLocation = new URL(text);

        try {
            scanner = new Scanner(pageLocation.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()){
            String line = scanner.next();
           if (line.contains(tag))
            {
                int from = line.indexOf("\"");
                int to = line.lastIndexOf("\"");

                System.out.println(line.substring(from+1, to));
            }
        }
    }
}


