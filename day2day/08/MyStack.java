import java.io.*;
import java.util.*;


public class MyStack {
    private Node head;
    private int length;  // must update if push/pop

    // Initializes an empty stack
    public MyStack() {
        head = null;
        length = 0;  // must update with any addition/deletion
    }

    // Adds a new Node containing value to the front of the list
    // Increments length
    public void push(String data){
        head = new Node(data, head);
        length++;
    }

    // Returns the last value added, or null if stack is empty
    // Else, there's at least one node. Decrement length.
    public String pop() {
        if (isEmpty())
            return null;

        String data = head.getData();
        head = head.getNext();
        length--;

        return data;
    }

    // return but don't remove the item from the top of the stack
    public String top() {
        return (head==null ? null : head.getData());
    }

    // Returns true if the stack is empty, false otherwise
    public boolean isEmpty() {
        return length==0;
    }

    // Returns the number of items currently on the stack
    public int size() {
        return length;
    }

    // Returns a String representation of the stack
    public String toString(){
        return toString(head, 6)[1];  // arbitary length 6 in case stack's empty
    }

    /* Helper method returns array [s1, s1] when given a LList of Nodes
     * e.g. ["6","   Tsee    \n     Lee    \n|______|"]
     * s1 is String representation of length of longest data
     * s2 is the toString() of the lower levels of the stack
     */
    private String[] toString(Node cur, int maxLen) {
        String curStr;

        if (cur == null) {
             curStr = "|";
            for (int i=0; i<maxLen; i++) {
                curStr += "_";
            }

            return new String[]{"6", curStr + "|"};
        }
        else {
            curStr = cur.getData();
            int curLen = curStr.length();
            maxLen = (maxLen<curLen ? curLen : maxLen);

            String[] lower = toString(cur.getNext(), maxLen);  // do lower levels first
            int lowerLen = Integer.parseInt(lower[0]);
            String lowerStr = lower[1];
            maxLen = (maxLen<lowerLen ? lowerLen : maxLen);

            String spaces = "";
            for (int i=0; i < (maxLen-curLen)/2 + 1 ; i++) {
                spaces += " ";
            }

            curStr = spaces + curStr + spaces + "\n" + lowerStr;

            return new String[]{String.valueOf(maxLen), curStr};
        }
    }

}  // end class
