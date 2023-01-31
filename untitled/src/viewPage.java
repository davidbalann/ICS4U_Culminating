// Import the necessary libraries for GUI and event handling
import javax.swing.*;
import java.awt.event.*;

// Suppress rawtype and convert2lambda warnings
@SuppressWarnings({"rawtypes", "Convert2Lambda"})

// Define the viewPage class, extending JFrame
public class viewPage extends JFrame {
    // Declare the components for the viewPage
    private JButton homeButton;
    private JPanel viewPage;
    private JTextArea viewArea;
    private JComboBox comboBox1;
    private JButton displayButton;
    private JScrollPane scroll;

    // Constructor for the viewPage class
    public viewPage() {
        // Set the text in the viewArea as an empty string
        viewArea.setText("");

        // Set the content pane as the viewPage panel
        setContentPane(viewPage);

        // Set the title of the frame as "View Recipes"
        setTitle("View Recipes");

        // Set the size of the frame to 600x700
        setSize(600, 700);

        // Add a window listener to serialize the recipe list on exit and close the program
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });

        // Set the bounds of the scroll pane and add the viewArea to the viewport
        scroll.setBounds(100,100, 50,100);
        scroll.setViewportView(viewArea);

        // Set line wrap and word wrap for the viewArea
        viewArea.setLineWrap(true);
        viewArea.setWrapStyleWord(true);

        // Add the viewArea to the viewport of the scroll pane
        scroll.setViewportView(viewArea);

        // Make the frame visible
        setVisible(true);

        // Append the formatted recipe strings to the viewArea
        for (int i = 0; i < Main.recipeList.size(); ++i)
            viewArea.append(Main.recipeList.get(i).formattedToString());

        // Add an action listener to the homeButton to call the home method on click
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home();

            }
        });

        // Add an action listener to the displayButton to call the display method on click
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display();
            }
        });

        // Add a key listener to the displayButton to call the display method on Enter key press
        displayButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    display();
                }
            }
        });
        //Adds a key listener to the home button to go back to the home page when enter is pressed
        homeButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    home();
                }
            }
        });
    }

    // This method creates a new instance of homePage and displays it on the screen
    void home(){
        // Suppressing the warning for using a deprecated method
        @SuppressWarnings("deprecation")
        homePage p1 = new homePage();
        // Displaying the homePage
        p1.show();
        // Disposing the current window
        dispose();
    }
    // This method displays the recipe list
    void display(){
        // Suppressing the warning for possible data flow issue
        @SuppressWarnings("DataFlowIssue")
        int[] order = RecipeManager.sortRecipe(comboBox1.getSelectedItem().toString());

        // Clearing the text area
        viewArea.setText("");
        // Looping through the recipe list and displaying each recipe in the text area
        for (int i = 0; i < Main.recipeList.size(); ++i)
            viewArea.append(Main.recipeList.get(order[i]).formattedToString());
    }


}
