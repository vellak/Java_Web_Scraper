package Backend;

import GUI.Gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * The type Csv creator.
 */
public class CSVCreator {


    private List<SearchStringDetails> SearchString;

    static void ConvertToCsv(List<String> listOfStrings) {
        String filePath = null;
        if (Gui.chooseFileLocationToSave()!= null) {

            filePath = Gui.chooseFileLocationToSave();
        }
        try{

            PrintWriter  pw= new PrintWriter( new BufferedWriter(new FileWriter(filePath, true)));
            for (String item: listOfStrings) {
                pw.println(item);
                pw.flush();
            }
            pw.close();
            GUI.Gui.showCSVSaved();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
            Gui.errorNull("File path is null");
        }

    }
}
