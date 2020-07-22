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
	 * If not found, throws NullPointerException
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

	}  // end getNode()

	/* Returns key if found in tree
	 * throws NullPointerException otherwise
	 */
	public int search(int key) {
		return getNode(key).getData();
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
		TreeNode prev=null, cur=root;  // piggybacking
		TreeNode curLeft, curRight;  // child and its children
		TreeNode sub;  // needed when deleting a node w/ 2 children

		if (root == null) {  // tree is empty
			return null;
		}

		if (root.getData() == v) {  // have to del root
			curLeft = root.getLeft();
			curRight = root.getRight();

			// if either child is null, the other child becomes root
			// works even if both are null
			if (curLeft==null) {
			   root = curRight;

			   return disconnect(cur);
			}

			/* Left is not null, so:
			* 1) Find Maximum node on Left Branch (<= 1 child)
			* 2) Delete MaxLB from the tree
			* 3) MaxLB becomes foster parent of root's children
			* 4) Disconnect original root from tree & return it
			*/
			sub = findDelMaxLB(root);
			sub.setLeft(root.getLeft());
			sub.setRight(root.getRight());
			root = sub;

			return disconnect(cur);
		}  // end deleting root

		int data;

		do {  // find node to be deleted
			data = cur.getData();
			prev = cur;

			if (v < data) {
				cur = cur.getLeft();
			} else if (v > data) {
				cur = cur.getRight();
			}

			if (cur==null) {
				return null;  // v doesn't exist in tree
			}

		} while (cur.getData()!=v);

		// System.out.printf("deleting %d, prev=%d, cur=%d\n",
		// 					v, prev.getData(), cur.getData());
		// At this point, cur is the node to be deleted.
		// Get the child's left and right for future use.
		// prev is its parent.
		curLeft = cur.getLeft();
		curRight = cur.getRight();

		// if left branch is empty, find out which side cur is on prev
		// & stick the right branch there
		// deleting a leaf == deleting a child with only one child
		if (curLeft==null) {
			if (cur==prev.getLeft()) {
				prev.setLeft(curRight);
			} else if (cur==prev.getRight()) {
				prev.setRight(curRight);
			}

			return disconnect(cur);
		}

		/* Left branch exists, so replace cur with left's MaxLB
		 * It's guaranteed to be a leaf OR have only one branch.
		 *
		 * 1) Find Maximum value on Left Branch (<= 1 child)
		 * 2) Delete MaxLB from the tree
		 * 3) MaxLB becomes foster parent of deleted node's children, child of prev.
		 * 4) Disconnect deleted node from tree & return it
		 */
		sub = findDelMaxLB(cur);  // steps 1-2
		sub.setLeft(cur.getLeft());  // step 3
		sub.setRight(cur.getRight());
		if (prev.getLeft()==cur) {
			prev.setLeft(sub);
		} else if (prev.getRight()==cur) {
			prev.setRight(sub);
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
	 * the left branch of the subtree from TreeNode tn; And
	 * DELETES that node from the tree
	 * Precondition: tn != null && tn.getLeft() != null
	 */
	private TreeNode findDelMaxLB(TreeNode tn) {
		// left one then all the way to the right
		TreeNode prev = tn, cur = tn.getLeft();

		while (cur.getRight() != null) {
			prev = cur;
			cur = cur.getRight();
		}

		// ends with cur pointing to rightmost node
		// & prev one level up, its parent
		if (tn==prev) {
			tn.setLeft(cur.getLeft());
		} else {
			prev.setRight(cur.getLeft());
		}

		return cur;
	}

	/* Prints out the tree from a given node, in order of:
	 * left, current, right
	 */
	public String inorderTraverse(TreeNode tn) {
		if (tn==null) {
			return "";
		}

		return inorderTraverse(tn.getLeft()) + " " + tn.getData()
					+ " " + inorderTraverse(tn.getRight());
	}  // end inorderTraverse()

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
		String result = inorderTraverse(root);

		return result;
	}

	public String toString2() {
		String result = preorderTraverse(root);

		return result;
	}

	public String toString3() {
		String result = postorderTraverse(root);

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
