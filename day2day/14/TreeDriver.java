import java.io.*;
import java.util.*;

public class TreeDriver {
	public static void main(String[] args) {

		BSTree t = new BSTree();

//		t.seed();
		seedTree(t);

		int value;

		value = t.search(10);
		System.out.println(value);

		value = t.search(15);
		System.out.println(value);

		try {
			value = t.search(30);
			System.out.println(value);
		} catch(NullPointerException e) {
			System.out.println("30 not in tree");
		}

	}  // end main()

	// same as BSTree's seed()
	public static void seedTree(BSTree t) {
		t.insert(10);
		t.insert(5);
		t.insert(20);
		t.insert(8);
		t.insert(15);
		t.insert(22);

	}  // end seed()


}  // end class
