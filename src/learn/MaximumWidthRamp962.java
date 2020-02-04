package learn;

public class MaximumWidthRamp962 {

	public static int maxWidthRamp(int[] A) {
		
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int left = 0;
		int right = A.length - 1;
		int max = 0;
		while (left <= A.length - 2) {
			while (left < right) {
				if (A[left] <= A[right]) {
					max = Math.max(max, right - left);
					break;
				}
				right--;
			}
			left++;
			right = A.length - 1;
			if (right - left < max) {
				break;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxWidthRamp(new int [] {9,8,1,0,1,9,4,0,4,1}));
	}

}
