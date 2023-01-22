import java.util.ArrayList;
import java.util.Arrays;

public class RecipeManager {


    String name;
    String type;
    int duration;
    ArrayList<String> nrIng = new ArrayList<>();

    public RecipeManager(String name, String type, int duration,  String[] ingrediants){
        this.name = name;
        this.type = type;
        this.duration = duration;
        nrIng.addAll(Arrays.asList(ingrediants));
    }

    public void addRecipes(){
        if (Main.recipeList == null) {
            Main.recipeList = new ArrayList<Recipe>();
        }
        Main.recipeList.add(new Recipe(name, type, duration, nrIng));
    }


}
