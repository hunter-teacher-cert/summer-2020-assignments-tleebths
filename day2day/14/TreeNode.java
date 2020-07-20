// for binary search tree
public class TreeNode {
	// Instance variables
	private int data;
	private TreeNode left;
	private TreeNode right;

	// Constructors
	public TreeNode() {
		this(0, null, null);
	}

	public TreeNode(int data) {
		this(data, null, null);
	}

	public TreeNode(int data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// getters & setters
	public int getData() {
		return data;
	}

	public void setData(int x) {
		data = x;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode n) {
		left = n;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode n) {
		right = n;
	}

}
