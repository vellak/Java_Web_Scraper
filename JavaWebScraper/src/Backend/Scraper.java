package Backend;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Scraper.
 */
public class Scraper
{


    private List<String> listOfWebsitesVisited = new ArrayList<>();
    /**
     * The Search string list.
     */
    List<SearchStringDetails> searchStringList = new ArrayList<>();


    /**
     * Scrape.
     *
     * @param URL               the URL
     * @param depthOfSearchText the depth of search URL
     * @param searchString      the search string
     * @param currentDepth      the current depth
     */
    public void Scrape(String URL, int depthOfSearchText, String searchString, int currentDepth)
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(URL).openStream()));

            String line;
            while ((line = br.readLine()) != null)
            {
                GetSearchString(line, searchString, depthOfSearchText, URL);
                getLinks(line,depthOfSearchText, searchString, currentDepth);
            }

            br.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Gets search string list.
     *
     * @return the search string list
     */
    public List<SearchStringDetails> getSearchStringList()
    {

        return searchStringList;
    }

    public List<String> getListOfWebsitesVisited()
    {
        return listOfWebsitesVisited;
    }

    private void getLinks(String line, int depthOfSearchText, String searchString, int currentDepth)
    {
        String href = HTMLParser.ParseHtmlLink(line);
        System.out.println(href);
        listOfWebsitesVisited.add(href);
        // Calls search within the next depth of searches;
        if (currentDepth < depthOfSearchText)
        {
            Scrape(href, depthOfSearchText, searchString, currentDepth + 1);
        }
    }

    private void GetSearchString(String line, String searchString, int depth, String url)
    {
        String newLine = HTMLParser.ParseHtmlPara(line);
        if (newLine.contains(searchString))
        {
            searchStringList.add(new SearchStringDetails(url, doc.title(), newLine, depth));
            //System.out.println("New Line : " + result.text());
            //System.out.println(searchStringList.get(searchStringList.size()-1).toString());
        }
    }
}
