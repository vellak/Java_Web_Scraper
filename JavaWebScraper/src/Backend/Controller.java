package Backend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class Controller
{
    private Scraper scraper = new Scraper();

    public void createCsv()
    {
        List<String> listOfStrings = ConvertSearchStringToString(scraper.getSearchStringList());
        CSVCreator.ConvertToCsv(listOfStrings);
    }

    private List<String> ConvertSearchStringToString(List<SearchStringDetails> searchStringList)
    {
        List<String> strings = new ArrayList<>();
        for (SearchStringDetails searchString : searchStringList)
        {
            strings.add(searchString.toString());
        }
        return strings;
    }

    public void Scrape(DefaultTableModel tableModel,JLabel label, JTextField URL, JTextField DepthOfSearch, JTextField searchString)
    {
        scraper.resetLists();
        System.out.println("=============================");
        System.out.println("RUNNING SCRAPER");
        System.out.println("=============================");

        scraper.Scrape(URL.getText(), Integer.parseInt(DepthOfSearch.getText()), searchString.getText(), 0);

        for (String url : scraper.getListOfWebsitesVisited())
        {
            System.out.println(url);
        }
        tableModel.setRowCount(0);
        for (SearchStringDetails details : scraper.getSearchStringList())
        {

            System.out.println(details.toString());
            tableModel.addRow(new Object[]{details.getURL(), details.getHTMLCode(), String.valueOf(details.getDepth())});
        }
        label.setText("Scraping Complete!");



    }


}
