import java.util.ArrayList;

/**
 * Main program (Controller) where the program starts
 * Deserializes the data from the file "recipe.ser" and stores it in the ArrayList
 * Displays the home page
 */
@SuppressWarnings({"JavadocDeclaration", "RedundantSuppression"})
public class Main {
    //Declares a static ArrayList to store recipes
    public static ArrayList<Recipe> recipeList = new ArrayList<>();

    public static void main(String[] args) {
        //Checks if recipeList is null, creates a new ArrayList if it is
        if (recipeList == null) {
            recipeList = new ArrayList<>();
        }
        //Deserializes the data from "recipe.ser"
        recipeList = RecipeSerializer.deserialize("recipe.ser");

        //Displays the home page
        @SuppressWarnings("unused") homePage display = new homePage();
    }
}
