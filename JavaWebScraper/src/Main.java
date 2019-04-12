import Backend.Controller;
import Frontend.Gui;


public class Main
{
    public static void main(String[] args)
    {
        Gui gui;
        gui = new Gui(900,600, new Controller() );
        gui.run();
    }
}
