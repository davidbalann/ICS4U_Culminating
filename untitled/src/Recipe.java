import java.util.ArrayList;

public class Recipe implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    public String Name, Type;
    public int Duration, nrIng;
    public ArrayList<String> IngList;

    Recipe(String name, String type, int duration, ArrayList<String> ingList) {
        Name = name;
        Type = type;
        Duration = duration;
        IngList = ingList;
        nrIng = ingList.size();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public ArrayList<String> getIngList() {
        return IngList;
    }

    public void setIngList(ArrayList<String> ingList) {
        IngList = ingList;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "Name ='" + Name + '\'' +
                ", Type = '" + Type + '\'' +
                ", Duration = " + Duration +
                ", nrIng = " + nrIng +
                ", IngList = " + IngList.toString() +
                '}';
    }

    public String formattedToString() {
        return "\n----------------------------------------\n" +
                "Name                  " + Name + "\n" +
                "Type                  " + Type + "\n" +
                "Duration              " + Duration + "\n" +
                "Number Of Ingredients " + nrIng + "\n" +
                "Ingredient List: \n\t\t " + IngList.toString()
                .replace(",", "\n\t\t")  //remove the commas
                .replace("[", "\n\t\t")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim();
    }
}
