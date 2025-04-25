import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("Convert2Lambda")
public class editRecipe extends JFrame {
    // JButton objects to handle button events
    private JButton addRecipeButton;
    private JButton removeRecipeButton;
    private JButton homeButton;
    // JPanel object to display UI
    private JPanel editRecipePage;

    public editRecipe() {
        // Set the content pane to editRecipePage JPanel
        setContentPane(editRecipePage);
        // Set the frame title
        setTitle("Recipe Manager");
        // Set the frame size
        setSize(400, 600);
        // Add window listener to save data before exit
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        // Make the frame visible
        setVisible(true);
        // Add ActionListener to homeButton to handle home button events
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home();
            }
        });
        // Add ActionListener to removeRecipeButton to handle remove button events
        removeRecipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove();
            }
        });
        // Add ActionListener to addRecipeButton to handle add button events
        addRecipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });
        // Add KeyListener to addRecipeButton to handle key events
        addRecipeButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    add();
                }
            }
        });
        // Add KeyListener to removeRecipeButton to handle key events
        removeRecipeButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    remove();
                }
            }
        });
        // Add KeyListener to homeButton to handle key events
        homeButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    home();
                }
            }
        });
    }

    // Show the home page
    void home(){
        homePage p1 = new homePage();
        p1.show();
        dispose();
    }
    @SuppressWarnings("deprecation")
    void remove(){
        // Create a new deletePage object
        deletePage p1 = new deletePage();
        // Show the deletePage window
        p1.show();
        // Close the current window (editRecipe)
        dispose();
    }

    @SuppressWarnings("deprecation")
    void add(){
        // Create a new addRecipe object
        addRecipe p1 = new addRecipe();
        // Show the addRecipe window
        p1.show();
        // Close the current window (editRecipe)
        dispose();
    }
}
