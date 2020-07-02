import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args) {
        Time t1 = new Time();
        Time t2 = new Time(1, 2, 3.4);
        Time t3 = new Time(0, 25, 0);
        Time t4 = t1;
        Time t5 = Time.addTime(t1, t2);

        t1.setMinute(25);
        t2.setSeond(69);

        System.out.printf("t1: %s\n", t1.toString());
        System.out.print("t2: ");
        t2.printTime();
        System.out.printf("t1==t4 should be true: %s%n", t1==t4);
        System.out.printf("t3==t4 should be false: %s%n", t3==t4);
        System.out.printf("t3.equals(t4) should be true: %s%n", t3.equals(t4));
        System.out.printf("t3.equals(t2) should be false: %s%n", t3.equals(t2));
        System.out.printf("t5=t1+t2= %s\n", t5.toString());

    }
}
