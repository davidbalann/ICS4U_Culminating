import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class shopPage extends JFrame {
    private JButton displayButton;
    private JComboBox comboBox1;
    private JTextArea displayStuffHereTextArea;
    private JButton backButton;
    private JButton continueButton;
    private JTextField textField1;
    private JPanel shopPage;


    public shopPage() {
        setContentPane(shopPage);
        setTitle("Shop Recipes");
        setSize(600, 600);
         addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        setVisible(true);

        for (int i = 0; i < Main.recipeList.size(); ++i)
            displayStuffHereTextArea.append(Main.recipeList.get(i).formattedToString());


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage p1 = new homePage();
                p1.show();
                dispose();
            }
        });
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingredientsPage p1 = new ingredientsPage();
                p1.show();
                dispose();
            }
        });
    }
}
