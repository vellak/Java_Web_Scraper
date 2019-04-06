package GUI;

import Backend.Controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

/**
 * The type Gui.
 */
public class Gui extends JFrame
{
    private JPanel RootPanel;
    private JButton CSVButton;
    private JButton Search;
    private JTextField URL;
    private JTextField DepthOfSearch;
    private JTable DataDisplay;
    private JTextField SearchString;
    private JPanel Top_Bar;
    private JPanel CentreArea;

    public Gui()
    {
        $$$setupUI$$$();
        add(RootPanel);
        setTitle("Web Scraper By Keith Vella");
        setSize(400, 500);


        DepthOfSearch.getDocument().addDocumentListener(new DocListener());

        Search.addActionListener(e ->
        {
            Controller.Scrape(DataDisplay, URL, DepthOfSearch, SearchString);
            System.out.println("Search is over");
        });

        CSVButton.addActionListener(e -> Controller.createCsv());
    }

    public static void showCSVSaved()
    {
        JOptionPane.showMessageDialog(null, "CSV File Saved");
    }

    public static void errorNull(String error)
    {
        JOptionPane.showMessageDialog(null, error);
    }

    public static String chooseFileLocationToSave()
    {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setDialogTitle("");
        fileChooser.setCurrentDirectory(new File("c:\\"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("text Files", "txt"));

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            File file = fileChooser.getSelectedFile();
            return file.getAbsolutePath();
        }
        return null;
    }

    public static void AccessDenied()
    {
        JOptionPane.showMessageDialog(null, "Access Denied", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    private void DoSWarning()
    {
        // checks for invalid values
        try
        {
            if (Integer.parseInt(DepthOfSearch.getText()) < 0)
            {
                JOptionPane.showMessageDialog(null, "Enter a Positive number!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Enter a number!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        RootPanel = new JPanel();
        RootPanel.setLayout(new BorderLayout(0, 0));
        RootPanel.setPreferredSize(new Dimension(1280, 1024));
        CentreArea = new JPanel();
        CentreArea.setLayout(new BorderLayout(0, 0));
        CentreArea.setAutoscrolls(true);
        CentreArea.setMinimumSize(new Dimension(200, 200));
        CentreArea.putClientProperty("html.disable", Boolean.FALSE);
        RootPanel.add(CentreArea, BorderLayout.CENTER);
        DataDisplay = new JTable();
        DataDisplay.setAutoCreateRowSorter(false);
        DataDisplay.setFillsViewportHeight(true);
        CentreArea.add(DataDisplay, BorderLayout.CENTER);
        Top_Bar = new JPanel();
        Top_Bar.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        RootPanel.add(Top_Bar, BorderLayout.NORTH);
        URL = new JTextField();
        URL.setMinimumSize(new Dimension(200, 30));
        URL.setPreferredSize(new Dimension(400, 30));
        URL.setText("Enter A URL");
        Top_Bar.add(URL);
        DepthOfSearch = new JTextField();
        DepthOfSearch.setMinimumSize(new Dimension(100, 30));
        DepthOfSearch.setPreferredSize(new Dimension(100, 30));
        DepthOfSearch.setText("2");
        Top_Bar.add(DepthOfSearch);
        SearchString = new JTextField();
        SearchString.setMinimumSize(new Dimension(100, 30));
        SearchString.setText("Search String!");
        Top_Bar.add(SearchString);
        Search = new JButton();
        Search.setText("Start Search");
        Top_Bar.add(Search);
        CSVButton = new JButton();
        CSVButton.setText("Save To CSV");
        Top_Bar.add(CSVButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return RootPanel;
    }

    /**
     * The type Doc listener.
     */
    class DocListener implements DocumentListener
    {
        @Override
        public void insertUpdate(DocumentEvent e)
        {
            DoSWarning();
        }

        @Override
        public void removeUpdate(DocumentEvent e)
        {
        }

        @Override
        public void changedUpdate(DocumentEvent e)
        {
            DoSWarning();
        }
    }

}



