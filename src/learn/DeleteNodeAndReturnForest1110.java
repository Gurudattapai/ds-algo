package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodeAndReturnForest1110 {

	public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

		List<TreeNode> returnList = new ArrayList<>();
		if (root == null) {
			return returnList;
		}

		if (to_delete == null || to_delete.length == 0) {
			returnList.add(root);
			return returnList;
		}

		Set<Integer> toDelete = new HashSet<>();
		for (int i : to_delete) {
			toDelete.add(i);
		}
		deleteNodes(root, toDelete, returnList);
		if (toDelete.contains(root.val)) {
			TreeNode left = root.left;
			TreeNode right = root.right;
			if (left != null) {
				returnList.add(left);
			}
			if (right != null) {
				returnList.add(right);
			}
			root.left = null;
			root.right = null;
		} else {
			returnList.add(root);
		}
		return returnList;
	}

	private static void deleteNodes(TreeNode root, Set<Integer> toDelete, List<TreeNode> returnList) {

		if (root == null) {
			return;
		}

		deleteNodes(root.left, toDelete, returnList);
		deleteNodes(root.right, toDelete, returnList);

		if (root.left != null && toDelete.contains(root.left.val)) {
			TreeNode left = root.left;
			root.left = null;
			TreeNode leftChild = left.left;
			TreeNode rightChild = left.right;
			left.left = null;
			left.right = null;
			if (leftChild != null) {
				returnList.add(leftChild);
			}
			if (rightChild != null) {
				returnList.add(rightChild);
			}
		}

		if (root.right != null && toDelete.contains(root.right.val)) {
			TreeNode right = root.right;
			root.right = null;
			TreeNode leftChild = right.left;
			TreeNode rightChild = right.right;
			right.left = null;
			right.right = null;
			if (leftChild != null) {
				returnList.add(leftChild);
			}
			if (rightChild != null) {
				returnList.add(rightChild);
			}
		}

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		List<TreeNode> forest = delNodes(root, new int[] { 3, 5 });
		System.out.println(forest);
	}

}
