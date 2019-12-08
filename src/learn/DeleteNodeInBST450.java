package learn;

public class DeleteNodeInBST450 {

	public static TreeNode deleteNode(TreeNode root, int key) {
		return delete(root, key);

	}

	public static TreeNode delete(TreeNode root, int key) {
		if (root == null) {
			return null;
		}

		if (root.val == key) {
			if (root.left == null && root.right == null) {
				return null;
			}
			if (root.left != null && root.right == null) {
				return root.left;
			}
			if (root.right != null && root.left == null) {
				return root.right;
			}
			TreeNode leftMost = getInorderSuccessor(root.right);
			if (leftMost == root.right) {
				root.right = leftMost.right;
			}
			root.val = leftMost.val;
			return root;
		}
		root.left = delete(root.left, key);
		root.right = delete(root.right, key);
		return root;
	}

	private static TreeNode getInorderSuccessor(TreeNode root) {
		if (root.left == null && root.right == null) {
			return root;
		}
		if (root.left != null) {
			TreeNode node = getInorderSuccessor(root.left);
			if (root.left == node) {
				if (node.left == null && node.right == null) {
					root.left = null;
					return node;
				} else {
					root.left = node.right;
					return node;
				}
			}
			return node;
		} else {
			return root;
		}

		/*
		 * if (root.left == null && root.right == null) { return root; } TreeNode left =
		 * getLeftMost(root.left); if (root.left == left) { root.left = null; } return
		 * left;
		 */
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);
		System.out.println(deleteNode(root, 5));
	}

}
