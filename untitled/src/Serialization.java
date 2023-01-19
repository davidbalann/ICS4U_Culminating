import java.io.*;

public class Serialization {

    public void serialize(Object obj) throws IOException {
        File file = new File("recipe.ser");
        if(!file.exists()) {
            file.createNewFile();
        }
        try (FileOutputStream fileOut = new FileOutputStream("recipe.ser", true);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(obj);
        }
    }

    public Object deserialize() throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream("recipe.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return in.readObject();
        }
    }
}
