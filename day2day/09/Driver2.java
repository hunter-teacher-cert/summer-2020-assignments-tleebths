import java.io.*;
import java.util.*;

public class Driver2 {
    public static void main(String[] args) {
        System.out.println(Words.reverse("ZtofrdDub"));
        System.out.println(Words.reverse("ABBA"));

        System.out.println("T: " + StackApps2.isPalindrome("racecar"));
        System.out.println("T: " + StackApps2.isPalindrome("able was i ere i saw elba"));
        System.out.println("F: " + StackApps2.isPalindrome("rumor"));
        System.out.println("F: " + StackApps2.isPalindrome("ABCcBA"));

        System.out.println("T: " + StackApps2.parenCheck("()(((3)*6))"));
        System.out.println("T: " + StackApps2.parenCheck("(3*6)"));
        System.out.println("F: " + StackApps2.parenCheck("((rumor)"));
        System.out.println("F: " + StackApps2.parenCheck("((rumor)))"));
        System.out.println("T: " + StackApps2.parenCheck("((){[[]()]}((3)*[6]))"));
        System.out.println("T: " + StackApps2.parenCheck("(3*{6}[[{}]])"));
        System.out.println("F: " + StackApps2.parenCheck("({[(])}(rumor)"));
        System.out.println("F: " + StackApps2.parenCheck("((rumor)){{})"));

        // Stack<String> ws = new Stack<String>();
        // ws.push("To"); ws.push("be"); ws.push("or"); ws.push("not"); ws.push("to"); ws.push("be");
        // System.out.println(ws);

        System.out.println(StackApps2.revByWord("To be or not to be"));
        System.out.println(StackApps2.revByWord("That is the question"));
        System.out.println("F: " + StackApps2.isPalindromeByWord("make it so"));
        System.out.println("T: " + StackApps2.isPalindromeByWord("I am what am I"));
        System.out.println("T: " + StackApps2.isPalindromeByWord("bye bye"));

    }  // end main()

}  // end class
