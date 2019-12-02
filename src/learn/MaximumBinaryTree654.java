package learn;

public class MaximumBinaryTree654 {

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return construct(nums, 0, nums.length - 1);
	}
	
	public TreeNode construct(int [] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end) {
			return new TreeNode(nums[start]);
		}
		
		int max = nums[start];
		int index = start;
		for (int i = start+1; i <= end; i++) {
			if (max < nums[i]) {
				max = nums[i];
				index = i;
			}
		}
		TreeNode root = new TreeNode(nums[index]);
		root.left = construct(nums, start, index - 1);
		root.right = construct(nums, index+1, end);
		return root;
	}

	public static void main(String[] args) {

	}

}
