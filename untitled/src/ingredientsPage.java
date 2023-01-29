import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ingredientsPage extends JFrame {
    private JButton makeTextFileShoppingButton;
    private JPanel ingredientsPanel;
    private JTextArea recipeDisplay;
    protected String title,text;

    public ingredientsPage(String Recipe) {
        title = "";
        text  = "";
        setContentPane(ingredientsPanel);
        setTitle("Shop Recipes");
        setSize(600, 600);
         addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });

        for (int i = 0; i < Main.recipeList.size(); i++) {
            if (Main.recipeList.get(i).getName().equalsIgnoreCase(Recipe)) {
                recipeDisplay.setText(Main.recipeList.get(i).ingredientsToString());
                title = Main.recipeList.get(i).getName();
                text = Main.recipeList.get(i).ingredientsToString();
                break;
            }
        }

        setVisible(true);


        makeTextFileShoppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeFile();


            }
        });
        makeTextFileShoppingButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    makeFile();
                }
            }
        });
    }

    void makeFile(){
        RecipeFileCreator.RecipeFileCreator(title, text);


        okPage p1 = new okPage();
        p1.show();
        dispose();
    }
}
