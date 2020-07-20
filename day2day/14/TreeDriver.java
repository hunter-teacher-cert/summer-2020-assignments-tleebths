import java.io.*;
import java.util.*;

public class TreeDriver {
	public static void main(String[] args) {
		BSTree t = new BSTree();

		t.seed();

		int value;

		value = t.search(10);
		System.out.println(value);

		value = t.search(15);
		System.out.println(value);

		try {
			value = t.search(30);
			System.out.println(value);
		} catch(NullPointerException e) {
			System.out.println(e);
		}
		/*
		*/

	}  // end main()

}  // end class
