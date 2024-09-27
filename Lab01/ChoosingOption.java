import javax.swing.JOptionPane;
public class ChoosingOption{
    public static void main(String[] args){
        int option = JOptionPane.showConfirmDialog(null, " bt ong tu ko ");
        JOptionPane.showMessageDialog(
            null,"You've choosen: " + (option==JOptionPane.YES_OPTION?"Yes":"NO"));
        System.exit(0);
    }
}