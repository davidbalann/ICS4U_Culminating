import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class addRecipe extends JFrame {
    private  JTextField nameField;
    private JButton addRecipeButton;
    private JComboBox typeComboBox;
    private JButton backButton;
    private JPanel addNewPage;
    private JTextField durationField;
    private JTextField nrIngredientField;

    addRecipe() {

        setContentPane(addNewPage);
        setTitle("Delete Recipe");
        setSize(600, 600);
         addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        setVisible(true);



        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editRecipe p1 = new editRecipe();
                p1.show();
                dispose();
            }
        });
        addRecipeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


               RecipeManager add = new RecipeManager(nameField.getText(),typeComboBox.getSelectedItem().toString(),Integer.parseInt(durationField.getText()),nrIngredientField.getText().split(","));
               add.addRecipes();

                okAdded p1 = new okAdded();
                p1.show();
                dispose();
            }
        });
    }
}
