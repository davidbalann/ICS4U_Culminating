import java.io.*;
import java.util.ArrayList;

public class RecipeSerializer {
   // static String fileName = "recipe.ser";
    public static void serialize(ArrayList<Recipe> recipes,String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(recipes);
            out.close();
            fileOut.close();
            //System.out.println("Serialized data is saved in " + fileName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static ArrayList<Recipe> deserialize(String fileName) {
        ArrayList<Recipe> recipes = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            recipes = (ArrayList<Recipe>) in.readObject();
            in.close();
            fileIn.close();
        } catch (EOFException e){
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