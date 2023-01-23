import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        setVisible(true);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPage p1 = new viewPage();
                p1.show();
                dispose();
            }
        });
        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shopPage p1 = new shopPage();
                p1.show();
                dispose();
            }
        });
        manageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editRecipe p1 = new editRecipe();
                p1.show();
                dispose();
            }
        });
    }


}
