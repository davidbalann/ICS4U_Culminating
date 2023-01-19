import java.io.*;

public class Serialization {

    public void serialize(Object obj) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream("recipe.txt");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(obj);
        }
    }

    public Object deserialize() throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream("recipe.txt");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return in.readObject();
        }
    }
}