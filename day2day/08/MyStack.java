import java.io.*;
import java.util.*;


public class MyStack {
    private Node head;
    private int length;  // must update if push/pop
    private int maxLen;

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
        return ( head==null ? null : head.getData() );
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
        return toString(head);
    }

    // helper method when given a reference to a LList of Nodes
    // To be cute &
    private String toString(Node cur) {
        if (cur == null)
            return "|__________|";
        else
            return "|_" + "\n" + toString(cur.getNext());
    }

}  // end class
