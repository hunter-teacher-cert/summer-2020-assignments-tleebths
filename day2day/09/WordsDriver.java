import java.io.*;
import java.util.*;

public class WordsDriver {
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

        // Stack<String> ws = new Stack<String>();
        // ws.push("To"); ws.push("be"); ws.push("or"); ws.push("not"); ws.push("to"); ws.push("be");
        // System.out.println(ws);

        System.out.println(Words.revByWord("To be or not to be"));
        System.out.println(Words.revByWord("That is the question"));
        System.out.println("F: " + Words.isPalindromeByWord("make it so"));
        System.out.println("T: " + Words.isPalindromeByWord("I am what am I"));
        System.out.println("T: " + Words.isPalindromeByWord("bye bye"));

    }  // end main()

}  // end class
