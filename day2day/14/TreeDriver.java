import java.io.*;
import java.util.*;

public class TreeDriver {
	public static void main(String[] args) {

		BSTree t = new BSTree();

//		t.seed();
		seedTree(t);
		System.out.println("[" + t.toString() + "]");
		// System.out.println("[" + t.toString2() + "]");
		// System.out.println("[" + t.toString3() + "]");
/* Testing basic delete
		t.delete(20);
		System.out.println("[" + t.toString() + "]");
		t.delete(25);
		System.out.println("[" + t.toString() + "]");
		t.delete(10);
		System.out.println("[" + t.toString() + "]");
*/
		/*Testing 2 children
		t.delete(5);
		System.out.println("[" + t.toString() + "]");
		t = new BSTree();
		seedTree(t);
		t.insert(4);
		t.delete(5);
		System.out.println("[" + t.toString() + "]");
		*/
		t.delete(10);
		System.out.println("[" + t.toString2() + "]");
		t.delete(8);
		System.out.println("[" + t.toString2() + "]");
		t.delete(7);
		System.out.println("[" + t.toString2() + "]");
		t.delete(5);
		System.out.println("[" + t.toString2() + "]");
		t.delete(3);
		System.out.println("[" + t.toString2() + "]");



/* tested
		int value;

		value = t.search(10);
		System.out.println(value);

		value = t.search(20);
		System.out.println(value);

		try {
			value = t.search(30);
			System.out.println(value);
		} catch(NullPointerException e) {
			System.out.println("30 not in tree");
		}
*/

	}  // end main()

	// same as BSTree's seed()
	public static void seedTree(BSTree t) {
		t.insert(10);
		t.insert(20);
		t.insert(5);
		t.insert(7);
		t.insert(8);
		t.insert(3);
		t.insert(25);

	}  // end seed()


}  // end class
