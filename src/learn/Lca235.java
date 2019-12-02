package learn;

import java.util.ArrayList;
import java.util.List;

import learn.obj.TreeNode;

public class Lca235 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		List<TreeNode> list1 = new ArrayList<>();
		getParents(root, p, list1);
		List<TreeNode> list2 = new ArrayList<>();
		getParents(root, q, list2);
		int i = list1.size() - 1;
		int j = list2.size() - 1;
		TreeNode parent = null;
		while(i >= 0 && j >= 0) {
			if (list1.get(i) != list2.get(j)) {
				break;
			}
			parent = list1.get(i);
			i--;
			j--;
		}
		return parent;
	}
	
	public boolean getParents(TreeNode root, TreeNode node, List<TreeNode> list) {
		if (root == null) {
			return false;
		}
		boolean found = getParents(root.left, node, list);
		if (!found) {
			found = getParents(root.right, node, list);
		}
		if (root == node) {
			found = true;
		}
		if (found) {
			list.add(root);
		}
		return found;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
	}

}
