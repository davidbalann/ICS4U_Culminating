import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class viewPage extends JFrame {
    private JButton homeButton;
    private JPanel viewPage;
    private JTextArea viewArea;
    private JComboBox comboBox1;
    private JButton displayButton;
    private JScrollPane scroll;

    public viewPage() {
        viewArea.setText("");
        setContentPane(viewPage);
        setTitle("View Recipes");
        setSize(600, 700);
         addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setViewportView(viewArea);
        setVisible(true);






        for (int i = 0; i < Main.recipeList.size(); ++i)
            viewArea.append(Main.recipeList.get(i).formattedToString());








        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage p1 = new homePage();
                p1.show();
                dispose();

            }
        });
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] order = RecipeManager.sortRecipe(comboBox1.getSelectedItem().toString());

                viewArea.setText("");
                for (int i = 0; i < Main.recipeList.size(); ++i)
                    viewArea.append(Main.recipeList.get(order[i]).formattedToString());
            }
        });
    }

}
