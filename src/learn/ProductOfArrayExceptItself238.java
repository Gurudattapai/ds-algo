package learn;

import java.util.Arrays;

public class ProductOfArrayExceptItself238 {

	public static int[] productExceptSelf(int[] nums) {
		
		if (nums == null || nums.length == 0) {
			return new int [0];
		}
		
		int len = nums.length;
		int [] leftArray = new int [len];
		int [] rightArray = new int [len];
		
		leftArray[0] = 1;
		for (int i = 1; i < len; i++) {
			leftArray[i] = leftArray[i-1] * nums[i-1];
		}
		rightArray[len-1] = 1;
		for (int i = len-2; i >=0; i--) {
			rightArray[i] = rightArray[i+1] * nums[i+1];
		}

		int [] productArr = new int [len];
		for (int i = 0; i < len; i++) {
			productArr[i] = leftArray[i] * rightArray[i];
		}
		return productArr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int [] {1,2,3,4})));
	}

}
