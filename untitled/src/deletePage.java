import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class deletePage extends JFrame {
    private JTextArea viewArea;
    private JButton deleteButton;
    private JTextField deletedValue;
    private JButton backButton;
    private JPanel deleteRecipePage;
    private JScrollPane scroll;

    deletePage() {
        setContentPane(deleteRecipePage);
        setTitle("Delete Recipe");
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
        setVisible(true);;
        for (int i = 0; i < Main.recipeList.size(); ++i)
            viewArea.append(Main.recipeList.get(i).formattedToString());


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleted();

            }
        });
        deletedValue.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    deleted();
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
        deleteButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    deleted();
                }
            }
        });
    }

    void back(){
        editRecipe p1 = new editRecipe();
        p1.show();
        dispose();
    }
    void deleted(){

        String name = deletedValue.getText();
        for (int i = 0; i < Main.recipeList.size(); i++) {
            if (Main.recipeList.get(i).getName().equalsIgnoreCase(name)) {
                Main.recipeList.remove(i);
                break;
            }
        }
        okDeleted p1 = new okDeleted();
        p1.show();
        dispose();
    }
}
