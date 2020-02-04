package learn;

public class MaximumLengthRepeatedSubArray718 {

	public static int findLength(int[] A, int[] B) {
		
		if (A == null || A.length == 0 || B == null || B.length == 0) {
			return 0;
		}
		
		int [][] dp = new int [A.length][B.length];
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (A[i] == B[j]) {
					if (i > 0 && j > 0) {
						dp[i][j] = 1 + dp[i-1][j-1];
					} else {
						dp[i][j] = 1;
					}
				} else {
					if (i > 0 && j > 0) {
						dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
					} else if (i > 0 && j == 0){
						dp[i][j] = dp[i-1][j];
					} else if (j > 0 && i == 0){
						dp[i][j] = dp[i][j-1];
					}
				}
			}
		}
		return dp[dp.length-1][dp[0].length - 1];
	}

	public static void main(String[] args) {
		System.out.println(findLength(new int [] {1,2,3,2,1}, new int [] {3,2,1,4,7}));
	}

}
