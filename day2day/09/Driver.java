import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        // System.out.println(Words.reverse("ZtofrdDub"));
        // System.out.println(Words.reverse("ABBA"));

        System.out.println("T: " + Words.isPalindrome("racecar"));
        System.out.println("T: " + Words.isPalindrome("able was i ere i saw elba"));
        System.out.println("F: " + Words.isPalindrome("rumor"));
        System.out.println("F: " + Words.isPalindrome("ABCcBA"));

        System.out.println("T: " + Words.parenCheck("()(((3)*6))"));
        System.out.println("T: " + Words.parenCheck("(3*6)"));
        System.out.println("F: " + Words.parenCheck("((rumor)"));
        System.out.println("F: " + Words.parenCheck("((rumor)))"));

	// MyStack s = new MyStack();
    //
	// s.push("A");
	// s.push("B");
	// s.push("C");
    //
    //
	// String x = s.pop();
	// System.out.println(x);
	// x = s.pop();
	// System.out.println(x);
	// x = s.pop();
	// System.out.println(x);
    }  // end main()

}  // end class
