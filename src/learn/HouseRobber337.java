package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import learn.obj.TreeNode;

public class HouseRobber337 {

	public static int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		/*int [] arr = new int [2];
		levelSum(root, 0, arr);
		if (arr[0] > arr[1]) {
			return arr[0];
		}
		return arr[1];*/
		List<Integer> list = new ArrayList<>();
		levelSum(root, 0, list);
		int [] dp = new int [list.size()];
		Arrays.fill(dp, -1);
		return Math.max(maxSum(0, dp, list), maxSum(1, dp, list));
	}
	
	public static int maxSum(int index, int [] dp, List<Integer> list) {
		if (index >= list.size()) {
			return 0;
		}
		if (dp[index] != -1) {
			return dp[index];
		}
		int max = 0;
		for (int i = index+2; i < list.size(); i++) {
			max = Math.max(max, maxSum(i, dp, list));
		}
		dp[index] = max + list.get(index);
		return dp[index];
	}
	
	public static void levelSum(TreeNode root, int level, List<Integer> list) {
		if (root == null) {
			return;
		}
		
		/*if (level % 2 == 0) {
			arr[0] = arr[0] + root.val;
		} else {
			arr[1] = arr[1] + root.val;
		}*/
		if (list.size() > level) {
			list.set(level, list.get(level) + root.val);
		} else {
			list.add(root.val);
		}
		levelSum(root.left, level+1, list);
		levelSum(root.right, level+1, list);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		//root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		//root.left.left.left = new TreeNode(3);
		System.out.println(rob(root));
	}

}
