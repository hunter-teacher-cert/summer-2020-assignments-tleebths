import java.io.*;
import java.util.*;


public class LList {
    private Node head;

    // Initializes an empty linked list
    public LList() {
        head = null;
    }

    // Adds a new Node containing value to the front of the list
    public void addFront(String data){
        // first point the new node to the beginning
        Node newNode = new Node(data, head);
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
    // There's a much shorter version, slightly less efficient
    public String set0(int index, String value) {
        Node tmp;
        String oldData = null;

        // Special case if index is 0. If head is null
        // make new Node(value, head). Otherwise,
        // Set head to new node. .
        if (index==0) {
            if (head == null) {
                tmp = new Node(value, head);
                head = tmp;
            } else {  // Node already exists
                oldData = head.getData();
                head.setData(value);
            }

            return oldData;
        }  // end special case

        // Strategy: Traverse LList up to index - 1.
        // If tmp == null, index is invalid. Else,
        // If tmp.next is NOT null, set its data to value.
        // Else, make new node and point it to what comes
        // AFTER tmp.next, then point tmp to new node.
        tmp = head;
        for(int i=0; i < index-1 && tmp!=null; i++) {
            tmp = tmp.getNext();
        }  // Draw detailed diagram to understand stopping conditions

        if (tmp == null)
            return null;

        if (tmp.getNext() == null) {  // basically adding at end of list
            Node newNode = new Node(value);
            tmp.setNext(newNode);
            return null;
        }

        oldData = tmp.getNext().getData();
        tmp.getNext().setData(value);
        return oldData;

    }  // end set()

    // Insert a new Node containing value at index
    // If index is invalid, do nothing.
    public void insert(int index, String value) {
        Node tmp;

        // Special case if index==0.
        // make new node, set head to new node.
        if (index==0) {
            addFront(value);
            return;
        }

        // Strategy: Traverse LList up to index - 1.
        // If tmp == null, index is invalid. Else,
        // Make new node and point it to tmp.next.
        // Point tmp.next to new node.
        tmp = head;
        for(int i=0; i < index-1 && tmp!=null; i++) {
            tmp = tmp.getNext();
        }  // Draw detailed diagram to understand stopping conditions

        if (tmp == null)
            return;

        Node newNode = new Node(value, tmp.getNext());
        tmp.setNext(newNode);
        return;

    }  // end insert()

    // Removes the Node at index from the list &
    // Returns the String at that node if it existed
    // If index is invalid, do nothing.
    public String remove(int index) {
        Node tmp;
        String oldData = null;

        // Special case if index is 0. If head is null
        // return null. Otherwise, get the node's data
        // then point head to node's next.
        if (index == 0) {
            if (head != null) {
                oldData = head.getData();
                head = head.getNext();
            }

            return oldData;
        }  // end special case

        // Strategy: Traverse LList up to index - 1.
        // If tmp == null, index is invalid. Else,
        // remove data from tmp.next if it's not null.
        // Point tmp to tmp.next.next.
        tmp = head;
        for(int i=0; i < index-1 && tmp!=null; i++) {
            tmp = tmp.getNext();
        }  // Draw detailed diagram to understand stopping conditions

        if (tmp == null)
            return null;

        if (tmp.getNext() != null) {  // basically adding at end of list
            oldData = tmp.getNext().getData();
            tmp.setNext( tmp.getNext().getNext() );
        }

        return oldData;
    }  // end remove()

    // Set the Node at index to contain value.
    // Returns value currently at index
    // If index is invalid, do nothing.
    public String set(int index, String value) {
        String s = remove(index);
        insert(index, value);
        return s;
    }

    // Returns the index of the first time key occurs in the list.
    // Returns -1 if key is not found.
    public int search(String key) {
        int index = 0;
        Node tmp = head;

        while (tmp != null) {
            if (tmp.getData() == key)
                return index;

            tmp = tmp.getNext();
            index++;
        }

        return -1;
    }


    // Returns size of the linked list
    public int size() {
        int count = 0;
        Node tmp = head;

        while (tmp != null) {
            count++;
            tmp = tmp.getNext();
        }

        return count;
    }

    // Returns true if the list is empty, false otherwise
    public boolean isEmpty() {
        return head==null;
    }

    // Returns a String representation of the list
    public String toString(){
        String s = "";
        Node tmp = head;

        // avoids space at the end
        if (tmp != null) {
            s = tmp.getData();
            tmp = tmp.getNext();
        }
        while (tmp != null){
            s += " " + tmp.getData();
            // how can we now move tmp to the next node
            // this is the magic linked list idiom!!!!
            // this moves a pointer to the next node!!!
            // It's analagous to i=i+1 for an array (for loop)
            tmp = tmp.getNext();
        }

        s = "<" + s + ">";
        return s;
    }

}