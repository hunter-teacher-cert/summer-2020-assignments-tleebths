public class SuperArray {
    private int[] data;
    private int numberElements;

	public SuperArray(int size) {
		data = new int[size];
		numberElements = 0;  // nothing stored yet
	}

	// defaults to size 10
	public SuperArray() {
		this(10);
	}

	/** Returns the number of items used in the array */
	public int size() {
		return numberElements;
	}

	/** This routine will add the parameter value to the end of the SuperArray
	 *  (don’t forget to update numberElements).
	 *  If there is no more room in the array it will grow then add.
	 */
    public void add(int value) {
		if(numberElements == data.length) {
			this.grow();
		}
		data[numberElements++] = value;

	}  // end add()

	/** Method to add an element at location index. Do nothing
     *  if adding past end of used elements. If index is past
	 *  the end of the array, grow the array. Then, shift down all
	 *  the elements past index to create room and then insert value
	 *  into the correct location.
	 */
	public void add(int index, int value) {
        if (index > numberElements || index < 0)
            return;
 		if (numberElements == data.length) {
 			this.grow();
 		}
		// copy from back to front to avoid overwriting
		for (int i=numberElements; i>index; i--) {
 			data[i] = data[i-1];
		}
		// insert value, update tracker
		data[index] = value;
		numberElements++;

 	}  // end add()

    /** Method to set an element at location index. Do nothing
     *  if index is past end of used elements. Otherwise,
     *  remove the item at given index and replace with new value.
	 */
	public int set(int index, int value) {
        int removed = Integer.MIN_VALUE;

        if (index <= numberElements && index >= 0) {
            // store item to be removed
            if (index < numberElements)
                removed = data[index];

            data[index] = value;
        }

        return removed;
 	}  // end add()

	/** Method to delete the element at location index from the array.
	 *  Don’t forget to shift down elements to remove the open space.
	 *  returns smallest possible int if index is invalid
	 */
	public int remove(int index) {
		if (index < 0 || index >= numberElements)
			return Integer.MIN_VALUE;

		int removed = data[index];
		for (int i=index; i < numberElements; i++) {
			data[i] = data[i+1];
		}

		numberElements--;
		if (numberElements < data.length / 3)
			shrink();

		return removed;
	}  // end remove()

	/** Returns the value at location index from the array.
	 *  If index is past the last element, return smallest Java int
	 */
    public int get(int index) {
		return (index < numberElements && index >= 0)? data[index] : Integer.MIN_VALUE;
	}

	/** Returns true if ther are no elemets in the internal array, false otherwise.
	 */
    public boolean isEmpty() {
		return numberElements==0;
	}

	/** Method to increase capacity of array */
	public void grow() {
 		// doubles capacity even for size 0
		int[] newData = new int[1.5*data.length + 1];

		// copy over
		for (int i=0; i < numberElements; i++){
			newData[i] = data[i];
		}

		// switch over
		data = newData;
	}

	/** Method to increase capacity of array */
	public void shrink() {
		int[] newData = new int[0];
 		// doubles capacity even for size 0
		newData = new int[data.length/2];

		// copy over
		for (int i=0; i < numberElements; i++){
			newData[i] = data[i];
		}

		// switch over
		data = newData;
	}

	/** method to return a String representation of SuperArray */
	public String toString() {
		String s = "[";
		for(int i=0; i<numberElements - 1; i++) {
			s += data[i] + ", ";
		}
		// add last element w/o space after
		if (numberElements > 0)
			s += data[numberElements - 1];

		s += "]";
		return s;
	}  // end toString()

    /** Method to detail contents */
    public String debug() {
        String s = "";
        s = "Size: " + this.data.length;
        s = s + " LastItem: " + data[numberElements-1] + "  Data: ";
        for (int i = 0; i < data[numberElements-1]; i++) {
    	    s = s + data[i] + ", ";
        }
        s = s + "\n";
        return s;
    }

}  // end class
