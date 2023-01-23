import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

    /**
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */


    public static void main(String[] args) throws IOException, ClassNotFoundException, EOFException {
        if (recipeList == null) {
            recipeList = new ArrayList<Recipe>();
        }
            recipeList = RecipeSerializer.deserialize("recipe.ser");


        homePage display = new homePage();
    }
}