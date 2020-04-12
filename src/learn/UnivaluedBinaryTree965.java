package learn;

public class UnivaluedBinaryTree965 {

	public boolean isUnivalTree(TreeNode root) {
		
		if (root == null) {
			return true;
		}
		return isUni(root, root.val);
	}

	private boolean isUni(TreeNode root, int val) {
		if (root == null) {
			return true;
		}
		
		if (root.val != val) {
			return false;
		}
		
		return isUni(root.left, val) && isUni(root.right, val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
