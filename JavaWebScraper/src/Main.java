import Backend.Scraper;

import java.io.IOException;

public class Main {

    public static  void main(String[] args) throws IOException {
        //Gui gui = new Gui();
        //gui.setVisible(true);
        Scraper scraper = new Scraper();


        System.out.println("Running Scraper");
        scraper.Scrape("https://www.reddit.com/", 2,0);
    }
}
