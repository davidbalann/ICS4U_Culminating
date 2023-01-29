import java.io.*;
import java.util.*;

public class RecipeFileCreator {
    public static void RecipeFileCreator(String title, String text) {
        try {
            // Create the text file with the title and the .txt extension
            File file = new File("recipeLists/" + title + ".txt");
            file.createNewFile();

            // Write the text string to the file
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            writer.flush();
            writer.close();

            // Open the notepad application with the recently created text file
            Runtime.getRuntime().exec("notepad " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("An error occurred while creating the text file.");
        }
    }
}
