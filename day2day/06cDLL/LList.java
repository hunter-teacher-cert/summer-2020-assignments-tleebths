import java.io.*;
import java.util.*;

/** This list will be doubly-linked, circular list with a
 *  dummy Node at the beginning. Wish me luck.
 */
public class LList {
    private Node head;
    private int length;
    private Node prev;  // works with cur. set to null if invalid
    private Node cur;  // for reading data, may be null

    // Initializes an empty linked list
    public LList() {
        this.head = new Node("I'm a dummy, dummy.");
        head.setPrev(head);
        head.setNext(head);
        this.length = 0;  // must update with any addition/deletion
        this.prev = head;
        this.cur = null;
    }

    // Method set cur to Node at index, prev to previous Node.
    // If index is out of bounds, cur & prev will be set to null.
    // cur will be null if prev is valid (eg. at empty or end of list).
    private void getNode(int index) {
        if (index < 0) {
            prev = cur = null;
            return;
        }

        prev = head;
        cur = prev.getNext();

        for (int i=0; i<index; i++) {
            prev = prev.getNext();  // skip updating cur for now

            if (prev == head) {  // circled back
                prev = cur = null;
                return;
            }

        }

        // System.out.printf("getNode(): index=%d, data=%s\n", index, tmp.getData());
        cur = prev.getNext();
        if (cur == head) {  // end of list
            cur = null;
        }

    }  // end getNode()

    // Returns the value (not the Node) at index.
    // If index is out of bounds, return null.
    public String get(int index) {
        getNode(index);

        return (cur!=null ? cur.getData() : null);
    }

    // Adds a new Node containing value to the front of the list
    public void addFront(String data){
        // first new node points to what head points to
        Node newNode = new Node(data, head, head.getNext());
        // head will link to the new node
        head.setNext(newNode);
        length++;
    }

    // This versioon CANNOT set index right after last data Node.
    // Set the Node at index to contain value.
    // If index is invalid, do nothing.
    public void set(int index, String value) {
        getNode(index);

        if (prev == null)  // invalid index
            return;

        if (cur != null) {
            cur.setData(value);  // just a normal node
            return;
        }

        // inserting at the end
        cur = new Node(value, prev, head);
        head.setPrev(cur);
        prev.setNext(cur);
        length++;
    }  // end set()

    // Insert a new Node containing value at index
    // If index is invalid, do nothing.
    public void insert(int index, String value) {
        getNode(index);

        // inserting at 0 is same as adding in front
        if (prev == null)
            return;

        cur = new Node(value, prev, prev.getNext());
        prev.getNext().setPrev(cur);
        prev.setNext(cur);
        length++;
    }  // end insert()

    // Removes the Node at index from the list &
    // If index is invalid, do nothing.
    public void remove(int index) {
        getNode(index);

        if (cur == null)
            return;

        cur = cur.getNext();  // skips over
        prev.setNext(cur);
        cur.setPrev(prev);
        length--;

    }  // end remove()

    // Returns the index of the first time key occurs in the list.
    // Returns -1 if key is not found.
    public int search(String key) {
        int i=0;

        for (cur = head.getNext(); cur != head; cur = cur.getNext()) {
            if ( cur.getData().equals(key) ) {
                return i;
            }
            i++;
        }

        return -1;
    }


    // Returns true if the list is empty, false otherwise
    public boolean isEmpty() {
        return length==0;
    }

    // Returns a String representation of the list
    public String toString(){
        String s = "<";

        for (cur = head.getNext(); cur != head; cur = cur.getNext()) {
            s += cur.getData() + " ";
        }

        s += ">";
/* original
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
*/
        return s;
    }

    public int length() {
        return length;
    }

}
