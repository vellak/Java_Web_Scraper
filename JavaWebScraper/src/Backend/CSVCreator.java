package Backend;

import GUI.Gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.AccessDeniedException;
import java.util.List;



public class CSVCreator
{
    static void ConvertToCsv(List<String> listOfStrings)
    {
        System.out.println("inside the ConvertToCsv() Method");
        String filePath = Gui.chooseFileLocationToSave();

        try
        {
            System.out.println("inside the ConvertToCsv()  Try Block");

            assert filePath != null;
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath +".csv", true)));

            for (String item : listOfStrings)
            {
                System.out.println("inside the ConvertToCsv()  Try Block{}  Loop");
                pw.println(item.split(",", 1)[0]);
                pw.flush();
            }
            pw.close();
            Gui.showCSVSaved();
        } catch (AccessDeniedException e){
            Gui.AccessDenied();
            ConvertToCsv(listOfStrings);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            Gui.errorNull("File path is null");
        }

    }
}
