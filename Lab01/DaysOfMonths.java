import java.util.Scanner;
public class DaysOfMonths{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter year: ");
        int year = sc.nextInt();
        while (year <= 0){
            System.out.println("Invalid");
            System.out.println("Enter year again");
            year = sc.nextInt();
        }
        System.out.println("Enter month");
        int month = getMonth(sc);
        while (month < 1 || month > 12){
            System.out.println("Invalid");
            System.out.println("Enter month again");
            month = getMonth(sc);
        }
        System.out.println(getDay(month, year));
    }   
    public static int StrToInt(String strm) {
        switch (strm) {
            case "January":
            case "Jan.":
            case "Jan":
                return 1;
            case "February":
            case "Feb.":
            case "Feb":
                return 2;
            case "March":
            case "Mar.":
            case "Mar":
                return 3;
            case "April":
            case "Apr.":
            case "Apr":
                return 4;
            case "May":
                return 5;
            case "June":
            case "Jun":
                return 6;
            case "July":
            case "Jul":
                return 7;
            case "August":
            case "Aug.":
            case "Aug":
                return 8;
            case "September":
            case "Sep.":
            case "Sep":
                return 9;
            case "October":
            case "Oct.":
            case "Oct":
                return 10;
            case "November":
            case "Nov.":
            case "Nov":
                return 11;
            case "December":
            case "Dec.":
            case "Dec":
                return 12;
            default:
                return -1;
        }
    }
    public static int getMonth(Scanner sc){ 
        int month;
        if (sc.hasNextInt()){
            month = sc.nextInt();
        }else{
            String strm = sc.nextLine();
            month = StrToInt(strm);
        }
        return month;
    }
    public static boolean Leapyear(int year){
        if (year % 4 == 0){
            if (year % 100 ==0 && year % 400 != 0){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    public static int getDay(int month, int year){
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (Leapyear(year)){
                    return 29;
                }else{
                    return 28;
                }
            default:
                return -1;
        }
    }
}

