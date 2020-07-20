// Binary Search Tree
public class BSTree {
	// object attributes
	private TreeNode root;

	public BSTree() {
		root = null;
	}

	public BSTree(int data) {
		root = new TreeNode(data);
	}

	/* Returns the node containing the key
	 * null if not found
	 */
	private TreeNode getNode(int key) {
		TreeNode tn = root;
		int v;

		while (true) {//tn != null
			v = tn.getData();  //System.out.printf("v=%d, key=%d\n", v, key);

			if (key < v) {
				tn = tn.getLeft();
			} else if (key > v) {
				tn = tn.getRight();
			} else {
				return tn;
			}
		}  // end while

		//throw new NullPointerException();  // & get rid of while
		//return null;
	}  // end getNode()

	/* Returns key if found in tree
	 * throws NullPointerException otherwise
	 */
	public int search(int key) {
		getNode(key);
		return key;
		//return (getNode(key)==null ? -1 : key);
	}

	public String toString() {
		String result="";

		return result;
	}

	public void seed() {
		TreeNode t;

		t = new TreeNode(10);
		root = t;
		t = new TreeNode(5);
		root.setLeft(t);
		t = new TreeNode(20);
		root.setRight(t);

		root.getLeft().setRight( new TreeNode(8) );

		t = new TreeNode(15);
		root.getRight().setLeft(t);

		t = new TreeNode(22);
		root.getRight().setRight(t);

	}  // end seed()
}
