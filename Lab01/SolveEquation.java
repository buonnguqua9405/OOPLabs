import java.util.Scanner;
public class SolveEquation {
    public static void main(String[] args){
        Scanner TypeOfEquation = new Scanner(System.in);
        System.out.println("Typpe of equations");
        System.out.println("Linear equation");
        System.out.println("Linear system");
        System.out.println(("Second-degree equation"));
        String choice = TypeOfEquation.nextLine();
        System.out.println(choice);
        if (choice .equals("Linear equation")){
            LinearEquation();
        }else if (choice .equals("Linear system")){
            LinearSystem();
        }else if (choice .equals("Second-degree equation")){
            SecondDeg();
        }else{
            System.out.println("invalid");
        }
        System.exit(0);
    }
    public static void LinearEquation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coefficient a: ");
        double a = sc.nextDouble();
        System.out.println("Enter coefficient b: ");
        double b = sc.nextDouble();
        if (a == 0){
            System.out.println("a can not be zero");
        }else{
            System.out.println(-b/a);
        }
    }
    public static void LinearSystem(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coefficient a11: ");
        double a11 = sc.nextDouble();
        System.out.println("Enter coefficient a12: ");
        double a12 = sc.nextDouble();
        System.out.println("Enter coefficient b1");
        double b1 = sc.nextDouble();
        System.out.println("Enter coefficient a21: ");
        double a21 = sc.nextDouble();
        System.out.println("Enter coefficient a22: ");
        double a22 = sc.nextDouble();
        System.out.println("Enter coefficient b2: ");
        double b2 = sc.nextDouble();
        double D = a11*a22-a21*a12;
        double D1 = b1*a22-b2*a12;
        double D2 = a11*b2-a21*b1;
        if (D != 0){
            System.out.println(D1/D);
            System.out.println(D2/D);
        }else{
            if (D1 == 0 & D2 == 0){
                System.out.println("Infinite solutions");
            }else{
                System.out.println("No solution");
            }
        }
    }
    public static void SecondDeg(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coefficient a: ");
        double a = sc.nextDouble();
        System.out.println("Enter coefficient b: ");
        double b = sc.nextDouble();
        System.out.println("Enter coefficient c: ");
        double c = sc.nextDouble();
        double delta = b*b-4*a*c;
        if (a == 0){
            System.out.println("a can not be zero");
        }else{
            if (delta > 0){
                double x1 = (-b + Math.sqrt(delta))/(2*a);
                double x2 = (-b - Math.sqrt(delta))/(2*a);
                System.out.println(x1);
                System.out.println(x2);
            }else if (delta == 0){
                System.out.println(-b/(2*a));
            }else{
                System.out.println("Equation has no real roots");
            }
        }

    }

}
