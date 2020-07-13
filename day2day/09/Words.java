import java.util.*;
import java.io.*;

public class Words {

	// Returns s in reverse order by word
	// Assume s is trimmed of spaces, and only one space b/t words
	public static String revByWord(String s) {
		if (s==null)
			return null;

		// Cut sentence into stack of Strings
		Stack<String> ws = str2stk(s);

		String rev = ws.pop();
		while (!ws.empty()) {
			rev += " " + ws.pop();
		}

		return rev;
	}  // end revByWord()

	// Returns a stack of words as Strings, given a sentence s
	// assumes s is not null
	private static Stack<String> str2stk(String s) {
		Stack<String> ws = new Stack<String>();  // result
		String word = "";
		char c;

		// Process each letter of String into a word.
		// At each space, push word onto stack. Reset word.
		for (int index=0; index < s.length(); index++) {
			c = s.charAt(index);

			if (c == ' ') {  // end of a word
				ws.push(word);
				word = "";
			} else {
				word += c;
				// System.out.println(word);
			}
		}

		ws.push(word);  // last word doesn't end with a space
		return ws;
	}  // end str2stk()

	public static boolean isPalindromeByWord(String s) {
		// Convert String to Stack of words
		// Push first half of words into stack.
		// At halfway point, start popping.
		// Check if each char is the same as the rest of String
		Stack<String> ss1 = str2stk(s);

		int len = ss1.size();
		int half = len/2;  // will ignore middle if len is odd

		int i = 0;
		Stack<String> ss2 = new Stack<String>();

		while (i < half) {
			ss2.push(ss1.pop());
			i++;
		}

		// if len==4, half==2, 2nd half starts at 2
		// if len==7, half==3, 2nd half starts at 4
		if (len%2 == 1)
			ss1.pop();

		while (!ss1.empty()) {
			if (!ss1.pop().equals( ss2.pop() ))
				return false;
		}

		return true;
	}  // end isPalindromeByWord()


	// Returns s in reverse order
	public static String reverse(String s) {
		Stack<Character> cs = new Stack<Character>();
		int i;

		for(i=0; i<s.length(); i++) {
			cs.push(s.charAt(i));
		}

		String rev = "";
		while (!cs.empty()) {
			rev += cs.pop();
		}

		return rev;
	}

	// Returns true or false depneding on whether s is a palindrome
	// (can be read the same forward & backward)
	public static boolean isPalindrome(String s) {
		// Push first half of word into stack.
		// At halfway point, start popping.
		// Check if each char is the same as the rest of String
		Stack<Character> cs = new Stack<Character>();
		int len = s.length();
		int half = len/2;  // will ignore middle if len is odd

		int i = 0;
		while (i < half) {
			cs.push(s.charAt(i));
			i++;
		}

		// if len==4, half==2, 2nd half starts at 2
		// if len==7, half==3, 2nd half starts at 4
		if (len%2 == 1)
			i++;

		while (i < len) {
			if (s.charAt(i) != cs.pop())
				return false;

			i++;
		}

		return true;
	}  // end isPalindrome()

    // Assume s is a string representing a mathematical expression.
    // Expression limited to alphanumeric and the following: ()+-/*
    // Returns true if the parentheses in the expression are matched accurately.
    // This should just check valid parentheses matching, ignoring any other potential syntax issues.
	public static boolean parenCheck(String s) {
		// When popping, ) increments counter, ( decrements counter
		// return false if counter is ever negative or if
		// the stack is exhausted with counter > 0
		Stack<Character> cs = new Stack<Character>();
		int len = s.length();

		for(int i=0; i<len; i++) {
			char c = s.charAt(i);

			if (c == '(') {
				cs.push(c);
			} else if (c == ')') {
				try {
					cs.pop();
				} catch(EmptyStackException e) {
					return false;
				}
			}
		}  // end for loop

		return cs.empty();

	}  // end parenCheck()

}  // end class
