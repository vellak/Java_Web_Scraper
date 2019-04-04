package GUI;

import Backend.Controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    private JEditorPane DataDisplay;
    private JTextField SearchString;

    public Gui()
    {
        add(RootPanel);
        setTitle("Web Scraper By Keith Vella");
        setSize(400, 500);
        DataDisplay.setContentType("text/html");

        DepthOfSearch.getDocument().addDocumentListener(new DocListener());

        Search.addActionListener(e -> {
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
        public void removeUpdate(DocumentEvent e){}

        @Override
        public void changedUpdate(DocumentEvent e)
        {
            DoSWarning();
        }
    }

}



