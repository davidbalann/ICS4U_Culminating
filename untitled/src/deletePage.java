import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class deletePage extends JFrame{
    private JTextArea textArea1;
    private JButton deleteButton;
    private JFormattedTextField formattedTextField1;
    private JButton backButton;
    private JPanel deleteRecipePage;

    deletePage(){
        setContentPane(deleteRecipePage);
        setTitle("Delete Recipe");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editRecipe p1 = new editRecipe();
                p1.show();
                dispose();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                okDeleted p1 = new okDeleted();
                p1.show();
                dispose();
            }
        });
    }
}
