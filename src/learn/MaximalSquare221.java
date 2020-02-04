package learn;

public class MaximalSquare221 {

	public static int maximalSquare(int[][] matrix) {
		
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int dp [][] = new int [rows][cols];
		
		int max = 0;
		for(int col = 0; col < cols; col++) {
			if (matrix[0][col] == 1) {
				dp [0][col] = 1;
				max = 1;
			}
		}
		
		for (int row = 0; row < rows; row++) {
			if (matrix[row][0] == 1) {
				dp [row][0] = 1;
				max = 1;
			}
		}
		
		for (int row = 1; row < rows; row++) {
			for (int col = 1; col < cols; col++) {
				if (matrix[row][col] == 1) {
					int current = Math.min(dp[row][col-1], Math.min(dp[row-1][col], dp[row-1][col-1])) + 1;
					dp [row][col] = current;
					max = Math.max(max, current);
				}
			}
		}
		return max * max;

	}

	public static void main(String[] args) {
		int [][] arr = new int [4][5];
		arr[0] = new int [] {1,0,1,0,0};
		arr[1] = new int [] {1,0,1,1,1};
		arr[2] = new int [] {1,1,1,1,1};
		arr[3] = new int [] {1,0,0,1,0};
		System.out.println(maximalSquare(arr));
	}

}
