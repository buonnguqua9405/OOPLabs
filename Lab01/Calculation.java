import javax.swing.JOptionPane;
public class Calculation{
    public static void main(String[] args){
        String strNum1,strNum2;
        //nhap so thu 1
        strNum1 = JOptionPane.showInputDialog(null, 
         "please input the first number: ","input the first number", JOptionPane.INFORMATION_MESSAGE);
         //nhap so thu 2
         strNum2 = JOptionPane.showInputDialog(null, 
         "please input the second number: ","input the second number", JOptionPane.INFORMATION_MESSAGE);
         //Chon phep toan
        String[] options = {"Addition","Subtraction","Multiplication","Division"};
        int choice = JOptionPane.showOptionDialog(
            null, "Your choice is", "Choosing Operations", 0, 0, null, options,options[0]);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        if (choice == 0){
            JOptionPane.showMessageDialog(null, num1 + num2, "Answer", JOptionPane.INFORMATION_MESSAGE);
        } else if (choice == 1){
            JOptionPane.showMessageDialog(null, num1 - num2, "Answer", JOptionPane.INFORMATION_MESSAGE);
        }else if (choice == 2){
            JOptionPane.showMessageDialog(null, num1 * num2, "Answer", JOptionPane.INFORMATION_MESSAGE);
        }else{
            if ( num2 != 0){
                JOptionPane.showMessageDialog(null, num1 / num2, "Answer", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "invalid", "Answer", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        System.exit(0);
    }

}