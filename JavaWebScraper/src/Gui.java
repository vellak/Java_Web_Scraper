import javax.swing.*;

public class Gui  extends JFrame{
    private JPanel RootPanel;
    private JButton CSVButton;
    private JButton Search;
    private JTextField URL;
    private JTextField DepthOfSearch;
    private JEditorPane DataDisplay;

    Gui(){

        add(RootPanel);
        setTitle("Web Scraper By Keith Vella");
        setSize(400,500);
    }


}
