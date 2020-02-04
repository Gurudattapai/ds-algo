package learn;

public class DistributeCoins979 {

	public int distributeCoins(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		int [] moves = new int [1];
		distribute(root, moves);
		return moves[0];
	}
	
	public int distribute(TreeNode root, int [] moves) {
		if (root == null) {
			return 0;
		}
		int left = distribute(root.left, moves);
		int right = distribute(root.right, moves);
		int sum = left + right;
		int total = sum + root.val;
		if (total > 1) {
			moves[0] = moves[0] + total - 1;
			return total - 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		
	}

}
