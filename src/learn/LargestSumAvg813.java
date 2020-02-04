package learn;

import java.util.HashMap;
import java.util.Map;

public class LargestSumAvg813 {

	public static double largestSumOfAverages(int[] A, int K) {
		
		if (A == null || A.length < K) {
			return 0.0;
		}
		Map<String, Double> dp = new HashMap<>();
		return getMaxAvg(A, 0, K, dp);

	}

	private static double getMaxAvg(int[] a, int index, int k, Map<String, Double> dp) {
		if (index >= a.length) {
			return 0;
		}
		String key = index + "-" + k;
		if (dp.containsKey(key)) {
			return dp.get(key);
		}
		if (k == 1) {
			double total = 0;
			for (int i = index; i < a.length; i++) {
				total += (double)a[i];
			}
			double avg = total / (a.length - index);
			dp.put(key, avg);
			return avg;
		}
		double total = 0;
		double prevTotal = 0;
		for (int i = index; i < a.length; i++) {
			prevTotal += (double)a[i];
			double avg = getMaxAvg(a, i+1, k-1, dp);
			total = Math.max(total, (prevTotal / (i+1-index)) + avg);
		}
		dp.put(key, total);
		return total;
	}

	public static void main(String[] args) {
		System.out.println(largestSumOfAverages(new int [] {9,1,2,3,9}, 3));
	}

}
