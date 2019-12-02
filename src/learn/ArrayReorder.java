package learn;

/**
 * Class to reorder an array in such a way that all 0s are moved towards the
 * beginning of the array and the rest of the elements are moved towards the
 * end by maintaining their relative order.
 */
public class ArrayReorder {

	public static void main(String[] args) {
		
		int[] arr1 = { 0, 0, 1, 3, 0, 4, 0, 0, 0 };
		reorderArray(arr1);
		printResult(arr1);

		int[] arr2 = { 0, 0, 0 };
		reorderArray(arr2);
		printResult(arr2);

		int[] arr3 = { 0 };
		reorderArray(arr3);
		printResult(arr3);

		int[] arr4 = { 1, 2, 3, 4, 5 };
		reorderArray(arr4);
		printResult(arr4);

		int[] arr5 = { 1 };
		reorderArray(arr5);
		printResult(arr5);

		int[] arr6 = {};
		reorderArray(arr6);
		printResult(arr6);
		
		int[] arr7 = { 1, 0, 10, 0, 0, 5, 0, 2, 3, 4, 5, 0 };
		reorderArray(arr7);
		printResult(arr7);
	}

	private static void reorderArray(int[] arr) {
		if (arr.length <= 1) {
			return;
		}
		int firstNonZeroPointer = arr.length - 1; // Will keep record of the
													// location of 0 to be
													// swapped at the end of the
													// array.
		int reverseScanningPointer = arr.length - 2; // Will scan in reverse for
														// any non-zero elements
														// to be swapped by 0
														// from the end.

		while (reverseScanningPointer >= 0) {
			if (arr[firstNonZeroPointer] == 0 && arr[reverseScanningPointer] != 0) {
				swap(arr, firstNonZeroPointer, reverseScanningPointer);
				firstNonZeroPointer--;
			}
			reverseScanningPointer--;
		}
	}

	private static void swap(int[] arr, int pointer1, int pointer2) {
		int temp = arr[pointer1];
		arr[pointer1] = arr[pointer2];
		arr[pointer2] = temp;
	}

	private static void printResult(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " | ");
		}
		System.out.println();
	}
}
