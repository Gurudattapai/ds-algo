package learn;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthBinaryTree662 {

	public static int widthOfBinaryTree(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		
		if (root.left == null && root.right == null) {
			return 1;
		}
		
		List<List<Integer>> list = new ArrayList<>();
		traverse(root, list, 1);
		int max = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			List<Integer> current = list.get(i);
			for (int j = current.size() - 1; j >= 0; j--) {
				if (current.get(j) != null) {
					max = Math.max(max, j+1);
					break;
				}
			}
			if (i > 0 && max >= (i * 2)) {
				break;
			}
		}
		return max;

	}

	private static void traverse(TreeNode root, List<List<Integer>> list, int level) {
		if (root == null) {
			if (list.size() >= level) {
				list.get(level - 1).add(null);
			}
			return;
		}
		
		if (list.size() < level) {
			list.add(new ArrayList<Integer>());
		}
		list.get(level - 1).add(root.val);
		traverse(root.left, list, level + 1);
		traverse(root.right, list, level + 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(9);
		//root.right.left.left = new TreeNode();
		System.out.println(widthOfBinaryTree(root));
	}

}
