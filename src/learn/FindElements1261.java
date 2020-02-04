package learn;

import java.util.Arrays;

public class FindElements1261 {
	
	
	int [] arr;

	public FindElements1261(TreeNode root) {
        
		int height = 0;
		if (root != null) {
			height = getHeightOfTree(root);
		}
        if (height != 0) {
        	arr = new int[(int)Math.pow(2, (height + 1)) - 1];
        } else {
        	arr = new int [0];
        }
        Arrays.fill(arr, -1);
        arr[0] = 0;
        fillArray(arr, 1, root.left);
        fillArray(arr, 2, root.right);
    }

	private void fillArray(int[] arr, int pos, TreeNode root) {
		if (root == null) {
			return;
		}
		
		if (pos < 0 || pos >= arr.length) {
			return;
		}
		
		if (root != null) {
			arr[pos] = pos;
		}
		fillArray(arr, (pos * 2) + 1, root.left);
        fillArray(arr, (pos * 2) + 2, root.right);			
	}

	public boolean find(int target) {
		
		if (target >= arr.length) {
			return false;
		}
		
		return arr[target] != -1;

	}
	
	public int getHeightOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = getHeightOfTree(root.left);
		int rightHeight = getHeightOfTree(root.right);
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
