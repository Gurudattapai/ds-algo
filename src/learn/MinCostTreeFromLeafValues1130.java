package learn;

public class MinCostTreeFromLeafValues1130 {

	public int mctFromLeafValues(int[] arr) {

		if (arr == null || arr.length == 0) {
			return 0;
		}
		return 0;

	}

	public int getMaxAndUpdateSum(int[] arr, int start, int end, int[] min) {

		if (start > end) {
			return 1;
		}

		if (start == end) {
			return arr[start];
		}

		if (end - start == 2) {
			int mid = (start + end) / 2;
			int combineWithLeft = (arr[start] * arr[mid]) + (Math.max(arr[start], arr[mid]) * arr[end]);
			int combineWithRight = (arr[end] * arr[mid]) + (Math.max(arr[end], arr[mid]) * arr[start]);
			min[0] = min[0] + Math.min(combineWithLeft, combineWithRight);
			return Math.max(start, Math.max(mid, end));
		}

		if (end - start == 1) {
			min[0] = min[0] + (arr[end] * arr[start]);
			return Math.max(arr[end], arr[start]);
		}
		
		int mid = (start + end) / 2;
		//if ()
		int getLeftMax = getMaxAndUpdateSum(arr, start, mid, min);
		int getRightMax = getMaxAndUpdateSum(arr, start, mid, min);
		return 0;
	}

	public static void main(String[] args) {

	}

}
