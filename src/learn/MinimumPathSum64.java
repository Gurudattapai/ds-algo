package learn;

import java.util.Arrays;

public class MinimumPathSum64 {

	public static int minPathSum(int[][] grid) {
		
		int n = grid.length;
		int m = grid[0].length;
		if (n == 1 && m == 1) {
            return grid[0][0];
        } 
		int [][] dp = new int [n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}	
		if (n == 1) {
			return grid[0][0] + getPathSum(grid, dp, 0, 1);
		}
		if (m == 1) {
			return grid[0][0] + getPathSum(grid, dp, 1, 0);
		}
		return grid[0][0] + Math.min(getPathSum(grid, dp, 0, 1), getPathSum(grid, dp, 1, 0));
	}

	private static int getPathSum(int[][] grid, int[][] dp, int i, int j) {
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			dp[i][j] = grid[i][j];
			return dp[i][j];
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		if (i < grid.length - 1 && j < grid[0].length - 1) {
			dp[i][j] = grid[i][j] + Math.min(getPathSum(grid, dp, i, j+1), getPathSum(grid, dp, i+1, j));
			return dp[i][j];
		}
		if (i == grid.length - 1) {
			dp[i][j] = grid[i][j] + getPathSum(grid, dp, i, j+1);
			return dp[i][j];
		}
		if (j == grid[0].length - 1) {
			dp[i][j] = grid[i][j] + getPathSum(grid, dp, i+1, j);
			return dp[i][j];
		}
		return 999;
	}

	public static void main(String[] args) {
		int [][] arr = new int [1][4];
		for (int i = 0; i < 1; i++) {
			if (i == 0) {
				arr[i] = new int [] {9,1,4,8};
			}
			if (i == 1) {
				arr[i] = new int [] {1,5,1};
			}
			if (i == 2) {
				arr[i] = new int [] {4,2,1};
			}
		}
		System.out.println(minPathSum(arr));
	}
}
