import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Class to create a frame for adding a new recipe to the recipe list
 * and perform related actions.
 */
@SuppressWarnings({"rawtypes", "Convert2Lambda"})
public class addRecipe extends JFrame {
    // GUI components for entering recipe details
    private  JTextField nameField;
    private JButton addRecipeButton;
    private JComboBox typeComboBox;
    private JButton backButton;
    private JPanel addNewPage;
    private JTextField durationField;
    private JTextField nrIngredientField;
    // GUI components for displaying error messages
    private JLabel nameError;
    private JLabel typeError;
    private JLabel durationError;
    private JLabel ingredientsError;

    /**
     * Constructor to initialize the frame and add action listeners
     * to buttons and text fields.
     */
    addRecipe() {
        setContentPane(addNewPage);
        setTitle("Add Recipe");
        setSize(600, 600);
        // Serialize recipe list before closing the frame
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        setVisible(true);
        // Action listener for back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });
        // Action listener for add recipe button
        addRecipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });
        // Key listener for enter key in nrIngredientField
        nrIngredientField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    add();
                }
            }
        });
        // Key listener for enter key in backButton
        backButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    back();
                }
            }
        });
        // Key listener for enter key in addRecipeButton
        addRecipeButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    add();
                }
            }
        });
    }

    /**
     * Method to add a new recipe to the recipe list
     * and display an error message if details are not valid.
     */

    /**
     * The add function is called when the "Add" button is clicked. It validates the input fields
     * and calls the RecipeManager to add the new recipe. If any field is empty or not valid, it
     * shows error messages.
     */
    void add(){
        nameError.setText("");
        typeError.setText("");
        durationError.setText("");
        ingredientsError.setText("");

        // Validate input fields
        if ((!nameField.getText().trim().isEmpty()) &&
                (!typeComboBox.getSelectedItem().toString().equals("Select One")) &&
                (isParseableToInt(durationField.getText())) &&
                (!durationField.getText().trim().isEmpty()) &&
                (!nrIngredientField.getText().trim().isEmpty())) {

            // Create a RecipeManager to add the new recipe
            RecipeManager add = new RecipeManager(nameField.getText(), typeComboBox.getSelectedItem().toString(),
                    Integer.parseInt(durationField.getText()), nrIngredientField.getText().split(","));
            add.addRecipes();

            // Show the okAdded dialog
            okAdded p1 = new okAdded();
            //noinspection deprecation
            p1.show();
            dispose();
        } else {
            // Show error messages if any field is empty or not valid
            if (nameField.getText().trim().isEmpty())
                nameError.setText("Please Enter Name Of Recipe");
            //noinspection DataFlowIssue
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

    /**
     * The back function is called when the "Back" button is clicked. It shows the editRecipe dialog.
     */
    @SuppressWarnings("deprecation")
    void back(){
        editRecipe p1 = new editRecipe();
        //noinspection deprecation
        p1.show();
        dispose();
    }

    /**
     * The isParseableToInt function checks if the input string can be parsed to an integer.
     * @param input The input string to be checked.
     * @return True if the input string can be parsed to an integer, otherwise false.
     */
    boolean isParseableToInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


