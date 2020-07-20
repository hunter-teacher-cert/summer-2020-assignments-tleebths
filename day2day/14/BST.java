// Binary Search Tree
public class BST {
	// object attributes
	private TreeNode root;

	public BST() {
		root = null;
	}

	public BST(int data) {
		root = new TreeNode(data);
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

			
	}  // end seed()
}
