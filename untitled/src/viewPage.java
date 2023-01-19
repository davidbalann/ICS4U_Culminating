import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class viewPage extends JFrame {
    private JButton homeButton;
    private JPanel viewPage;
    private JTextArea viewArea;
    private JComboBox comboBox1;
    private JButton displayButton;

    public viewPage(){
        viewArea.setText("");
        setContentPane(viewPage);
        setTitle("View Recipes");
        setSize(600,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        for(int i = 0; i < Main.recipeList.size();++i)
            viewArea.append(Main.recipeList.get(i).formattedToString());

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homePage p1 = new homePage();
                p1.show();
                dispose();

            }
        });
    }
}
