import java.util.ArrayList;
import java.util.Arrays;

/**
 * The RecipeManager class is responsible for adding a new recipe, deleting any recipe and sorting the recipes
 */
public class RecipeManager {


    final String name;
    final String type;
    final int duration;
    final ArrayList<String> nrIng = new ArrayList<>();

    public RecipeManager(String name, String type, int duration,  String[] ingrediants){//constructor for recipe to be added
        this.name = name;
        this.type = type;
        this.duration = duration;
        nrIng.addAll(Arrays.asList(ingrediants));
    }

    @SuppressWarnings("Convert2Diamond")
    public void addRecipes(){//adds created recipe to the arraylists of recipes
        if (Main.recipeList == null) {
            Main.recipeList = new ArrayList<Recipe>();
        }
        Main.recipeList.add(new Recipe(name, type, duration, nrIng));
    }

    @SuppressWarnings("IfCanBeSwitch")
    public static int[] sortRecipe(String sortType) {//method to return an order to display sorted recipe based on title,type,duration or number of ingredients

        int[] order = new int[Main.recipeList.size()];//makes new sort order based on size of arraylist recipelist
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }//initializes array with 0 -> arraylist.length
        if(sortType.equals("Title")) {//sorts alphabetically based on title
            for (int i = 0; i < order.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < order.length; j++) {
                    if (Main.recipeList.get(order[j]).getName().compareTo(Main.recipeList.get(order[min]).getName()) < 0) {
                        min = j;
                    }
                }
                if (min != i) {
                    int temp = order[i];
                    order[i] = order[min];
                    order[min] = temp;
                }
            }
        }

        else if (sortType.equals("Type")) {//sorts alphabetically based on type
            for (int i = 0; i < Main.recipeList.size(); i++) {
                for (int j = i; j > 0; j--) {
                    if (Main.recipeList.get(j).getType().compareTo(Main.recipeList.get(j - 1).getType()) < 0) {
                        Recipe temp = Main.recipeList.get(j);
                        Main.recipeList.set(j, Main.recipeList.get(j - 1));
                        Main.recipeList.set(j - 1, temp);
                        int tempOrder = order[j];
                        order[j] = order[j - 1];
                        order[j - 1] = tempOrder;
                    }
                }
            }
        }
        else if (sortType.equals("Duration")){//sorts numerically based on duration

            for (int i = 1; i < order.length; i++) {
                int key = order[i];
                int j = i - 1;

                while (j >= 0 && Main.recipeList.get(order[j]).getDuration()> Main.recipeList.get(key).getDuration()) {
                    order[j + 1] = order[j];
                    j--;
                }
                order[j + 1] = key;
            }
        }
        else if (sortType.equals("Nr. Of Ingrediants")){//sorts numerically based on number of ingredients

            boolean isSorted = false;
            while (!isSorted) {
                isSorted = true;
                for (int i = 0; i < order.length - 1; i++) {
                    if (Main.recipeList.get(order[i]).getIngList().size() > Main.recipeList.get(order[i + 1]).getIngList().size()) {
                        int temp = order[i];
                        order[i] = order[i + 1];
                        order[i + 1] = temp;
                        isSorted = false;
                    }
                }
            }

        }

        return order;//returns based on sorted order
    }

}
