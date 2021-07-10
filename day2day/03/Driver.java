import java.io.*;
import java.util.*;

// some testing problems from changing time values. Results in debugging with no bugs.
// Methods work correctly but thought they're wrong.
public class Driver {
    public static void main(String[] args) {
        // challenge problems
        Time t1 = new Time(23, 59, 59);
        Time t2 = new Time(0, 1+60*2, 0);
        Time t3 = new Time(23, 14, 59.9);

        t1.addMinutes(t2.getMinute());
        System.out.println("Should be 02:00:59: " + t1);

        t1 = new Time(22, 30, 59);
        t2 = new Time(2, 59, 0.6);
        t3 = new Time(23, 14, 14);
        System.out.println(t1.compareTo(t2));  // +
        System.out.println(t1.compareTo(t1));  // 0
        System.out.println(t2.compareTo(t1));  // -
        System.out.println(t3.compareTo(t1));  // +
        System.out.println(t1.difference(t2));
        System.out.println(t3.difference(t1));

        t1 = new Time(13, 30, 59);
        t2 = new Time(12, 59, 0.6);
        t3 = new Time(11, 14, 41);
        Time t4 = new Time(0, 21, 7);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);


/* tested positive
        Time t1 = new Time();
        t1.setMinute(25);  // 0:25:00
        Time t2 = new Time(1, 2, 3.4);
        t2.setSeond(69);  // 1:02:69
        Time t3 = new Time(0, 25, 0);
        Time t4 = t1;  // 1:28:09
        Time t5 = Time.addTime(t1, t2);

        System.out.printf("t1: %s\n", t1.toString());
        System.out.print("t2: ");
        t2.printTime();
        System.out.printf("t5=t1+t2= %s\n", t5.toString());
        System.out.printf("t1==t4 should be true: %s%n", t1==t4);
        System.out.printf("t3==t4 should be false: %s%n", t3==t4);
        System.out.printf("t3.equals(t4) should be true: %s%n", t3.equals(t4));
        System.out.printf("t3.equals(t2) should be false: %s%n", t3.equals(t2));

        t1 = new Time(23, 59, 59);
        t2 = new Time(72+1, 1, 60+4);
        System.out.println("Should be 01:02:03: " + Time.addTime(t1, t2));
        System.out.println("Should be 01:02:03: " + t1.add(t2));
        t1.increment(2+60*60*24);
        System.out.println("Should be 00:00:01: " + t1);

        AClass aClassObject = new AClass();
        System.out.println(aClassObject);
        System.out.println(aClassObject.toString());
*/
    }  // end main
}  // end class
