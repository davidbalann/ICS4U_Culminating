import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Class okDeleted is a JFrame used to show a "delete recipe" message to the user.
 * It contains a single button "OK" that closes this window and opens the home page when clicked.
 */
@SuppressWarnings("Convert2Lambda")
public class okDeleted extends JFrame {
    private JButton okButton;
    private JPanel okPageDeleted;

    /**
     * Constructor for the okDeleted class.
     * Initializes the JFrame and adds an ActionListener to the okButton.
     */
    public okDeleted() {
        setContentPane(okPageDeleted);
        setTitle("Delete Recipe");
        setSize(600, 600);

        // Add a window listener to save the recipe list before closing the program.
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        setVisible(true);

        // Add an ActionListener to the okButton to open the home page.
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home();
            }
        });

        // Add a KeyListener to the okButton to open the home page when the enter key is pressed.
        okButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    home();
                }
            }
        });
    }

    /**
     * Method home is used to open the home page and dispose of the current JFrame.
     */
    @SuppressWarnings("deprecation")
    void home(){
        homePage p1 = new homePage();
        p1.show();
        dispose();
    }
}
