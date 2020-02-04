package learn;

public class FindNUniqueIntegers1304 {

	public int[] sumZero(int n) {
		
		if (n == 1) {
			return new int[] { 0 };
		}

		int[] arr = new int[n];
		int index = 0;
		if (n % 2 != 0) {
			arr[0] = 0;
			index = 1;
		}
		int num = 1;
		while (index <= n - 1) {
			arr[index++] = num;
			arr[index++] = -num;
			num++;
		}
		return arr;
	}

	public static void main(String[] args) {

	}

}
