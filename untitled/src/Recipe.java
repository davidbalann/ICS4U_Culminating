import java.util.ArrayList;
import java.util.Arrays;

public class Recipe {
    public String Name,Type;
    public int Duration, nrIng;
    public String[] IngList;

    Recipe(String name,String type, int duration, String[] ingList){
        Name = name;
        Type = type;
        Duration = duration;
        IngList = ingList;
        nrIng = ingList.length;
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

    public String[] getIngList() {
        return IngList;
    }

    public void setIngList(String[] ingList) {
        IngList = ingList;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "Name ='" + Name + '\'' +
                ", Type= '" + Type + '\'' +
                ", Duration= " + Duration +
                ", nrIng= " + nrIng +
                ", IngList= " + Arrays.toString(IngList) +
                '}';
    }

    public String formattedToString() {
        return "\n----------------------------------------\n" +
                "Name                  " + Name  +"\n"+
                "Type                  " + Type +"\n"+
                "Duration              " + Duration +"\n"+
                "Number Of Ingrediants " + nrIng +"\n"+
                "Ingrediant List: \n\t\t " +  Arrays.toString(IngList)
                .replace(",", "\n\t\t")  //remove the commas
                .replace("[", "\n\t\t")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim();
    }
}
