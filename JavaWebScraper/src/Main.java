import Backend.Scraper;
import GUI.Gui;

import java.io.IOException;
import java.net.MalformedURLException;

public class Main {

    public static  void main(String[] args){
        //Gui gui = new Gui();
        //gui.setVisible(true);
        Scraper scraper = new Scraper();


        try {
            scraper.Scrape("http://reddit.com/", 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
