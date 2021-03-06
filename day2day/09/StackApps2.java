import java.util.*;
import java.io.*;

public class StackApps2 {

	// Returns s in reverse order by word
	// Assume s is trimmed of spaces, and only one space b/t words
	public static String revByWord(String s) {
		return stk2str(str2words(s), " ");  // Cut sentence into stack of Strings
	}  // end revByWord()

	// Returns a stack of words as Strings, given a sentence s
	// Assumes s is trimmed of spaces & is not null
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

	// Returns a String from a given Stack of String
	// separated by the delimiter sep (usu. "" or " ").
	private static String stk2str(Stack<String> ls, String sep) {
		String s;

		if (ls.empty()) {
			s = "";
		} else {
			s = ls.pop();
		}

		while (!ls.empty()) {
			s += sep + ls.pop();
		}

		return s;
	}  // end stk2str()

	public static boolean isPalindromeByWord(String s) {
		// Convert String to Stack of words, s1
		// Reverse s by word, then convert to Stack of words, s2
		// Check if they're the same
		return stk2str(str2words(s), " ").equals(
				stk2str(str2words(revByWord(s)), " ") );
	}  // end isPalindromeByWord()


	// Returns s in reverse order
	public static String reverse(String s) {
		return stk2str(str2letters(s), "");  // push into stack, pop back out
	}

	// Returns true or false depneding on whether s is a palindrome
	// (can be read the same forward & backward)
	public static boolean isPalindrome(String s) {
		return s.equals(reverse(s));
	}

	/* Returns a number given a char, such that:
	 * non-brackets will be 0
	 * opening brackets will be negative
	 * closing brackets will be positve
	 * matching brackets will be additive inverses of each other
	 */
	 public static int bracket(char c) {
		 switch (c) {
			 case '(': return -1;
			 case '[': return -2;
			 case '{': return -3;
			 case '<': return -4;
			 case '>': return 4;
			 case '}': return 3;
			 case ']': return 2;
			 case ')': return 1;
			 default: return 0;
		 }

	 }  // end bracket()

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

			if (bracket(c) < 0) {
				bs.push(c);
			} else if (bracket(c) > 0) {
				try {
					c0 = bs.pop();
				} catch(EmptyStackException e) {
					return false;
				}

				if (bracket(c0) + bracket(c) != 0) {
					return false;
				}
			}  // end nested if

		}  // end for loop

		return bs.empty();
	}  // end parenCheck()

	// Returns a stack of letters as Strings, given a sentence s
	// assumes s is not null
	private static Stack<String> str2letters(String s) {
		Stack<String> ls = new Stack<String>();  // letters stack

		for (int i=0; i < s.length(); i++) {
			ls.push( "" + s.charAt(i) );  // to cast char to String
		}

		return ls;
	}

}  // end class
