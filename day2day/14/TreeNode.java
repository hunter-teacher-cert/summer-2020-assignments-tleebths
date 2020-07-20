// for binary search tree
public class TreeNode {
	// Instance variables
	private String data;
	private TreeNode ch1;
	private TreeNode ch2;

	// Constructors
	public TreeNode() {
		this("", null, null);
	}

	public TreeNode(String data) {
		this(data, null, null);
	}

	public TreeNode(String data, TreeNode ch1, TreeNode ch2) {
		this.data = data;
		this.ch1 = ch1;
		this.ch2 = ch2;
	}

	public String getData() {
		return data;
	}

	public void setData(String s) {
		data = s;
	}

	public TreeNode getCh1() {
		return ch1;
	}

	public void setCh1(TreeNode tn) {
		ch1 = tn;
	}

	public TreeNode getCh2() {
		return ch2;
	}

	public void setCh2(TreeNode tn) {
		ch2 = tn;
	}

}
