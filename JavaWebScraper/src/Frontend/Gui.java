package Frontend;

import Backend.Controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;

public class Gui
{
    private JButton CSVButton;
    private JButton Search;
    private JTextField URL;
    private JTextField DepthOfSearch;
    private JTable DataDisplay;
    private JTextField SearchString;
    private JLabel StatusLabel;
    private JFrame frame;

    private Controller controller;

    private int width;
    private int height;

    public Gui(int width, int height, Controller c){
        this.width = width;
        this.height = height;
        controller = c;

    }
    public void run(){


        CreateGui();
        frame.setVisible(true);
        DepthOfSearch.getDocument().addDocumentListener(new DocListener());

        Search.addActionListener(e ->
        {
            StatusLabel.setText("Please Wait, Scraping Websites...");
            try
            {
                Thread.sleep(200);
            } catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
            controller.Scrape((DefaultTableModel) DataDisplay.getModel(), StatusLabel, URL, DepthOfSearch, SearchString);
            System.out.println("Search is over");
        });

        CSVButton.addActionListener(e -> controller.createCsv());
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
                DepthOfSearch.setText("");
            }
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Enter a number!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void CreateGui()
    {
        //FRAME
        frame = new JFrame();
            frame.setTitle("Web Scraper By Keith Vella");
            frame.setSize(width, height);

        //Root Panels

        JPanel rootPanel = new JPanel();
            rootPanel.setLayout(new BorderLayout(0, 0));
            rootPanel.setPreferredSize(new Dimension(1280, 1024));
            frame.add(rootPanel);

        //TOP BAR
        JPanel top_Bar = new JPanel();
            top_Bar.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
            rootPanel.add(top_Bar, BorderLayout.NORTH);


        //CENTRE AREA
        JPanel centreArea = new JPanel();
            centreArea.setLayout(new BorderLayout(0, 0));
            centreArea.setAutoscrolls(true);
            centreArea.setMinimumSize(new Dimension(200, 200));
            centreArea.putClientProperty("html.disable", Boolean.FALSE);
            rootPanel.add(centreArea, BorderLayout.CENTER);

        //TOP BAR COMPONENTS
        URL = new JTextField();
            URL.setMinimumSize(new Dimension(200, 30));
            URL.setPreferredSize(new Dimension(400, 30));
            URL.setText("Enter A URL");
            top_Bar.add(URL);

        DepthOfSearch = new JTextField();
            DepthOfSearch.setMinimumSize(new Dimension(100, 30));
            DepthOfSearch.setPreferredSize(new Dimension(100, 30));
            DepthOfSearch.setText("2");
            top_Bar.add(DepthOfSearch);

        SearchString = new JTextField();
            SearchString.setMinimumSize(new Dimension(100, 30));
            SearchString.setText("Search String!");
            top_Bar.add(SearchString);

        Search = new JButton();
            Search.setText("Start Search");
            top_Bar.add(Search);

        CSVButton = new JButton();
            CSVButton.setText("Save To CSV");
            top_Bar.add(CSVButton);
        StatusLabel = new JLabel();
            StatusLabel.setText("Please Enter the Information Required and Press Search");
            top_Bar.add(StatusLabel);
        // CENTER AREA COMPONENTS
        DefaultTableModel model = new DefaultTableModel();
        DataDisplay = new JTable(model);
            model.addColumn("URL");
            model.addColumn("LINE");
            model.addColumn("DEPTH");

            DataDisplay.setAutoCreateRowSorter(false);
            DataDisplay.setFillsViewportHeight(true);
            centreArea.add(new JScrollPane(DataDisplay), BorderLayout.CENTER);

    }

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
