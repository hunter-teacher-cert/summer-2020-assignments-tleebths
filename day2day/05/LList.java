import java.io.*;
import java.util.*;


public class LList {
    private Node head;
    private int length;

    // Initializes an empty linked list
    public LList() {
        head = null;
        length = 0;  // must update with any addition/deletion
    }

    // Adds a new Node containing value to the front of the list
    public void addFront(String data){
        // first point the new node to the beginning
        Node newNode = new Node(data, head);
        // point head to the new node
        head = newNode;
        length++;
    }

    // Returns the Node at index.
    // If index is out of bounds, return null.
    private Node getNode(int index) {
        Node tmp = head;
        for(int i=0; i<index && tmp!=null; i++) {
            tmp = tmp.getNext();
        }

        return (tmp!=null ? tmp : null);

    }  // end getNode()

    // Returns the value (not the Node) at index.
    // If index is out of bounds, return null.
    public String get(int index) {
        Node tmp = getNode(index);

        return (tmp!=null ? tmp.getData() : null);
    }

    // Insert a new Node containing value at index
    // If index is invalid, do nothing.
    public void insert(int index, String value) {
        Node prev;

        // Special case if index==0.
        // make new node, set head to new node.
        if (index==0) {
            addFront(value);  // length adjusted there
            return;
        }

        // Strategy: Traverse LList up to index - 1.
        // If tmp == null, index is invalid. Else,
        // Make new node and point it to tmp.next.
        // Point tmp.next to new node.
        prev = getNode(index-1);
        if (prev == null)
            return;

        Node newNode = new Node(value, prev.getNext());
        prev.setNext(newNode);
        length++;
    }  // end insert()

    // Removes the Node at index from the list &
    // Returns the String at that node if it existed
    // If index is invalid, do nothing.
    public String remove(int index) {
        Node prev;
        String oldData = null;

        // Special case if index is 0. If head is null
        // return null. Otherwise, get the node's data
        // then point head to node's next.
        if (index == 0) {
            if (head != null) {
                oldData = head.getData();
                head = head.getNext();
                length--;
            }

            return oldData;
        }  // end special case

        // Strategy: Traverse LList up to index - 1.
        // If tmp == null, index is invalid. Else,
        // remove data from tmp.next if it's not null.
        // Point tmp to tmp.next.next.
        prev = getNode(index - 1);
        if (prev == null)
            return null;

        Node cur = prev.getNext();
        if (cur != null) {  // basically adding at end of list
            oldData = cur.getData();
            prev.setNext( cur.getNext() );
            length--;
        }

        return oldData;
    }  // end remove()

    // Set the Node at index to contain value.
    // Returns value currently at index
    // If index is invalid, do nothing.
    public String set(int index, String value) {
        String s = null;  // return value

        if (index==0) {
            s = remove(0);
            addFront(value);
            return s;
        }

        Node prev = getNode(index-1);  // To point to node before index
        if (prev==null)  // invalid index
            return s;

        if (index < length) {  // node already exists
            Node cur = prev.getNext();
            s = cur.getData();
            cur.setData(value);

			// if (value.equals("tofr"))
			// 	System.out.println(cur.getData() + " " + index + " " + length);
            return s;
        }

        prev.setNext( new Node(value) );  // node didn't exist
        length++;
        return s;
    }

    // Returns the index of the first time key occurs in the list.
    // Returns -1 if key is not found.
    public int search(String key) {
        Node tmp = head;
        for (int i=0; tmp!=null; i++) {
            if ( tmp.getData().equals(key) )
                return i;

            tmp = tmp.getNext();
        }

        return -1;
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

    public int length() {
        return length;
    }

}
