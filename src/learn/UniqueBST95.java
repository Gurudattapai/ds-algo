package learn;

import java.util.ArrayList;
import java.util.List;

import learn.obj.TreeNode;

public class UniqueBST95 {

	public static List<TreeNode> generateTrees(int n) {
		List<TreeNode> returnList = new ArrayList<>();
		if (n == 1) {
			returnList.add(createTreeNode(1));
			return returnList;
		}
		
		int [] arr = new int [n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		
		for (int i = 0; i < n; i++) {
			List<TreeNode> left = generateTrees(arr, 0, i-1);
			List<TreeNode> right = generateTrees(arr, i+1, n-1);
			List<TreeNode> combinedList = addRoot(arr[i], left, right);
			if (combinedList != null) {
				returnList.addAll(combinedList);
			}
		}
		return returnList;
	}
	
	private static List<TreeNode> generateTrees(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		List<TreeNode> list = new ArrayList<>();
		if (start == end) {
			list.add(createTreeNode(arr[start]));
			return list;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = generateTrees(arr, start, i-1);
			List<TreeNode> right = generateTrees(arr, i+1, end);
			List<TreeNode> combinedList = addRoot(arr[i], left, right);
			if (combinedList != null) {
				list.addAll(combinedList);
			}
		}
		return list;
	}

	public static List<TreeNode> addRoot(int n, List<TreeNode> leftList, List<TreeNode> rightList) {
		List<TreeNode> list = null;
		if (leftList != null && rightList != null) {
			list = new ArrayList<>();
			for (TreeNode left : leftList) {
				for (TreeNode right : rightList) {
					TreeNode treeNode = createTreeNode(n);
					treeNode.left = left;
					treeNode.right = right;
					list.add(treeNode);
				}
			}
		}
		else if (leftList == null) {
			list = new ArrayList<>();
			for (TreeNode right : rightList) {
				TreeNode treeNode = createTreeNode(n);
				treeNode.right = right;
				list.add(treeNode);
			}
		}
		else if (rightList == null) {
			list = new ArrayList<>();
			for (TreeNode left : leftList) {
				TreeNode treeNode = createTreeNode(n);
				treeNode.left = left;
				list.add(treeNode);
			}
		}
		return list;
	}
	
	public static TreeNode createTreeNode(int n) {
		TreeNode treeNode = new TreeNode(n);
		return treeNode;
	}

	public static void main(String[] args) {
		List<TreeNode> list = generateTrees(1);
		System.out.println(list.size());
	}

}
