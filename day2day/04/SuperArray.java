public class SuperArray {
    private int[] data;
    private int numberElements;

	// default constructor
	public SuperArray() {
		numberElements = 0;
		data = new int[0];
	}

	public SuperArray(int size) {
		numberElements = size;
		data = new int[numberElements];
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
