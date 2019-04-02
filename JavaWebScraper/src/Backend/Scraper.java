package Backend;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Scraper {


    public List<String> listOfWebsitesVisited = new ArrayList<>();
    BufferedReader Br;

    String tag = "href=\"";
    String tag2 = "href=\"";


    public void Scrape(String text, int depthOfSearchText, int currentDepth) {

        try {
            Document doc = Jsoup.parse(new URL(text),4000);
            Elements resultLinks  = doc.select("a[href]");
            for (Element link : resultLinks){

                String href = link.attr("href");
                if (href.contains("https://") && currentDepth < depthOfSearchText && !listOfWebsitesVisited.contains(href)){
                    System.out.println("Title: " + link.text() + "Depth Search = " + currentDepth);
                    System.out.println("Url: " + href);
                    listOfWebsitesVisited.add(href);
                    Scrape(href, depthOfSearchText, currentDepth +1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }









        /*
        OLD CODE


         */



       /* System.out.println("In the scraper method");

        // goes through the list of websites,
        try {
            URLConnection connection = new URL(text).openConnection();
            connection.addRequestProperty("User-Agent", "Mozilla/5.0");
            Br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            System.out.println("Connected and set up the Buffered Reader");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = null;

        do {
            try {
                line = Br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }


            //System.out.println("new line: " + i);

            if (line != null)
                if (line.contains(tag) || line.contains(tag2)) {




                   int from = line.indexOf("\"");
                   int to = line.lastIndexOf("\"");
                    String website = line.substring(from+1, to);
                    //checker for previous links
                    if (!listOfWebsitesVisited.contains(website)) {
                        System.out.println("Found Website");
                        System.out.println(website);

                        // since the code is only accessed when a new link is accessed, add the current link to the accessed websites list
                        listOfWebsitesVisited.add(website);


                        // adjusting URL
                        String paramValue = "param\\with\\backslash";
                        String URLStr = null;
                        try {
                            URLStr = website + "?param=" + URLEncoder.encode(paramValue, "UTF-8");

                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        Scrape(URLStr, depthOfSearchText, currentDepth + 1);
                    }
                }
        } while (line != null);
    */
    }
}



