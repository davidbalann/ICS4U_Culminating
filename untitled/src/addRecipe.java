import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class addRecipe extends JFrame{
    private JTextField nameField;
    private JButton addRecipeButton;
    private JComboBox typeComboBox;
    private JButton backButton;
    private JPanel addNewPage;
    private JTextField durationField;
    private JTextField nrIngrediantsField;

    public addRecipe() {

        setContentPane(addNewPage);
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
    addRecipeButton.addActionListener(new ActionListener() {
        //Add Savind Recipe Here
        //testField.getText()
        @Override
        public void actionPerformed(ActionEvent e) {

            String name    = nameField.getText();
            String type    = typeComboBox.getSelectedItem().toString();
            int duration   = Integer.parseInt(durationField.getText());
            String[] nrIng = nrIngrediantsField.getText().split(",");

            Main.recipeList.add( new Recipe(name,type,duration,nrIng));
           for(int i = 0; i < Main.recipeList.size();++i) {
               System.out.print(Main.recipeList.get(i).formattedToString());
               Serialization serializer = new Serialization();

// Serializing the object to the file
               try {
                   serializer.serialize(Main.recipeList.get(i));
               } catch (IOException ex) {
                   throw new RuntimeException(ex);
               }


           }


            okAdded p1 = new okAdded();
            p1.show();
            dispose();
        }
    });
}
}
