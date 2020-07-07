import java.io.*;
import java.util.*;


public class LList {
    private Node head;

    // Initializes an empty linked list
    public LList() {
        head = null;
    }

    // Adds a new Node containing value to the front of the list
    public void add(String data){
        Node newNode = new Node(data);

        // first point the new node to the beginning
        newNode.setNext(head);

        // point head to the new node
        head = newNode;
    }

    // Returns the value (not the Node) at index.
    // If index is out of bounds, return null.
    public String get(int index) {
        Node tmp = head;
        for(int i=0; i<index && tmp!=null; i++) {
            tmp = tmp.getNext();
        }

        if (tmp != null)
            return tmp.getData();
        else
            return null;

    }

    // Set the Node at index to contain value.
    // Returns value currently at index
    // If index is invalid, do nothing.
    public void set(int index, String value) {
        // Special case if head==null && index==0.
        // make new node, set head to new node.
        // Strategy: Traverse LList up to index - 1.
        // If tmp == null, index is invalid. Else,
        // If tmp.next is NOT null, set its data to value.
        // Else, make new node and point it to what comes
        // AFTER tmp.next, then point tmp to new node.
        if (head==null && index==0) {
            head = new Node(value);
            return;
        }

        Node tmp = head;
        for(int i=0; i<index && tmp!=null; i++) {
            tmp = tmp.getNext();
        }

        if (tmp == null)
            return null;

        return tmp.getData();

    }

    // Returns true if the list is empty, false otherwise
    public boolean isEmpty() {
        return head==null;
    }

    // Returns a String representation of the list
    public String toString(){
        String s = "";

        Node tmp;
        tmp = head;
        while (tmp != null){
            s = s + tmp.getData()+"-->";
            // how can we now move tmp to the next node
            // this is the magic linked list idiom!!!!
            // this moves a pointer to the next node!!!
            // It's analagous to i=i+1 for an array (for loop)
            tmp = tmp.getNext();
        }

        s = s + "null";
        return s;
    }

}
