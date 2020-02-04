package learn;

public class FindNumbersWithEvenNumberOfDigits1295 {

	public int findNumbers(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int number = nums[i];
			int digit = (int) Math.floor(Math.log10(number)) + 1;
			if (digit % 2 == 0) {
				count += 1;
			}
		}
		
		return count;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
