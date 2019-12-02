package learn;

import java.util.Arrays;

public class UniqueBst96 {
	
	public static int numTrees(int n) {
		if (n == 1) {
			return 1;
		}
        int [] dp = new int [n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 2;
        /*int [] arr = new int [n];
        for (int i = 0; i < n; i++) {
        	arr[i] = i+1;
        }*/
        int count= 0;
        for (int i = 0; i < n; i++) {
        	int subCount = 0;
			int left = countSub(0, i-1, dp);
			left = left == -1 ? 0 : left == 0 ? 1 : left;
			int right = countSub(i+1, n-1, dp);
			right = right == -1 ? 0 : right == 0 ? 1 : right;
			if (left == right) {
				subCount = left * right;
			} else {
				subCount = left * right;
			}
			count += subCount == 0 ? 1 : subCount;
        }
        return count;
    }

	private static int countSub(int start, int end, int[] dp) {
		if (start > end) {
			return 0;
		}
		
		int len = end - start + 1;
		if (dp[len] != -1) {
			return dp[len];
		}
		
		int count = 0;
		for (int i = start; i <= end; i++) {
			int subCount = 0;
			int left = countSub(start, i-1, dp);
			left = left == -1 ? 0 : left == 0 ? 1 : left;
			int right = countSub(i+1, end, dp);
			right = right == -1 ? 0 : right == 0 ? 1 : right;
			if (left == right) {
				subCount = left * right;
			} else {
				subCount = left * right;
			}
			count += subCount == 0 ? 1 : subCount;
		}
		dp [len] = count;
		
		return dp[len];
	}

	public static void main(String[] args) {
		System.out.print(numTrees(7));

	}

}
