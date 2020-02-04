package learn;

import java.util.Arrays;

public class CountingBits338 {

	public static int[] countBits(int num) {
		
		int [] arr = new int [num + 1];
		arr[0] = 0;
		if (num > 0) {
			arr[1] = 1;
			arr[2] = 1;
		}
		
		int last2Power = 2;
		for (int i = 3; i <= num; i++) {
			if ((i&(i-1)) == 0) {
				arr[i] = 1;
				last2Power = i;
			} else {
				arr[i] = arr[last2Power] + arr[i-last2Power];
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(0)));
	}

}
