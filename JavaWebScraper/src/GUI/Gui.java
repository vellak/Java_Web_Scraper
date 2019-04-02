package GUI;

import Backend.Scraper;
import Backend.WebsiteDetails;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;

public class Gui  extends JFrame{
    private JPanel RootPanel;
    private JButton CSVButton;
    private JButton Search;
    private JTextField URL;
    private JTextField DepthOfSearch;
    private JEditorPane DataDisplay;

    public Gui(){

        add(RootPanel);
        setTitle("Web Backend.Scraper By Keith Vella");
        setSize(400,500);

        int depthValue  = 0;
        try {
            depthValue =   Integer.parseInt(DepthOfSearch.getText());
        }catch (NumberFormatException e){
                // error message
                JOptionPane.showMessageDialog(null, "Enter a number!", "Input Error",JOptionPane.WARNING_MESSAGE);
        }
        // actions for buttons

        int finalDepthValue = depthValue;
        Search.addActionListener(e -> {
            Backend.Scraper scraper = new Scraper();
                    scraper.Scrape(URL.getText(), finalDepthValue, 0);
                }
        );
        CSVButton.addActionListener(e -> {
            CSVMethod();
        });

    }
    public void PopulateDataDisplay(WebsiteDetails website){

    }
    private void CSVMethod() {

    }


}


