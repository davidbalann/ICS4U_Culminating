import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class shopPage extends JFrame {
    private JButton displayButton;
    private JComboBox comboBox1;
    private JTextArea viewArea;
    private JButton backButton;
    private JButton continueButton;
    private JTextField recipeShop;
    private JPanel shopPage;
    private JScrollPane scroll;
    private JLabel errorLable;
    private JLabel secondLable;


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
        scroll.setBounds(100,100, 50,100);
        scroll.setViewportView(viewArea);
        viewArea.setLineWrap(true);
        viewArea.setWrapStyleWord(true);
        scroll.setViewportView(viewArea);
        //scroll.add(viewArea);
        setVisible(true);

        for (int i = 0; i < Main.recipeList.size(); ++i)
            viewArea.append(Main.recipeList.get(i).formattedToString());


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                continuePage();
            }
        });
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display();
            }
        });
        recipeShop.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    continuePage();
                }
            }
        });
        displayButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    display();
                }
            }
        });
        backButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    back();
                }
            }
        });
        continueButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    continuePage();
                }
            }
        });
    }

    void continuePage(){
        if(!(recipeShop.getText().trim().isEmpty())){
        ingredientsPage p1 = new ingredientsPage(recipeShop.getText());
        p1.show();
        dispose();
        }
        else {
            secondLable.setText("Please Enter Proper Data");
        }
    }
    void display(){
        int[] order = RecipeManager.sortRecipe(comboBox1.getSelectedItem().toString());

        viewArea.setText("");
        for (int i = 0; i < Main.recipeList.size(); ++i)
            viewArea.append(Main.recipeList.get(order[i]).formattedToString());
    }
    void back(){
        homePage p1 = new homePage();
        p1.show();
        dispose();
    }
}


