package Backend;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Scraper.
 */
public class Scraper {


    private List<String> listOfWebsitesVisited = new ArrayList<>();
    /**
     * The Search string list.
     */
    List<SearchStringDetails> searchStringList = new ArrayList<>();


    /**
     * Scrape.
     *
     * @param text              the text
     * @param depthOfSearchText the depth of search text
     * @param searchString      the search string
     * @param currentDepth      the current depth
     */
    public void Scrape(String text, int depthOfSearchText,String searchString, int currentDepth)
    {
        System.out.println("Activated the Scraper");
        try
        {
            System.out.println("inside the Try catch");
            Document doc = Jsoup.parse(new URL(text),4000);
            Elements resultLinks  = doc.select("a[href]");


            GetSearchString(doc, searchString, depthOfSearchText, text);

            getLinks(depthOfSearchText, searchString, currentDepth, resultLinks);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Gets search string list.
     *
     * @return the search string list
     */
    public List<SearchStringDetails> getSearchStringList() {

        return searchStringList;
    }

    public List<String> getListOfWebsitesVisited() {
        return listOfWebsitesVisited;
    }

    private void getLinks(int depthOfSearchText, String searchString, int currentDepth, @NotNull Elements resultLinks) {
        for (Element link : resultLinks)
        {

            String href = link.attr("href");

            if ((href.contains("https://") ||href.contains("http://"))&& currentDepth < depthOfSearchText && !listOfWebsitesVisited.contains(href))
            {

                // System.out.println("Title: " + link.text() + " Depth Search = " + currentDepth);
               // System.out.println("Url: " + href);
                listOfWebsitesVisited.add(href);
                // Calls search within the next depth of searches;
                Scrape(href, depthOfSearchText, searchString,currentDepth +1);
            }
        }
    }

    private void GetSearchString(@NotNull Document doc, String searchString, int depth, String url) {
        for (Element result:doc.getElementsByTag("p"))
        {
            if (result.text().contains(searchString))
            {
                searchStringList.add(new SearchStringDetails(url,doc.title(), result.text(), depth));
                //System.out.println("New Line : " + result.text());

                //System.out.println(searchStringList.get(searchStringList.size()-1).toString());
            }
        }
    }
}
