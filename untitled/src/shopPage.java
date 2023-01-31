import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings({"rawtypes", "Convert2Lambda"})
public class shopPage extends JFrame {
    // Declare GUI components
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

    // Constructor for the class
    public shopPage() {
        // Set the content pane and title for the JFrame
        setContentPane(shopPage);
        setTitle("Shop Recipes");
        setSize(600, 600);

        // Add a window listener to serialize the recipe list when the window is closing
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });

        // Set bounds for the scroll pane and set its viewport view to the view area
        scroll.setBounds(100,100, 50,100);
        scroll.setViewportView(viewArea);
        viewArea.setLineWrap(true);
        viewArea.setWrapStyleWord(true);
        scroll.setViewportView(viewArea);

        // Set the JFrame to be visible
        setVisible(true);

        // Append all the recipes in the recipe list to the view area
        for (int i = 0; i < Main.recipeList.size(); ++i)
            viewArea.append(Main.recipeList.get(i).formattedToString());

        // Add action listeners for the back button, continue button and display button
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

        // Add key listeners for the recipe shop text field, display button, back button, and continue button
        recipeShop.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    continuePage();
                }
            }
        });
        /*

         displayButton KeyListener implementation
         This implementation listens to the enter key event, when it is pressed the display() method is called
         */
        displayButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    display();
                }
            }
        });
/*

 backButton KeyListener implementation
 This implementation listens to the enter key event, when it is pressed the back() method is called
 */
        backButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    back();
                }
            }
        });
/*

 continueButton KeyListener implementation
 This implementation listens to the enter key event, when it is pressed the continuePage() method is called
 */
        continueButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    continuePage();
                }
            }
        });
    }

    // method to handle the action when the continue button is clicked
    @SuppressWarnings("deprecation")
    void continuePage(){
        if(!(recipeShop.getText().trim().isEmpty())){
            int j = 0;
            for (int i = 0; i < Main.recipeList.size(); i++) {
                if (Main.recipeList.get(i).getName().equalsIgnoreCase(recipeShop.getText())) {
                    ingredientsPage p1 = new ingredientsPage(recipeShop.getText());
                    p1.show();
                    dispose();
                    ++j;
                    break;
                }
            }
            if(j == 0)
                secondLable.setText("Recipe Not Found");
        }
        else {
            secondLable.setText("Please Enter Proper Data");
        }
    }
    // method to display the sorted list of recipes
    void display(){
        @SuppressWarnings("DataFlowIssue") int[] order = RecipeManager.sortRecipe(comboBox1.getSelectedItem().toString());

        viewArea.setText("");
        for (int i = 0; i < Main.recipeList.size(); ++i)
            viewArea.append(Main.recipeList.get(order[i]).formattedToString());
    }
    // method to handle the action when the back button is clicked
    @SuppressWarnings("deprecation")
    void back(){
        homePage p1 = new homePage();
        p1.show();
        dispose();
    }
}


