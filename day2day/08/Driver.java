import java.io.*;

import java.util.*;

public class Driver{
    public static void main(String[] args) {

        MyStack s = new MyStack();
        System.out.println("Printing stack:\n" + s);
        System.out.printf("isEmpty() should be true: %b. Top=\n", s, s.isEmpty(), s.top());

        s.push("Z");
        s.push("tofr");
        s.push("dDub");
        System.out.printf("Ztd, size %d: Top=%s\n", s.size(), s.top());
        System.out.println("Printing stack:\n" + s);

        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());
        System.out.println("pop: " + s.pop());


        /** testing get()
        System.out.printf("Should be Gummo: %s\n", l.get(0));
        System.out.printf("Should be Chico: %s\n", l.get(2));
        System.out.printf("Should be null: %s\n", l.get(100));
        */

        // Node n1;
        // Node n2;

        // n1 = new Node("Tim");
        // n2 = new Node("Arthur");
        // n1.setNext(n2);
        // System.out.println(n1);
        // System.out.println(n2);
        // System.out.println(n1.getNext());

        // n1.getNext().setData("Robin");
        // System.out.println(n1);
        // System.out.println(n2);

        // Node n3 = new Node("Merlin",n2);
        // n1.setNext(n3);
        // System.out.println(n1);
        // System.out.println(n1.getNext());
        // System.out.println(n1.getNext().getNext());




    }
}
