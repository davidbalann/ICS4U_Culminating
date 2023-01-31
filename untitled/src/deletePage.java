import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("Convert2Lambda")
public class deletePage extends JFrame {
    private JTextArea viewArea;  // text area to display all the recipes
    private JButton deleteButton; // button to delete the recipe
    private JTextField deletedValue; // text field to input the name of the recipe to be deleted
    private JButton backButton; // button to go back to the previous page
    private JPanel deleteRecipePage;
    private JScrollPane scroll;  // scroll bar for the text area
    private JLabel errorLable;  // label to display error message

    deletePage() {
        setContentPane(deleteRecipePage);  // sets the main panel
        setTitle("Delete Recipe");  // sets the title of the page
        setSize(600, 600);  // sets the size of the page

        // Adds a window listener to serialize the data and exit the application when the window is closed
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });

        // sets the bounds and view of the scroll bar
        scroll.setBounds(100,100, 50,100);
        scroll.setViewportView(viewArea);
        viewArea.setLineWrap(true);
        viewArea.setWrapStyleWord(true);
        scroll.setViewportView(viewArea);
        setVisible(true);

        // displays all the recipes in the text area
        for (int i = 0; i < Main.recipeList.size(); ++i)
            viewArea.append(Main.recipeList.get(i).formattedToString());

        // Adds action listener to the back button to go back to the previous page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });

        // Adds action listener to the delete button to delete the recipe
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleted();
            }
        });

        // Adds a key listener to the delete value text field to delete the recipe when enter is pressed
        deletedValue.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    deleted();
                }
            }
        });
        // Add key listener to the back button to trigger back() method when the enter key is pressed
        backButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    back();
                }
            }
        });

        // Add key listener to the delete button to trigger deleted() method when the enter key is pressed
        deleteButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    deleted();
                }
            }
        });
    }

    // Method to navigate to the previous screen when the back button is pressed
    private void back() {
        editRecipe editRecipe = new editRecipe();
        editRecipe.setVisible(true);
        this.dispose();
    }

    // Method to delete the recipe with the specified name when the delete button is pressed
    private void deleted() {
        if (deletedValue.getText().trim().isEmpty()) {
            errorLable.setText("Please Enter A Recipe To Delete");
        } else {
            String name = deletedValue.getText();
            int j = 0;
            // Check if the recipe exists
            for (int i = 0; i < Main.recipeList.size(); i++) {
                if (Main.recipeList.get(i).getName().equalsIgnoreCase(name)) {
                    ++j;
                    break;
                }
            }

            if (j == 0) {
                errorLable.setText("Recipe Not Found");
            } else {
                // Remove the recipe from the list
                for (int i = 0; i < Main.recipeList.size(); i++) {
                    if (Main.recipeList.get(i).getName().equalsIgnoreCase(name)) {
                        Main.recipeList.remove(i);
                        break;
                    }
                }
                okDeleted okDeleted = new okDeleted();
                okDeleted.setVisible(true);
                this.dispose();
            }
        }
    }
}
