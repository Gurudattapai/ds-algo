package learn;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SumOfDeepestLeaves1302 {

	public static int deepestLeavesSum(TreeNode root) {

		if (root == null) {
			return 0;
		}

		Map<Integer, List<Integer>> map = new LinkedHashMap<>();
		traverse(root, map, 0);
		int sum = 0;
		Integer lastKey = 0;
		for (Integer key : map.keySet()) {
			lastKey = key;
		}
		List<Integer> list = map.get(lastKey);
		for (int i : list) {
			sum += i;
		}
		return sum;
	}

	private static void traverse(TreeNode root, Map<Integer, List<Integer>> map, int level) {
		if (root == null) {
			return;
		}
		
		if (!map.containsKey(level)) {
			map.put(level, new ArrayList<>());
			//map.remove(level - 1);
		}
		map.get(level).add(root.val);
		traverse(root.left, map, level + 1);
		traverse(root.right, map, level + 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(9);
		System.out.println(deepestLeavesSum(root));
	}

}
