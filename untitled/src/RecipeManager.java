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

    public static int[] sortRecipe(String sortType) {
        int[] order = new int[Main.recipeList.size()];
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }
        if(sortType.equals("Title")) {
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

        else if (sortType.equals("Type")) {
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
        else if (sortType.equals("Duration")){

            for (int i = 1; i < order.length; i++) {
                int key = order[i];
                int j = i - 1;

                while (j >= 0 && Main.recipeList.get(order[j]).Duration > Main.recipeList.get(key).Duration) {
                    order[j + 1] = order[j];
                    j--;
                }
                order[j + 1] = key;
            }
        }
        else if (sortType.equals("Nr. Of Ingrediants")){

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

        return order;
    }

}
