import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// Suppress warning for text block migration and use of anonymous class instead of lambda
@SuppressWarnings({"TextBlockMigration", "Convert2Lambda"})
public class homePage extends JFrame {
    private JPanel MainPage;
    private JPanel mainPanel;
    private JLabel Title;
    private JButton quitButton;
    private JButton viewButton;
    private JButton shopButton;
    private JButton manageButton;
    private JButton helpButton;

    public homePage() {
        // Set main panel as content pane of the frame
        setContentPane(mainPanel);
        // Set title of the frame
        setTitle("Recipe Manager");
        // Set size of the frame
        setSize(400, 600);
        // Add window listener to serialize recipe list and close the program when window is closed
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
                System.exit(0);
            }
        });
        // Try to set look and feel for the frame to cross platform
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            // Throw runtime exception if there's any error
            throw new RuntimeException(e);
        }
        // Set the frame to be visible
        setVisible(true);
        // Add action listener to quit button
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quit();
            }
        });
        // Add action listener to view button
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view();
            }
        });
        // Add action listener to shop button
        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shop();
            }
        });
        // Add action listener to manage button
        manageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manage();
            }
        });
        // Add key listener to view button to trigger view() method when enter key is pressed
        viewButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    view();
                }
            }
        });
        // add key listeners to buttons
        shopButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    shop();
                }
            }
        });
        // Listen for KeyPress events on manageButton
        manageButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                // Check if the pressed key is "Enter"
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Call manage() method if "Enter" is pressed
                    manage();
                }
            }
        });

// Listen for KeyPress events on quitButton
        quitButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                // Check if the pressed key is "Enter"
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Call quit() method if "Enter" is pressed
                    quit();
                }
            }
        });

// Listen for Action events on helpButton
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call help() method when helpButton is clicked
                help();
            }
        });

// Listen for KeyPress events on helpButton
        helpButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                // Check if the pressed key is "Enter"
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Call help() method if "Enter" is pressed
                    help();
                }
            }
        });
    }


    // Code to display the view page
    void view(){
        // Creating an instance of the viewPage class
        viewPage p1 = new viewPage();
        // Showing the viewPage class
        // Suppressing the warning for deprecation of the show() method
        p1.show();
        // Disposing the current page
        dispose();
    }

    // Code to display the shop page
    void shop(){
        // Creating an instance of the shopPage class
        shopPage p1 = new shopPage();
        // Showing the shopPage class
        // Suppressing the warning for deprecation of the show() method
        p1.show();
        // Disposing the current page
        dispose();
    }

    // Code to display the manage (edit recipe) page
    void manage(){
        // Creating an instance of the editRecipe class
        editRecipe p1 = new editRecipe();
        // Showing the editRecipe class
        // Suppressing the warning for deprecation of the show() method
        p1.show();
        // Disposing the current page
        dispose();
    }

    // Code to display the help page
    void help(){
        // Creating a JTextArea to display the help instructions
        JTextArea helpText = new JTextArea();
        // Setting the JTextArea to not be editable
        helpText.setEditable(false);
        // Setting the text for the JTextArea
        helpText.setText("Instructions:\n" +
                "Use the mouse click the buttons\n" +
                "Can use keyboard, Tab And Enter To Move and Select\n" +
                "Insert Data Using Keyboard" );
        // Creating a JOptionPane to display the JTextArea
        JOptionPane pane = new JOptionPane(helpText, JOptionPane.PLAIN_MESSAGE);
        // Setting the background color of the JOptionPane
        pane.setBackground(new Color(0xED, 0xED, 0xE9));

        // Creating a JDialog to display the JOptionPane
        JDialog dialog = pane.createDialog("Help");

        // Getting the default button for the JDialog
        JButton button = dialog.getRootPane().getDefaultButton();
        // Setting the background color of the default button
        button.setBackground(new Color(0xD5, 0xBD, 0xAF));

        // Setting the background color of the JTextArea
        helpText.setBackground(new Color(0xB6, 0xA3, 0x91));

        // Making the JDialog visible
        dialog.setVisible(true);
    }

    // Code to quit the program and serialize the recipe list
    void quit(){
        // Serializing the recipe list using the RecipeSerializer class
        RecipeSerializer.serialize(Main.recipeList, "recipe.ser");
        // Exiting the program with a status code of 0 (successful)
        System.exit(0);
    }


}
