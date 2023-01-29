import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class editRecipe extends JFrame {
    private JButton addRecipeButton;
    private JButton removeRecipeButton;
    private JButton homeButton;
    private JPanel editRecipePage;

    public editRecipe() {

        setContentPane(editRecipePage);
        setTitle("Recipe Manager");
        setSize(400, 600);
         addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        setVisible(true);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home();
            }
        });
        removeRecipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove();
            }
        });
        addRecipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });
        addRecipeButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    add();
                }
            }
        });
        removeRecipeButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    remove();
                }
            }
        });
        homeButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    home();
                }
            }
        });
    }

    void home(){
        homePage p1 = new homePage();
        p1.show();
        dispose();
    }
    void remove(){

        deletePage p1 = new deletePage();
        p1.show();
        dispose();
    }
    void add(){
        addRecipe p1 = new addRecipe();
        p1.show();
        dispose();
    }
}
