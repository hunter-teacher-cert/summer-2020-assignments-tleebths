public class SuperArray {
    private int[] data;
    private int numberElements;

	// default constructor
	public SuperArray() {
		numberElements = 0;
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
	 *  If there is no more room in the array do nothing.
	 */
    public boolean add(int value) {
		boolean flag = false;  // true if could add to data
		if (numberElements <= data.length && data.length > 0) {
			data[numberElements++] = value;
			flag = true;
		}

		return flag;
	}  // end add()

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
		int[] newData = new int[2*data.length];  // doubles capacity
		for (int i=0; i < numberElements; i++){  // copy over
			newData[i] = data[i];
		}

		data = newData;  // switch over
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
