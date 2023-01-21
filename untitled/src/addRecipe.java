import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class addRecipe extends JFrame{
    private JTextField nameField;
    private JButton addRecipeButton;
    private JComboBox typeComboBox;
    private JButton backButton;
    private JPanel addNewPage;
    private JTextField durationField;
    private JTextField nrIngrediantsField;

    public addRecipe() {

        setContentPane(addNewPage);
        setTitle("Delete Recipe");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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


            String name    = nameField.getText();
            String type    = typeComboBox.getSelectedItem().toString();
            int duration   = Integer.parseInt(durationField.getText());


            ArrayList<String> nrIng = new ArrayList<String>();
            String[] ingredients = nrIngrediantsField.getText().split(",");
            nrIng.addAll(Arrays.asList(ingredients));

            if (Main.recipeList == null) {
                Main.recipeList = new ArrayList<Recipe>();
            }
            Main.recipeList.add( new Recipe(name,type,duration,nrIng));

            okAdded p1 = new okAdded();
            p1.show();
            dispose();
        }
    });
}
}
