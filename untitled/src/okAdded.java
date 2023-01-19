import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class okAdded extends JFrame{

    private JPanel okAddedPane;
    private JButton okButton;
    public okAdded(){
        setContentPane(okAddedPane);
        setTitle("View Recipes");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage p1 = new homePage();
                p1.show();
                dispose();
            }
        });
    }

}
