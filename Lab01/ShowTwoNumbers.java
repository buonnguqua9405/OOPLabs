import javax.swing.JOptionPane;
public class ShowTwoNumbers {
    public static void main(String[] args){
        String strNum1, strNum2;
        String srNotification ="You ve just entered";
         strNum1 = JOptionPane.showInputDialog(null, 
         "please input the first number: ","input the first number", JOptionPane.INFORMATION_MESSAGE);
         srNotification += strNum1 + " and ";
         strNum2 = JOptionPane.showInputDialog(null, 
         "please input the second number: ","input the second number", JOptionPane.INFORMATION_MESSAGE);
         srNotification += strNum2;
         JOptionPane.showMessageDialog(null, srNotification, " show two numbers ", JOptionPane.INFORMATION_MESSAGE);
         System.exit(0);
    }   
}