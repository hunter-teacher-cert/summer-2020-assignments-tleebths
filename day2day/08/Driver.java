import java.io.*;
import java.util.*;

// tester
public class Driver {
    public static void main(String[] args) {

        MyStack s = new MyStack();
        System.out.println("Printing empty stack:\n\n" + s);
        System.out.printf("isEmpty() should be true: %b. Top=\n", s, s.isEmpty(), s.top());

        s.push("Dominion of Canada");
        s.push("Z");
        s.push("tofr");
        s.push("dDub");
        System.out.println("Printing stack Ztd(D):\n\n" + s);
        System.out.printf("size %d: Top=%s\n", s.size(), s.top());

        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());

    }  // end main()

}  // end class
