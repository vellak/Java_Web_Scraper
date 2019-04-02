package GUI;

import Backend.Scraper;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Gui  extends JFrame{
    private JPanel RootPanel;
    private JButton CSVButton;
    private JButton Search;
    private JTextField URL;
    private JTextField DepthOfSearch;
    private JEditorPane DataDisplay;
    private JTextField searchString;

    public Gui(){

        add(RootPanel);

        setTitle("Web Backend.Scraper By Keith Vella");
        setSize(400,500);


        DepthOfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                DoSWarning();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //DoSWarning();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                DoSWarning();
            }
        });
        Search.addActionListener(e -> {
            Scraper scraper = new Scraper();

                    System.out.println(URL.getText() + " URL TEXT");
                    scraper.Scrape(URL.getText(), Integer.parseInt(DepthOfSearch.getText()),0);
                }
        );
        CSVButton.addActionListener(e -> {
            CSVMethod();
        });

    }
    private void CSVMethod() {

    }

    private void DoSWarning(){

        try{
            if (Integer.parseInt(DepthOfSearch.getText()) <1 )
            {
                JOptionPane.showMessageDialog(null, "Enter a Positive number!", "Input Error",JOptionPane.ERROR_MESSAGE);
            }
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Enter a number!", "Input Error",JOptionPane.ERROR_MESSAGE);
        }


    }

}


