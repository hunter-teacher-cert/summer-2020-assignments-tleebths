import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        System.out.println(Words.reverse("ZtofrdDub"));
        System.out.println(Words.reverse("ABBA"));

        System.out.println("T: " + StackApps.isPalindrome("racecar"));
        System.out.println("T: " + StackApps.isPalindrome("able was i ere i saw elba"));
        System.out.println("F: " + StackApps.isPalindrome("rumor"));
        System.out.println("F: " + StackApps.isPalindrome("ABCcBA"));

        System.out.println("T: " + StackApps.parenCheck("()(((3)*6))"));
        System.out.println("T: " + StackApps.parenCheck("(3*6)"));
        System.out.println("F: " + StackApps.parenCheck("((rumor)"));
        System.out.println("F: " + StackApps.parenCheck("((rumor)))"));
        System.out.println("T: " + StackApps.parenCheck("((){[[]()]}((3)*[6]))"));
        System.out.println("T: " + StackApps.parenCheck("(3*{6}[[{}]])"));
        System.out.println("F: " + StackApps.parenCheck("({[(])}(rumor)"));
        System.out.println("F: " + StackApps.parenCheck("((rumor)){{})"));

        // Stack<String> ws = new Stack<String>();
        // ws.push("To"); ws.push("be"); ws.push("or"); ws.push("not"); ws.push("to"); ws.push("be");
        // System.out.println(ws);

        System.out.println(StackApps.revByWord("To be or not to be"));
        System.out.println(StackApps.revByWord("That is the question"));
        System.out.println("F: " + StackApps.isPalindromeByWord("make it so"));
        System.out.println("T: " + StackApps.isPalindromeByWord("I am what am I"));
        System.out.println("T: " + StackApps.isPalindromeByWord("bye bye"));

    }  // end main()

}  // end class
