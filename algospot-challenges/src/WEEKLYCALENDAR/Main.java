package WEEKLYCALENDAR;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jhbang on 2015. 8. 26..
 */
public class Main {

    public static int getMonthEndDay(int month){
        int result = 0;
        switch (month){
            case 1:case 3:case 5:case 7:case 8:case 10:case 12:
                 result= 31;
                break;
            case 2:
                result= 28;
                break;
            case 4:case 6:case 9:case 11:
                result= 30;
                break;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();
        ArrayList<String> weekList = new ArrayList<String>();
        weekList.add("Sunday");
        weekList.add("Monday");
        weekList.add("Tuesday");
        weekList.add("Wednesday");
        weekList.add("Thursday");
        weekList.add("Friday");
        weekList.add("Saturday");

        while (cases-->0) {
            int month = sc.nextInt();
            int day = sc.nextInt();
            String week = sc.next();

            int monthEndDay = getMonthEndDay(month);
            int weekFirstDay = day-weekList.indexOf(week);



            if(weekFirstDay>0){
                int monthStart = 1;
                for (int i = 0; i <7; i++) {
                    if(weekFirstDay + i<=monthEndDay){
                        System.out.print(weekFirstDay + i + " ");
                    }
                    else{
                        System.out.print(monthStart++ + " ");
                    }
                }
                System.out.println();
            }else{
                monthEndDay = getMonthEndDay(month>1?month-1:12);
                weekFirstDay = monthEndDay + weekFirstDay;
                int monthStart = 1;
                for (int i = 0; i <7; i++) {
                    if(weekFirstDay + i<=monthEndDay){
                        System.out.print(weekFirstDay + i + " ");
                    }
                    else{
                        System.out.print(monthStart++ + " ");
                    }
                }
                System.out.println();
            }

        }
    }

}
