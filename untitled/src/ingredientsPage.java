import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ingredientsPage extends JFrame {
    private JTable table1;
    private JButton makeTextFileShoppingButton;
    private JPanel ingredientsPanel;


    public ingredientsPage() {
        setContentPane(ingredientsPanel);
        setTitle("Shop Recipes");
        setSize(600, 600);
         addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        setVisible(true);


        makeTextFileShoppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                okPage p1 = new okPage();
                p1.show();
                dispose();


            }
        });
    }
}
