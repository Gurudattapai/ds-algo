package learn;

import java.util.Arrays;

public class CherryPickUp741 {

	public static int cherryPickup(int[][] grid) {
		
		if (grid == null || grid.length == 0) {
			return 0;
		}
		
		int total = 0;
		int [][] dp = new int [grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		StringBuilder sbRight = new StringBuilder();
		StringBuilder sbDown = new StringBuilder();
		int right = dfs(grid, dp, 0, 1, sbRight);
		int down = dfs(grid, dp, 1, 0, sbDown);
		int firstPass = grid[0][0];
		String path = null;
		if (right == Integer.MIN_VALUE && down == Integer.MIN_VALUE) {
			return 0;
		}
		if (right < down) {
			firstPass += down;
			path = sbRight.toString();
		} else {
			firstPass += right;
			path = sbDown.toString();
		}
		clearPath(grid, path);
		total += firstPass;
		
		for (int i = 0; i < grid.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int left = dfsBack(grid, dp, grid.length-1, grid[0].length-2);
		int up = dfsBack(grid, dp, grid.length-2, grid[0].length-1);
		
		if (!(left == Integer.MIN_VALUE && up == Integer.MIN_VALUE)) {
			total += Math.max(left, up);
		}
		return total;
	}

	private static int dfsBack(int[][] grid, int[][] dp, int row, int col) {
		if (row < 0 || col < 0) {
			return Integer.MIN_VALUE;
		}
		if (row == 0 && col == 0) {
			dp[row][col] = grid[row][col];
			return dp[row][col];
		}
		
		if (dp[row][col] != -1) {
			return dp[row][col];
		}
		
		if (grid[row][col] == -1) {
			dp[row][col] = Integer.MIN_VALUE;
			return dp[row][col];
		}
		int up = 0;
		int left = 0;
		if (col == grid[0].length - 1) {
			left = dfsBack(grid, dp, row, col - 1);
		} else if (row == 0) {
			up = dfsBack(grid, dp, row-1, col);
		} else {
			left = dfsBack(grid, dp, row, col - 1);
			up = dfsBack(grid, dp, row-1, col);
		}
		dp[row][col] = grid[row][col] + Math.max(up, left);
		return dp[row][col];
	}

	private static void clearPath(int[][] grid, String path) {
		String [] pathArr = path.split("-");
		for (int i = 0; i < pathArr.length; i++) {
			if (pathArr[i] != "") {
				String [] a = pathArr[i].split(",");
				grid[Integer.valueOf(a[0])][Integer.valueOf(a[1])] = 0;
			}
		}
	}

	private static int dfs(int[][] grid, int[][] dp, int row, int col, StringBuilder sb) {
		if (row > grid.length - 1 || col > grid[0].length - 1) {
			return Integer.MIN_VALUE;
		}
		if (row == grid.length - 1 && col == grid[0].length - 1) {
			dp[row][col] = grid[row][col];
			return dp[row][col];
		}
		
		if (dp[row][col] != -1) {
			return dp[row][col];
		}
		
		if (grid[row][col] == -1) {
			dp[row][col] = Integer.MIN_VALUE;
			return dp[row][col];
		}
		
		int rightPath = 0;
		int downPath = 0;
		if (col == grid[0].length - 1) {
			rightPath = dfs(grid, dp, row, col + 1, sb);
		} else if (row == grid.length - 1) {
			downPath = dfs(grid, dp, row+1, col, sb);
		} else {
			rightPath = dfs(grid, dp, row, col + 1, sb);
			downPath = dfs(grid, dp, row+1, col, sb);
		}
		if (rightPath < downPath) {
			dp[row][col] = grid[row][col] + downPath;
			int righCol = col + 1;
			sb.append(row + "," + righCol + "-");
		} else {
			dp[row][col] = grid[row][col] + rightPath;
			int downRow = row + 1;
			sb.append(downRow + "," + col + "-");
		}
		return dp[row][col];
	}

	public static void main(String[] args) {
		int [][] arr = new int [3][3];
		arr[0] = new int [] {0,1,-1};
		arr[1] = new int [] {1,0,-1};
		arr[2] = new int [] {1,1,1};
		System.out.println(cherryPickup(arr));
	}

}
