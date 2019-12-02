package learn;

public class CountNumberOfUniqueDigits357 {

	public static int countNumbersWithUniqueDigits(int n) {
		StringBuilder str = new StringBuilder();
		
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 10;
		}
		int [] arr = new int [n+1];
		arr[0] = 1;
		arr[1] = 10;
		for (int i = 2; i <= n; i++) {
			int count = 9;
			int j = 0;
			while (j < i - 1) {
				count *= (9-j);
				j++;
			}
			arr[i] = arr[i-1] + count;
		}
		return arr[n];
	}

	public static void main(String[] args) {
		System.out.println(countNumbersWithUniqueDigits(1));
	}

}
