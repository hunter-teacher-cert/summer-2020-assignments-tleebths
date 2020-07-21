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

	/* Returns the node containing the parent of where key should be,
	 * null if key is in the root node.
	 * Precondition: root is not null and does not contain key
	 */
	private TreeNode getParent(int key) {
		TreeNode prev = null, cur = root;
		int data;

		do {
			data = cur.getData();  //System.out.printf("v=%d, key=%d\n", data, key);

			if (key < data) {
				prev = cur;
				cur = cur.getLeft();
			} else if (key > data) {
				prev = cur;
				cur = cur.getRight();
			} else {  //System.out.printf("getParent key: %d, prev: %d.\n",key,data);
				return prev;  // already in tree
			}
		} while (cur != null);  //System.out.printf("getParent key: %d, prev: %d.\n",key,data);

		return prev;
	}  // end getParent()

	/* Deletes node with value v from the tree.
	 * If the root is that node, make left child the new root
	 * then graft all descendants from original right child to it
	 * Does nothing if value does not exist in tree
	 */
	public TreeNode delete(int v) {
		TreeNode prev, cur=null;
		TreeNode curLeft, curRight;  // child and its children
		TreeNode max;  // needed when deleting a node w/ 2 children

		if (root == null) {  // tree is empty
			return null;
		} else if (root.getData() == v) {
			cur = root;
			curLeft = root.getLeft();
			curRight = root.getRight();

			// if either child is null, the other child becomes root
			if (curLeft==null) {
				root = curRight;
			} else if (curRight==null) {
				root = curLeft;
			}

			/* See normal node w/ 2 children below for details.
			 * 0) Find GELB (<= 1 child)
			 * 1) Hold onto GELB (or null)
			 * 2) Delete GELB from the tree
			 * 3) GELB becomes foster parent of deleted node's children, child of prev.
			 * 4) Disconnect deleted node from tree & return it
			 */
			max = findMax(root.getLeft());
			delete(max.getData());
			max.setLeft(root.getLeft());
			max.setRight(root.getRight());
			root = max;

			return disconnect(cur);
		}

		/* find the parent, then use it to find
		 * which branch v belongs to, but it may already exist
		 */
		prev = getParent(v);
		int prevData = prev.getData();  //System.out.print(prevData+" ");

		if (v < prevData) {
			cur = prev.getLeft();

		} else if (v > prevData) {
			cur = prev.getRight();
		}

		if (cur==null || cur.getData() != v) {
			return null;  // v doesn't exist in tree
		}

		// At this point, cur is the node to be deleted.
		// Get the child's left and right for future use.
		// prev is its parent.
		curLeft = cur.getLeft();
		curRight = cur.getRight();

		// if either is null, make the other branch the current node
		// deleting a leaf == deleting a child with only one child
		if (curLeft==null) {
			if (v < prevData) {
				prev.setLeft(curRight);
			} else if (v > prevData) {
				prev.setRight(curRight);
			}

			return disconnect(cur);
		} else if (curRight==null) {
			if (v < prevData) {
				prev.setLeft(curLeft);
			} else if (v > prevData) {
				prev.setRight(curLeft);
			}

			return disconnect(cur);
		}

		/* Deleting a child with 2 children. Two options:
		 * a) Choose greatest element on left branch (GELB); or
		 * b) Choose least element on right branch
		 * They're guaranteed to be a leaf
		 * OR have only one branch.
		 */
		/* Choosing option a: 0) Find GELB (<= 1 child)
		 * 1) Hold onto only child of GELB (or null)
		 * 2) Delete GELB from the tree
		 * 3) GELB becomes foster parent of deleted node's children, child of prev.
		 * 4*) Add all of GELB's original children from step 1 back to tree
		 * (*Not nec. cuz GELB delete would've take care of that in #2)
		 * 5) Disconnect deleted node from tree & return it
		 */
		max = findMax(cur.getLeft());  // cannot be null
		delete(max.getData());  // step 2
		max.setLeft(cur.getLeft());  // step 3
		max.setRight(cur.getRight());
		if (v < prevData) {
			prev.setLeft(max);
		} else if (v > prevData) {
			prev.setRight(max);
		}

		return disconnect(cur);  // step 5
	}  // end delete()

	/* Disconnects TreeNode cur from rest of the tree
	 * then returns reference to the node
	 */
	private TreeNode disconnect(TreeNode cur) {
		cur.setLeft(null);
		cur.setRight(null);
		return cur;
	}

	/* Returns the TreeNode containing the maximum value of
	 * the given subtree starting from TreeNode cur
	 * (max can only be on right side)
	 */
	private TreeNode findMax(TreeNode cur) {
		if (cur==null)
			return null;

		int data = cur.getData();
		TreeNode maxNodeOfChildren = findMax(cur.getRight());

		return (maxNodeOfChildren==null ? cur : maxNodeOfChildren);
	}

	/* Prints out the tree from a given node, in order of:
	 * left, current, right
	 */
	public String inOrderTraverse(TreeNode tn) {
		if (tn==null) {
			return "";
		}

		return inOrderTraverse(tn.getLeft()) + " " + tn.getData()
					+ " " + inOrderTraverse(tn.getRight());
	}  // end inOrderTraverse()

	/* Prints out the tree from a given node, in order of:
	 * left, right, current
	 */
	public String postorderTraverse(TreeNode tn) {
		if (tn==null) {
			return "";
		}

		return postorderTraverse(tn.getLeft()) + " " + postorderTraverse(tn.getRight())
									+ " " + tn.getData();
	}  // end postorderTraverse()

	/* Prints out the tree from a given node, in order of:
	 * current, left, right
	 */
	public String preorderTraverse(TreeNode tn) {
		if (tn==null) {
			return "";
		}

		return tn.getData() + " " + preorderTraverse(tn.getLeft())
				+ " " + preorderTraverse(tn.getRight());
	}  // end prerderTraverse()

	public String toString() {
		String result = inOrderTraverse(root);

		return result;
	}

	public String toString2() {
		String result = postorderTraverse(root);

		return result;
	}

	public String toString3() {
		String result = preorderTraverse(root);

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
