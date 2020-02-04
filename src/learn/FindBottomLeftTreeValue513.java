package learn;

import java.util.ArrayList;
import java.util.List;

public class FindBottomLeftTreeValue513 {

	public static int findBottomLeftValue(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		
		if (root.left == null && root.right == null) {
			return root.val;
		}
		
		List<List<Integer>> list = new ArrayList<>();
		traverse(root, list, 1);
		return list.get(list.size() - 1).get(0);

	}

	private static void traverse(TreeNode root, List<List<Integer>> list, int level) {
		
		if (root == null) {
			return;
		}
		
		if (list.size() < level) {
			list.add(new ArrayList<Integer>());
		}
		list.get(level - 1).add(root.val);
		traverse(root.left, list, level+1);
		traverse(root.right, list, level+1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		System.out.println(findBottomLeftValue(root));
	}

}
