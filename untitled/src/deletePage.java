import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class deletePage extends JFrame {
    private JTextArea textArea1;
    private JButton deleteButton;
    private JTextField deletedValue;
    private JButton backButton;
    private JPanel deleteRecipePage;

    deletePage() {
        setContentPane(deleteRecipePage);
        setTitle("Delete Recipe");
        setSize(600, 600);
         addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        setVisible(true);
        for (int i = 0; i < Main.recipeList.size(); ++i)
            textArea1.append(Main.recipeList.get(i).formattedToString());


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editRecipe p1 = new editRecipe();
                p1.show();
                dispose();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = deletedValue.getText();
                for (int i = 0; i < Main.recipeList.size(); i++) {
                    if (Main.recipeList.get(i).getName().equalsIgnoreCase(name)) {
                        Main.recipeList.remove(i);
                        break;
                    }
                }
                okDeleted p1 = new okDeleted();
                p1.show();
                dispose();
            }
        });
    }

    public static void deleteRecipeByName(ArrayList<Recipe> recipeList) {

    }
}
