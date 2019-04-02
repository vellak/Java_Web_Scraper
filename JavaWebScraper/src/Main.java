import Backend.Scraper;

public class Main {

    public static  void main(String[] args){
        //Gui gui = new Gui();
        //gui.setVisible(true);
        Scraper scraper = new Scraper();


        System.out.println("Running Scraper");
        scraper.Scrape("https://www.youtube.com/", 1);
    }
}
