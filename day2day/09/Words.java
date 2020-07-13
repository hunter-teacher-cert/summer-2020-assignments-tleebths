import java.util.*;
import java.io.*;

public class Words {

	// Returns s in reverse order by word
	public static String revByWord(String s) {
		Stack<Character> cs = new Stack<Character>();
		int i;

		for(i=0; i<s.length(); i++) {
			cs.push(s.charAt(i));
		}

		String rev = "";
		for(i=0; i<s.length(); i++) {
			rev += cs.pop();
		}

		return rev;
	}

	public static String readNextWord(String s, int index) {
		String word = "";
		char c;

		while (index < s.length()) {
			char c = s.charAt(index);
			if (c)
		}
	}

	// Returns s in reverse order
	public static String reverse(String s) {
		Stack<Character> cs = new Stack<Character>();
		int i;

		for(i=0; i<s.length(); i++) {
			cs.push(s.charAt(i));
		}

		String rev = "";
		for(i=0; i<s.length(); i++) {
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
			cs.push(s.charAt(i));
		}

		int counter = 0;
		for(int i=0; i<len; i++) {
			char c = cs.pop();
			if (c == ')') {
				counter++;
			} else if (c == '(') {
				counter--;
			}

			if (counter < 0) {
				return false;
			}
		}

		return counter==0;
	}


	public static void main(String[] args) {


	}  // end main()

}
