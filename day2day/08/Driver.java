import java.io.*;
import java.util.*;

// tester
public class Driver {
    public static void main(String[] args) {

        MyStack s = new MyStack();
        System.out.println("Printing empty stack:\n" + s);
        System.out.printf("isEmpty() should be true: %b. Top=\n", s, s.isEmpty(), s.top());

        s.push("Z");
        s.push("tofr");
        s.push("dDub");
        //s.push("Dominion of Canada");
        System.out.println("Printing stack ZtdD:\n" + s);
        System.out.printf("size %d: Top=%s\n", s.size(), s.top());

        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());

    }  // end main()

}  // end class
