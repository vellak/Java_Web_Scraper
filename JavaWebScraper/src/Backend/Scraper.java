package Backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
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
    private List<SearchStringDetails> searchStringList = new ArrayList<>();
    HTMLParser parser = new HTMLParser();

    /**
     * Scrape.
     *
     * @param URL               the URL
     * @param depthOfSearchText the depth of search URL
     * @param searchString      the search string
     * @param currentDepth      the current depth
     */
    void Scrape(String URL, int depthOfSearchText, String searchString, int currentDepth)
    {
        String line = null;
        line = WebsiteTraverser(URL, line);
        getLinks(line, depthOfSearchText, searchString, currentDepth);
        getSearchString(line, searchString, currentDepth, URL);

    }

    private String WebsiteTraverser(String URL, String line)
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(URL).openStream()));


            // converts website into a single line
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null)
            {
                //System.out.println("Building String");
                builder.append(line);

                //GetSearchString(line, searchString, depthOfSearchText, URL);
            }
            line = builder.toString();

            //System.out.println("Line: " + line);


            br.close();
        } catch (MalformedURLException e)
        {
            System.err.println("Malformed URL Found, I don't know, why this, happens");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return line;
    }

    /**
     * Gets search string list.
     *
     * @return the search string list
     */
    List<SearchStringDetails> getSearchStringList()
    {

        return searchStringList;
    }

    List<String> getListOfWebsitesVisited()
    {
        return listOfWebsitesVisited;
    }

    private void getLinks(String line, int depthOfSearchText, String searchString, int currentDepth)
    {

        String[] result = parser.ParseHtmlLink(line);
        if (result != null)
        {
            String newLine = result[0];

            if (!listOfWebsitesVisited.contains(newLine))
            {
                System.out.println(newLine);
                listOfWebsitesVisited.add(newLine);
                getLinks(result[1], depthOfSearchText, searchString, currentDepth);

                if (depthOfSearchText > currentDepth)
                {
                    Scrape(newLine, depthOfSearchText, searchString, currentDepth + 1);
                }
            }
        }
    }

    private void getSearchString(String line, String searchString, int depth, String url)
    {
        String[] result = parser.ParseHtmlPara(line);

        if (result != null)
        {
            String newLine = result[0];
            if (newLine.contains(searchString))
            {
                searchStringList.add(new SearchStringDetails(url, newLine, depth));
            }
            getSearchString(result[1], searchString, depth, url);
            //System.out.println("NEW STRING FOUND " +result[0]);
            //System.out.println("New Line : "  );
            //System.out.println(searchStringList.get(searchStringList.size()-1).toString());
        }
    }
}
