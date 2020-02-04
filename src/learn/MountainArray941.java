package learn;

public class MountainArray941 {

	public static boolean validMountainArray(int[] A) {
		
		if (A == null || A.length < 3) {
			return false;
		}
		
		boolean inc = true;
		boolean allInc = true;
		boolean alldec = true;
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[i-1]) {
				return false;
			}
			if (inc && A[i] > A[i-1]) {
				alldec = false;
				continue;
			}
			if (A[i] <= A[i-1] && inc) {
				inc = false;
				allInc = false;
				continue;
			}
			if (inc && A[i] < A[i-1]) {
				return false;
			}
			if (!inc && A[i] > A[i-1]) {
				return false;
			}
		}
		return !allInc && !alldec;

	}

	public static void main(String[] args) {
		System.out.println(validMountainArray(new int [] {9,8,7,6,5,4,3,2,1,0}));
	}

}
