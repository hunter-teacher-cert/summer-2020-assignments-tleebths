/public class MyStack {
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
        return toString(head, 4)[1];  // arbitary len=4 in case stack's empty
    }

    /* Helper method returns String array when given a LList of Nodes
     * e.g. ["6","   Tsee    \n     Lee    \n|______|"]
     * @param cur Start of the Node to convert to toString
     * @param maxLen = longest of data from the top to current level
     * @return String array [s1, s2], such that:
     * s1 is the length of longest data so far, as a String
     * s2 is the toString() of the lower levels of the stack
     */
    private String[] toString(Node cur, int maxLen) {
        String curStr = "";

        // Base case: empty stack. Print as many _ with padding
        if (cur == null) {
            for (int i=0; i < maxLen+2; i++) {
                curStr += "_";
            }
            curStr = "|" + curStr + "|";

            return new String[]{String.valueOf(maxLen), curStr};
        }

        // recursive case
        // get current node's data, update maxLen if nec.
        curStr = cur.getData();
        int curLen = curStr.length();
        maxLen = (maxLen<curLen ? curLen : maxLen);

        // do lower levels first and update maxLen again
        String[] lower = toString(cur.getNext(), maxLen);
        int lowerLen = Integer.parseInt(lower[0]);
        String lowerStr = lower[1];
        maxLen = (maxLen<lowerLen ? lowerLen : maxLen);

        // figure out padding front and back, incl. "|" & " "
        String spaces = "";
        for (int i=0; i < (maxLen-curLen)/2 + 2 ; i++) {
            spaces += " ";
        }

        // put it all together
        curStr = spaces + curStr + spaces + "\n" + lowerStr;

        return new String[]{String.valueOf(maxLen), curStr};
    }  // end toString(N,i)

}  // end class
