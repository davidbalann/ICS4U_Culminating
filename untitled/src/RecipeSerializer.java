import java.io.*;
import java.util.ArrayList;

/**
 * The RecipeSerializer class is responsible for serializing and deserializing an ArrayList of Recipe objects.
 *
 * The serialize method takes in an ArrayList of Recipe objects and a file name,
 * and saves the data to the specified file.
 *
 * The deserialize method takes in a file name, retrieves the data from the file,
 * and returns it as an ArrayList of Recipe objects.
 *
 * The class includes error handling for IOException, EOFException, and ClassNotFoundException.
 */
public class RecipeSerializer {
    /**
     * Serializes the ArrayList of Recipe objects and saves it to a file.
     *
     * @param recipes The ArrayList of Recipe objects to be serialized.
     * @param fileName The name of the file to save the data to.
     */
    public static void serialize(ArrayList<Recipe> recipes, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(recipes);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Deserializes the data from a file and returns it as an ArrayList of Recipe objects.
     *
     * @param fileName The name of the file to retrieve the data from.
     * @return The ArrayList of Recipe objects retrieved from the file.
     */
    public static ArrayList<Recipe> deserialize(String fileName) {
        ArrayList<Recipe> recipes = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            recipes = (ArrayList<Recipe>) in.readObject();
            in.close();
            fileIn.close();
        } catch (EOFException e) {
            System.out.print("File Empty");
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Recipe class not found");
            c.printStackTrace();
            return null;
        }
        return recipes;
    }
}
