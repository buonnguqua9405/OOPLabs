import java.util.Arrays;
import java.util.Scanner;
public class SortArray{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        double[] arr = new double[n];
        double sum = 0;
        for (int i=0; i<n; i++){
            arr[i] = sc.nextDouble();
            sum += arr[i];
        }
        Arrays.sort(arr);
        double avg = sum / n;
        for (int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println(sum);
        System.out.println(avg);
    }
}