package learn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class PreOrderTraversal144 {

	public static List<Integer> preorderTraversal(TreeNode root) {
		
		List<Integer> list = new LinkedList<>();
		if (root == null) {
			return list;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		Set<TreeNode> seen = new HashSet<>();
		
		stack.add(root);
		
		while (!stack.isEmpty()) {
			TreeNode current = stack.peek();
			boolean childProcessed = true;
			if (current.left != null && !seen.contains(current.left)) {
				childProcessed = false;
				stack.push(current.left);
			}
			if (current.right != null && !seen.contains(current.right)) {
				childProcessed = false;
				stack.push(current.right);
			}
			if (childProcessed) {
				stack.pop();
				seen.add(current);
				list.add(0, current.val);
			}	
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		System.out.println(preorderTraversal(root));
	}

}
