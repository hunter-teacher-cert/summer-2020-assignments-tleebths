atimport java.io.*;

import java.util.*;

public class Driver{
    public static void main(String[] args) {
	Node n1;
	Node n2;

	n1 = new Node("Tim");
	n2 = new Node("Arthur");
	n1.setNext(n2);
	System.out.println(n1);
	System.out.println(n2);
	System.out.println(n1.getNext());

	n1.getNext().setData("Robin");
	System.out.println(n1);
	System.out.println(n2);

	Node n3 = new Node("Merlin",n2);
	n1.setNext(n3);
	System.out.println(n1);
	System.out.println(n1.getNext());
	System.out.println(n1.getNext().getNext());




    }
}
