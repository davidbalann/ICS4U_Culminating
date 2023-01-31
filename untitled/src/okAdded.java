// Import required classes from the java.awt and javax.swing packages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

// Suppresses warnings about the use of non-lambda expressions
@SuppressWarnings("Convert2Lambda")
public class okAdded extends JFrame {
    // Declare private JPanel and JButton objects
    private JPanel okAddedPane;
    private JButton okButton;

    // Constructor for the okAdded class
    public okAdded() {
        // Sets the content pane for the JFrame to be the okAddedPane JPanel
        setContentPane(okAddedPane);
        // Sets the title of the JFrame to "View Recipes"
        setTitle("View Recipes");
        // Sets the size of the JFrame to 600x600 pixels
        setSize(600, 600);

        // Adds a window listener to the JFrame that will serialize the recipe list when the window is closing and exit the program
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        // Makes the JFrame visible
        setVisible(true);

        // Adds an action listener to the okButton that calls the home() method when the button is clicked
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home();
            }
        });
        // Adds a key listener to the okButton that calls the home() method when the enter key is pressed while the button is in focus
        okButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    home();
                }
            }
        });
    }

    // Method that creates a new homePage object and makes it visible, while disposing of the current okAdded object
    @SuppressWarnings("deprecation")
    void home() {
        homePage p1 = new homePage();
        p1.show();
        dispose();
    }
}