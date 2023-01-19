import javax.annotation.processing.FilerException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
    public static void serialize(Object obj) {
        try {
            FileOutputStream fos = new FileOutputStream("recipes.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.print("COULDN'T FIND FILE");
        }
    }
}


