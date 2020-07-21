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
		TreeNode cur = root;
		int v;

		while (true) {//tn != null
			v = cur.getData();  //System.out.printf("v=%d, key=%d\n", v, key);

			if (key < v) {
				cur = cur.getLeft();
			} else if (key > v) {
				cur = cur.getRight();
			} else {
				return cur;
			}
		}  // end while

		//throw new NullPointerException();  // & get rid of while
		//return null;
	}  // end getNode()

	/* Returns key if found in tree
	 * throws NullPointerException otherwise
	 */
	public int search(int key) {
		return getNode(key).getData();
		//return (getNode(key)==null ? -1 : key);
	}

	/* Returns the node containing the parent of where key should be,
	 * null if key is in the root node.
	 * Precondition: root is not null and does not contain key
	 */
	private TreeNode getParent(int key) {
		TreeNode prev = null, cur = root;
		int data;

		do {
			data = cur.getData();  //System.out.printf("v=%d, key=%d\n", v, key);
			prev = cur;

			if (key < data) {
				cur = cur.getLeft();
			} else if (key > data) {
				cur = cur.getRight();
			} else {
				return prev;  // already in tree
			}
		} while (cur != null);

		return prev;
	}  // end getParent()

	/* Adds a new node with value for data in the correct position
	 * Does nothing if value already exists in tree
	 * Note: new data always added as a leaf.
	 */
	public void insert(int v) {
		TreeNode newNode = new TreeNode(v);

		if (root == null) {  // tree is empty
			root = newNode;
			return;
		}

		TreeNode prev = getParent(v);
		if (prev==null) {  // root contains v
			return;
		}

		// find which branch v belongs to, but it may already exist
		int prevData = prev.getData();
		if (v < prevData) {
			if (prev.getLeft()==null) {
				prev.setLeft(newNode);
			}  // else, v is in the child node, cur
		} else if (v > prevData) {
			if (prev.getRight()==null) {
				prev.setRight(newNode);
			}
		}

	}  // end insert()

	/* Prints out the tree from a given node, in order of:
	 * left, current, right
	 */
	public String traverse(TreeNode tn) {
		if (tn==null) {
			return "";
		}

		return traverse(tn.getLeft()) + " " + tn.getData() + " " + traverse(tn.getRight());
	}  // end traverse()

	/* Prints out the tree from a given node, in order of:
	 * left, right, current
	 */
	public String traverse2(TreeNode tn) {
		if (tn==null) {
			return "";
		}

		return traverse2(tn.getLeft()) + " " + traverse2(tn.getRight()) + " " + tn.getData();
	}  // end traverse()

	/* Prints out the tree from a given node, in order of:
	 * current, left, right
	 */
	public String traverse3(TreeNode tn) {
		if (tn==null) {
			return "";
		}

		return tn.getData() + " " + traverse3(tn.getLeft()) + " " + traverse3(tn.getRight());
	}  // end traverse()

	public String toString() {
		String result = traverse(root);

		return result;
	}

	public String toString2() {
		String result = traverse2(root);

		return result;
	}

	public String toString3() {
		String result = traverse3(root);

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
