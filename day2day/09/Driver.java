import java.io.*;
import java.util.*;

class Driver{
    public static void main(String[] args) {
	MyStack s = new MyStack();

	s.push("A");
	s.push("B");
	s.push("C");
	

	String x = s.pop();
	System.out.println(x);
	x = s.pop();
	System.out.println(x);
	x = s.pop();
	System.out.println(x);
    }
}
