import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class addRecipe extends JFrame {
    private  JTextField nameField;
    private JButton addRecipeButton;
    private JComboBox typeComboBox;
    private JButton backButton;
    private JPanel addNewPage;
    private JTextField durationField;
    private JTextField nrIngredientField;
    private JLabel nameError;
    private JLabel typeError;
    private JLabel durationError;
    private JLabel ingredientsError;

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
                back();
            }
        });
        addRecipeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });

        nrIngredientField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    add();
                }
            }
        });
        backButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    back();
                }
            }
        });
        addRecipeButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    add();
                }
            }
        });
    }

    void add(){
            nameError.setText("");
            typeError.setText("");
            durationError.setText("");
            ingredientsError.setText("");
           /* if(durationField.getText().trim().isEmpty())
                durationField.setText(".");*/
            if ((!nameField.getText().trim().isEmpty()) &&
                    (!typeComboBox.getSelectedItem().toString().equals("Select One")) &&
                    (isParseableToInt(durationField.getText())) &&
                    (!durationField.getText().trim().isEmpty()) &&
                    (!nrIngredientField.getText().trim().isEmpty())) {
                RecipeManager add = new RecipeManager(nameField.getText(), typeComboBox.getSelectedItem().toString(), Integer.parseInt(durationField.getText()), nrIngredientField.getText().split(","));
                add.addRecipes();

                okAdded p1 = new okAdded();
                p1.show();
                dispose();
            } else {
                if (nameField.getText().trim().isEmpty())
                    nameError.setText("Please Enter Name Of Recipe");
                if (typeComboBox.getSelectedItem().toString().equals("Select One"))
                    typeError.setText("Please Select Type");
                if (durationField.getText().trim().isEmpty())
                    durationError.setText("Please Enter Duration");
                else if (!isParseableToInt(durationField.getText()))
                    durationError.setText("Please Enter Integer");
                if (nrIngredientField.getText().trim().isEmpty())
                    ingredientsError.setText("Please Enter Ingredients");

            }

    }
    void back(){
        editRecipe p1 = new editRecipe();
        p1.show();
        dispose();

    }

     boolean isParseableToInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


