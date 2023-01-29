import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class homePage extends JFrame {
    private JPanel MainPage;
    private JPanel mainPanel;
    private JLabel Title;
    private JButton quitButton;
    private JButton viewButton;
    private JButton shopButton;
    private JButton manageButton;

    public homePage() {
        setContentPane(mainPanel);
        setTitle("Recipe Manager");
        setSize(400, 600);
         addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
         try {
             UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
         }catch (Exception e){


         }

        setVisible(true);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quit();
            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view();
            }
        });
        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shop();
            }
        });
        manageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manage();
            }
        });
        viewButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    view();
                }
            }
        });
        shopButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    shop();
                }
            }
        });
        manageButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    manage();
                }
            }
        });
        quitButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    quit();
                }
            }
        });
    }

    void view(){
        viewPage p1 = new viewPage();
        p1.show();
        dispose();
    }
    void shop(){
        shopPage p1 = new shopPage();
        p1.show();
        dispose();
    }
    void manage(){
        editRecipe p1 = new editRecipe();
        p1.show();
        dispose();
    }
    void quit(){
        RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
        System.exit(0);
    }

}
