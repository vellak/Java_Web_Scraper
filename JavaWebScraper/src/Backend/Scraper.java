package Backend;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Scraper {


    private List<String> listOfWebsitesVisited = new ArrayList<>();
    public List<SearchStringDetails> searchStringList = new ArrayList<>();


    private BufferedReader Br;

    private String tag = "href=\"";
    private String tag2 = "href=\"";


    public void Scrape(String text, int depthOfSearchText,String searchString, int currentDepth)
    {
        System.out.println("Activated the Scraper");
        try
        {
            System.out.println("inside the Try catch");
            Document doc = Jsoup.parse(new URL(text),4000);
            Elements resultLinks  = doc.select("a[href]");
            Elements resultparagraphs = doc.getElementsByTag("p");


            GetSearchString(resultparagraphs);

            getLinks(depthOfSearchText, searchString, currentDepth, resultLinks);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void getLinks(int depthOfSearchText, String searchString, int currentDepth, Elements resultLinks) {
        for (Element link : resultLinks)
        {

            String href = link.attr("href");


            if ((href.contains("https://") ||href.contains("http://"))&& currentDepth < depthOfSearchText && !listOfWebsitesVisited.contains(href))
            {


                System.out.println("Title: " + link.text() + "Depth Search = " + currentDepth);
                System.out.println("Url: " + href);
                listOfWebsitesVisited.add(href);
                // Calls search within the next depth of searches;
                Scrape(href, depthOfSearchText, searchString,currentDepth +1);
            }
        }
    }

    private void GetSearchString(Elements resultparagraphs) {
        for (Element result:resultparagraphs)
        {

            System.out.println("The paragraph found with the search string specified is: " + result.text());
        }
    }
}



