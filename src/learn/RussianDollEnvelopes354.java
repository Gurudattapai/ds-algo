package learn;

import java.util.Arrays;

public class RussianDollEnvelopes354 {

	public static int maxEnvelopes(int[][] envelopes) {
		
		if(envelopes == null || envelopes.length == 0) {
			return 0;
		}
		
		int l = envelopes.length;
		int [] dp = new int [l];
		int len = 0;
		Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
		
		for (int [] arr : envelopes) {
			int index = Arrays.binarySearch(dp, 0, len, arr[1]);
			
			if (index < 0) {
				index = -(index + 1);
			}
			
			dp[index] = arr[1];
			if (index == len) {
				len++;
			}
			
		}
		return len;
	}

	public static void main(String[] args) {
		int [][] arr = new int[5][2];
		arr[0] = new int [] {4,5};
		arr[1] = new int [] {4,6};
		arr[2] = new int [] {6,7};
		arr[3] = new int [] {2,3};
		arr[4] = new int [] {1,1};
		System.out.println(maxEnvelopes(arr));
	}

}
