import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class okPage extends JFrame {
    private JButton okButton;
    private JPanel okPanel;

    public okPage() {

        setContentPane(okPanel);
        //setTitle("Shop Recipes");
        setSize(400, 400);
         addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        setVisible(true);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage p1 = new homePage();
                p1.show();
                dispose();
            }
        });
    }
}
