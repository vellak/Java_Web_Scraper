package Backend;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Controller
{
    private static Scraper scraper = new Scraper();

    public static void createCsv()
    {
        List<String> listOfStrings = ConvertSearchStringToString(scraper.getSearchStringList());
        CSVCreator.ConvertToCsv(listOfStrings);
    }

    private static List<String> ConvertSearchStringToString(List<SearchStringDetails> searchStringList)
    {
        List<String> strings = new ArrayList<>();
        for (SearchStringDetails searchString : searchStringList)
        {
            strings.add(searchString.toString());
        }
        return strings;
    }

    public static void Scrape(JEditorPane pane, JTextField URL, JTextField DepthOfSearch, JTextField searchString)
    {
        System.out.println("=============================");
        System.out.println("RUNNING SCRAPER");
        System.out.println("=============================");
        scraper.Scrape(URL.getText(), Integer.parseInt(DepthOfSearch.getText()), searchString.getText(), 0);

        for (String url : scraper.getListOfWebsitesVisited())
        {
            System.out.println(url);
        }

        for (SearchStringDetails details : scraper.getSearchStringList())
        {
            System.out.println(details.toString());
        }

        pane.setText(pane.getText() + "\n" + scraper.getSearchStringList());
    }

}
