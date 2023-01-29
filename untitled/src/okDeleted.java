import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class okDeleted extends JFrame {
    private JButton okButton;
    private JPanel okPageDeleted;

    public okDeleted() {
        setContentPane(okPageDeleted);
        setTitle("Delete Recipe");
        setSize(600, 600);
         addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        setVisible(true);


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home();
            }
        });
        okButton.addKeyListener(new KeyAdapter() {
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
}
