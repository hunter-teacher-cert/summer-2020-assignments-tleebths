import java.io.*;
import java.util.*;

/** This list will be single-linked, circular list with a
 *  dummy Node at the beginning. Wish me luck.
 */
public class LList {
    private Node head;
    private int length;

    // Initializes an empty linked list
    public LList() {
        head = new Node("I'm a dummy, dummy.");
        head.setNext(head);
        length = 0;  // must update with any addition/deletion
        System.out.println("Done init LList");
    }

    // Returns the Node at index.
    // If index is out of bounds, return head.
    private Node getNode(int index) {
        if (index < 0)
            return head;

        Node tmp = head.getNext();
        for(int i=0; i<index && tmp!=head; i++) {
            tmp = tmp.getNext();
        }

        // System.out.printf("getNode(): index=%d, data=%s\n", index, tmp.getData());
        return (tmp!=head ? tmp : head);
    }  // end getNode()

    // Returns the value (not the Node) at index.
    // If index is out of bounds, return null.
    public String get(int index) {
        Node tmp = getNode(index);

        return (tmp!=head ? tmp.getData() : null);
    }

    // Adds a new Node containing value to the front of the list
    public void addFront(String data){
        // first new node points to what head points to
        Node newNode = new Node(data, head.getNext());
        // head will link to the new node
        head.setNext(newNode);
        length++;
    }

    // This versioon CANNOT set index right after last data Node.
    // Set the Node at index to contain value.
    // If index is invalid, do nothing.
    public void setSimple(int index, String value) {
        Node prev = getNode(index - 1);
        Node cur = prev.getNext();

        if (prev == head)  // invalid index
            return;

        if (cur == head) {  // inserting at the end
            cur = new Node(value, head);
            prev.setNext(cur);
        }

        cur.setData(value);  // just a normal node
    }  // end setSimple()

    // Set the Node at index to contain value.
    // If index is right after last data Node, make new node.
    // If index is invalid, do nothing.
    public void set(int index, String value) {
        Node prev, cur;

        if (index!=0) {
            prev = getNode(index - 1);
            cur = prev.getNext();
        } else {
        // If index is 0, length==0 is same as inserting at end.
        // If index is 0, length!=0 is same as setting any other node.
            prev = null;
            if (length==0) {
                cur = head;
            } else {
                cur = head.getNext();
            }
        }  // end if-else

        if (prev == head)  // invalid index
            return;

        if (cur == head) {  // inserting at the end
            cur = new Node(value, head);
            prev.setNext(cur);
            length++;
        }

        cur.setData(value);  // just a normal node
    }  // end set()

    // Insert a new Node containing value at index
    // If index is invalid, do nothing.
    public void insert(int index, String value) {
        Node prev = getNode(index-1);

        // inserting at 0 is same as adding in front
        if (prev==head && index!=0)
            return;

        prev.setNext( new Node(value, prev.getNext()) );
        length++;
    }  // end insert()

    // Removes the Node at index from the list &
    // If index is invalid, do nothing.
    public void remove(int index) {
        Node prev = getNode(index-1);

        // inserting at 0 is same as adding in front
        if (prev==head && index!=0)
            return;

        Node cur = prev.getNext();
        if (cur != null) {
            oldData = cur.getData();
            prev.setNext( cur.getNext() );
            length--;
        }

    }  // end remove()

    // Returns the index of the first time key occurs in the list.
    // Returns -1 if key is not found.
    public int search(String key) {
        int i=0;

        for (Node tmp = head.getNext(); tmp != head; tmp = tmp.getNext()) {
            if ( tmp.getData().equals(key) ) {
                return i;
            }
            i++;
        }

        return -1;
    }


    // Returns true if the list is empty, false otherwise
    public boolean isEmpty() {
        return head.getNext() == head;
    }

    // Returns a String representation of the list
    public String toString(){
        String s = "<";

        for (Node tmp = head.getNext(); tmp != head; tmp = tmp.getNext()) {
            s += tmp.getData() + " ";
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
