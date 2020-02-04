package learn;

public class SumOfEvenNumbersAfterQueries985 {

	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		
		int evenSum = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				evenSum += A[i];
			}
		}
		
		int [] evenSumArray = new int [queries.length];
		int start = 0;
		for (int i = 0; i < queries.length; i++) {
			int val = queries[i][0];
			int index = queries[i][1];
			boolean currentIndexEven = A[index] % 2 == 0;
			boolean evenAfterAdd = (A[index] + val) % 2 == 0;
			if (currentIndexEven && evenAfterAdd) {
				evenSumArray[start++] = evenSum + val;
				evenSum += val;
			} else if (!currentIndexEven && evenAfterAdd) {
				evenSumArray[start++] = evenSum + A[index] + val;
				evenSum += A[index] + val;
			} else if (currentIndexEven && !evenAfterAdd){
				evenSumArray[start++] = evenSum - A[index];
				evenSum -= A[index];
			} else {
                evenSumArray[start++] = evenSum;
            }
			A[index] = A[index] + val;
		}
		
		return evenSumArray;
	}

	public static void main(String[] args) {

	}

}
