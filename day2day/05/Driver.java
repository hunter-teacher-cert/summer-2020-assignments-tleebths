import java.io.*;

import java.util.*;

public class Driver{
    public static void main(String[] args) {

        LList l = new LList();
        //System.out.println("should be true, isEmpty(): " + l.isEmpty());

        l.add("Coitenly");
        //System.out.println(l);
        l.add("Curly");
        // System.out.println(l);
        l.add("Larry");
        // System.out.println(l);

        l.add("Harpo");
        l.add("Groucho");
        l.add("Chico");
        l.add("Zeppo");
        l.add("Gummo");
        System.out.println(l);

        
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
