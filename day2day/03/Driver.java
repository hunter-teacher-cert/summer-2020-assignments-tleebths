import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
        Time t1 = new Time();
        t1.setMinute(25);
        Time t2 = new Time(1, 2, 3.4);
        t2.setSeond(69);
        Time t3 = new Time(0, 25, 0);
        Time t4 = t1;
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

    }
}
