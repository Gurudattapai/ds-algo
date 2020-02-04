package learn;

public class SumOfSubArrayMin907 {

	public static int sumSubarrayMins(int[] A) {
		
		int totalSum = 0;
		if (A == null || A.length == 0) {
			return totalSum;
		}
		
		int len = A.length;
		int prevMin = Integer.MAX_VALUE;
		for (int i = len - 1; i >= 0; i--) {
			prevMin = Math.min(prevMin, A[i]);
			totalSum += A[i];
			totalSum += (len - i - 1) * prevMin;
			totalSum = (int) (totalSum % (Math.pow(10, 9) + 7));
		}
		return totalSum;
		
		
		/*for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				if (i == j) {
					prevMin = A[j];
				} else {
					prevMin = Math.min(prevMin, A[j]);
				}
				totalSum += prevMin;
				totalSum = (int) (totalSum % (Math.pow(10, 9) + 7));
			}
		}
		return totalSum;*/
	}

	public static void main(String[] args) {
		System.out.println(sumSubarrayMins(new int [] {48,87,27}));
	}

}
