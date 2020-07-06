public class SuperArray {
    private int[] data;
    private int numberElements;

	// defaults to size 10
	public SuperArray() {
		numberElements = 10;
		data = new int[0];
	}

	public SuperArray(int size) {
		data = new int[size];
		numberElements = 0;  // nothing stored yet
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

	/** Method to add an element at location index. If index is past
	 *  the end of the array, grow the array. Then, shift down all
	 *  the elements past index to create room and then insert value
	 *  into the correct location.
	 */
	public void add(int index, int value) {
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

	/** Method to delete the element at location index from the array.
	 *  Don’t forget to shift down elements to remove the open space.
	 *  returns -999999 if index is invalid
	 */
	public int remove(int index) {
		if (index < 0 || index >= numberElements)
			return -999999;

		int removed = data[index];
		for (int i=index; i < numberElements; i++) {
			data[i] = data[i+1];
		}

		numberElements--;
		return removed;
	}  // end remove()

	/** Returns the value at location index from the array.
	 *  If index is past the last element, return -1.
	 */
    public int get(int index) {
		return index < numberElements ? data[index] : -1;
	}

	/** Returns true if ther are no elemets in the internal array, false otherwise.
	 */
    public boolean isEmpty() {
		return numberElements==0;
	}

	/** Method to increase capacity of array */
	public void grow() {
 		// doubles capacity even for size 0
		int[] newData = new int[2*data.length + 1];

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

}
