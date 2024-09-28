import java.util.Arrays;
import java.util.Scanner;
public class AddMatrices{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rows ");
        int r = sc.nextInt();
        System.out.println("Enter the columns ");
        int c = sc.nextInt();
        double[][] M1 = new double[r][c];
        double[][] M2 = new double[r][c];
        double[][] res = new double[r][c];
        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                M1[i][j] = sc.nextDouble();
            }
        }
        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                M2[i][j] = sc.nextDouble();
                res[i][j] = M1[i][j] + M2[i][j];
            }
        }
        for (int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }
}