import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editRecipe extends JFrame{
    private JButton addRecipeButton;
    private JButton removeRecipeButton;
    private JButton homeButton;
    private JPanel editRecipePage;

    public editRecipe() {

        setContentPane(editRecipePage);
        setTitle("Recipe Manager");
        setSize(400,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    homeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            homePage p1 = new homePage();
            p1.show();
            dispose();
        }
    });
        removeRecipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePage p1 = new deletePage();
                p1.show();
                dispose();
            }
        });
        addRecipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecipe p1 = new addRecipe();
                p1.show();
                dispose();
            }
        });
    }
}
