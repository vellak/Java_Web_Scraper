package Backend;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Scraper {


    public List<WebsiteDetails> listOfWebsites;
    public String websitesVisited;
    private Scanner scanner;



    public void Scrape(String text, int depthOfSearchText) {
        String tag = "<a href=\"https://";


        System.out.println("In the scraper method");
        URL pageLocation = null;
        try {

            System.out.println("Trying to get the URL");
            pageLocation = new URL(text);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Trying to open the stream");
            assert pageLocation != null;
            scanner = new Scanner(pageLocation.openStream());
        } catch (IOException e) {
            System.out.println("Error while Opening the stream");
            e.printStackTrace();
        }


        while (scanner.hasNext()){
            System.out.println("inside the loop");
            String line = scanner.next();

            if (line.contains(tag))
            {
                int from = line.indexOf("\"");
                int to = line.lastIndexOf("\"");
                System.out.println("Website Found!");
                System.out.println(line.substring(from+1, to));
            }
        }
    }
}


