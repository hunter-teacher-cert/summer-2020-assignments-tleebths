import java.util.*;
import java.io.*;

public class StackApps {

	// Returns s in reverse order by word
	// Assume s is trimmed of spaces, and only one space b/t words
	public static String revByWord(String s) {
		// Cut sentence into stack of Strings
		Stack<String> ws = str2words(s);

		String rev = ws.pop();
		while (!ws.empty()) {
			rev += " " + ws.pop();
		}

		return rev;
	}  // end revByWord()

	public static boolean isPalindromeByWord(String s) {
		// Convert String to Stack of words, s1
		// Reverse s by word, then convert to Stack of words, s2
		// Pop both and see if anything's different
		Stack<String> ss1 = str2words(s);
		Stack<String> ss2 = str2words(revByWord(s));

		while (!ss1.empty()) {
			if (!ss1.pop().equals( ss2.pop() ))
				return false;
		}

		return true;
	}  // end isPalindromeByWord()


	// Returns s in reverse order
	public static String reverse(String s) {
		return letters2str(str2letters(s));  // push into stack, pop back out
	}

	// Returns true or false depneding on whether s is a palindrome
	// (can be read the same forward & backward)
	public static boolean isPalindrome(String s) {
		return s.equals(reverse(s));
	}

	// Returns whether two letters are opposite brackets
	public static boolean opps(char s1, char s2) {
		return (s1=='(' && s2==')')
			|| (s1=='[' && s2==']')
			|| (s1=='{' && s2=='}');
	}

	// Returns whether c is an opening bracket
	public static boolean isOpening(char c) {
		return c=='(' || c=='[' || c=='{';
	}

	// Returns whether c is a closing bracket
	public static boolean isClosing(char c) {
		return c==')' || c==']' || c=='}';
	}

    /* Assume s is a string representing a mathematical expression.
     * Expression limited to alphanumeric and the following: ()+-/*
     * Returns true if the parentheses in the expression are matched accurately.
     * This should just ignore any other potential syntax issues.
	 * My assumptions: s is not null.
	 * Brackets are not hierarchical.
	 */
	public static boolean parenCheck(String s) {
		// Strategy: Scan each char c in s.
		// If c is an opening bracket, push it into the Stack.
		// If c is a closing bracket, pop from stack and check if they match.
		// Watch for empty stack exception--tries to close w/o opening.
		// At the end, stack should be empty.

		Stack<Character> bs = new Stack<Character>();  // b for brackets
		char c, c0;

		for(int i=0; i < s.length(); i++) {
			c = s.charAt(i);

			if (isOpening(c)) {
				bs.push(c);
			} else if (isClosing(c)) {
				try {
					c0 = bs.pop();
				} catch(EmptyStackException e) {
					return false;
				}

				if (!opps(c0, c)) {
					return false;
				}
			}  // end nested if

		}  // end for loop

		return bs.empty();
	}  // end parenCheck()

	// Returns a String from a given Stack of letters
	private static String letters2str(Stack<String> ls) {
		String s = "";
		while (!ls.empty()) {
			s += ls.pop();
		}

		return s;
	}

	// Returns a stack of letters as Strings, given a sentence s
	// assumes s is not null
	private static Stack<String> str2letters(String s) {
		Stack<String> ls = new Stack<String>();  // letters stack
		String str = "";  // to cast char to String by concatenating

		for (int i=0; i < s.length(); i++) {
			ls.push( str + s.charAt(i) );
		}

		return ls;
	}

	// Returns a stack of words as Strings, given a sentence s
	// assumes s is not null
	private static Stack<String> str2words(String s) {
		Stack<String> ws = new Stack<String>();  // words, to form sentence
		String word = "";

		// Process each letter of String into a word.
		// At each space, push word onto stack. Reset word.
		for (int i=0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c != ' ') {  // end of a word
				word += c;
			} else {
				ws.push(word);
				word = "";
			}
		}

		ws.push(word);  // last word doesn't end with a space
		return ws;
	}  // end str2stk()

}  // end class
