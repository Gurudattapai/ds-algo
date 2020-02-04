package learn;

public class FlattenBinaryTreeToList114 {

	public static void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode r = flattenTree(root);
		System.out.println(r.val);
	}
	
	public static TreeNode flattenTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode right = root.right;
		TreeNode left = root.left;
		if (left == null && right == null) {
			return root;
		}
		TreeNode l = flattenTree(root.left);
		root.right = l;
		root.left = null;
		TreeNode r = flattenTree(root.right);
		l.right = r;
		return r;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		flatten(root);
	}

}
