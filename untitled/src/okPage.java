import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("Convert2Lambda")
public class okPage extends JFrame {
    private JButton okButton;
    private JPanel okPanel;

    // Constructor for the okPage class
    public okPage() {

        // Sets the content panel to the okPanel JPanel
        setContentPane(okPanel);
        // Sets the title of the JFrame window
        //setTitle("Shop Recipes");
        // Sets the size of the JFrame window
        setSize(400, 400);
        // Add a window listener to serialize the recipe list and exit the program
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        // Makes the JFrame window visible
        setVisible(true);
        // Adds an action listener to the okButton, which will call the home() method
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home();
            }
        });
        // Adds a key listener to the okButton, which will call the home() method when the "Enter" key is pressed
        okButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    home();
                }
            }
        });
    }
    // home method to switch to the homePage JFrame window
    @SuppressWarnings("deprecation")
    void home(){
        homePage p1 = new homePage();
        // Makes the homePage JFrame window visible
        p1.show();
        // Disposes of the current okPage JFrame window
        dispose();
    }
}
