import java.util.ArrayList;

/**
 * This class represents a recipe with its details, such as name, type, duration,
 * number of ingredients and a list of ingredients.
 * It implements the Serializable interface to allow saving of objects.
 *
 * @author YourName
 */
@SuppressWarnings("ALL")
public class Recipe implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String type;
    private int duration;
    private final int nrIng;
    private ArrayList<String> ingList;

    /**
     * Constructor to create a new recipe object
     * @param name name of the recipe
     * @param type type of the recipe
     * @param duration duration of the recipe
     * @param ingList list of ingredients for the recipe
     */
    Recipe(String name, String type, int duration, ArrayList<String> ingList) {
        this.name = name;
        this.type = type;
        this.duration = duration;
        this.ingList = ingList;
        this.nrIng = ingList.size();
    }

    /**
     * Getter for the name of the recipe
     * @return name of the recipe
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the recipe
     * @param name new name for the recipe
     */
    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the type of the recipe
     * @return type of the recipe
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for the type of the recipe
     * @param type new type for the recipe
     */
    @SuppressWarnings("unused")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for the duration of the recipe
     * @return duration of the recipe
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Setter for the duration of the recipe
     * @param duration new duration for the recipe
     */
    @SuppressWarnings("unused")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Getter for the list of ingredients of the recipe
     * @return list of ingredients for the recipe
     */
    public ArrayList<String> getIngList() {
        return ingList;
    }

    /**
     * Setter for the list of ingredients of the recipe
     * @param ingList new list of ingredients for the recipe
     */
    @SuppressWarnings("unused")
    public void setIngList(ArrayList<String> ingList) {
        this.ingList = ingList;
    }

    /**
     * Overridden method to return a string representation of the recipe
     * @return string representation of the recipe
     */
    @Override
    public String toString() {//to string method for simple display
        return "Recipe{" +
                "Name ='" + name + '\'' +
                ", Type = '" + type + '\'' +
                ", Duration = " + duration +
                ", nrIng = " + nrIng +
                ", IngList = " + ingList.toString() +
                '}';
    }

    /**
     * @return string representation of the recipe
     */
    public String formattedToString() {//formatted to string method for nicer output
        return "\n----------------------------------------\n" +
                "Name                  " + name + "\n" +
                "Type                  " + type + "\n" +
                "Duration              " + duration + "\n" +
                "Number Of Ingredients " + nrIng + "\n" +
                "Ingredient List: \n\t\t " + ingList.toString()
                .replace(",", "\n\t\t")  //remove the commas
                .replace("[", "\n\t\t")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim();
    }
    /**
     * @return string representation of the recipe
     */
    public String ingredientsToString() {//to string method for the shopping list
        return  "Name                  " + name + "\n" +
                "Number Of Ingredients " + nrIng + "\n" +
                "Ingredient List:\n\t\t " + ingList.toString()
                .replace(",", "\n\t\t")  //remove the commas
                .replace("[", "\n\t\t ")  //remove the right bracket
                .replace("]", " ")  //remove the left bracket
                .trim();
    }
}

