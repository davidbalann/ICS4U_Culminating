import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * ingredientsPage class is a JFrame that displays the ingredients of a selected recipe
 * and provides a button to create a shopping list for the ingredients.
 */
public class ingredientsPage extends JFrame {
    // declare private instance variables
    private JButton makeTextFileShoppingButton;
    private JPanel ingredientsPanel;
    private JTextArea recipeDisplay;
    protected String title,text;

    /**
     * Constructor for ingredientsPage class
     * @param Recipe the name of the selected recipe
     */
    public ingredientsPage(String Recipe) {
        // initialize instance variables
        title = "";
        text  = "";
        // set content panel and frame properties
        setContentPane(ingredientsPanel);
        setTitle("Shop Recipes");
        setSize(600, 600);
        // add window listener to handle the serialization of recipe list before closing the window
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });

        // loop through recipe list to find the selected recipe
        for (int i = 0; i < Main.recipeList.size(); i++) {
            if (Main.recipeList.get(i).getName().equalsIgnoreCase(Recipe)) {
                // display ingredients of the selected recipe in recipeDisplay JTextArea
                recipeDisplay.setText(Main.recipeList.get(i).ingredientsToString());
                // set title and text variables to the name and ingredients of the selected recipe
                title = Main.recipeList.get(i).getName();
                text = Main.recipeList.get(i).ingredientsToString();
                break;
            }
        }

        // make the frame visible
        setVisible(true);

        // add action listener to the makeTextFileShoppingButton
        makeTextFileShoppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeFile();
            }
        });
        // add key listener to the makeTextFileShoppingButton
        makeTextFileShoppingButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    makeFile();
                }
            }
        });
    }

    /**
     * makeFile method creates a shopping list for the selected recipe ingredients
     * and displays a "OK" message in a new window.
     */
    void makeFile(){
        // call RecipeFileCreator to create the shopping list text file
        RecipeFileCreator.RecipeFileCreator(title, text);
        // create an instance of okPage class and make it visible
        okPage p1 = new okPage();
        p1.show();
        // dispose the ingredientsPage frame
        dispose();
    }
}

