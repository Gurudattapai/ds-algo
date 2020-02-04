package learn;

public class ValidPalindrome680 {

	public static boolean validPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		if (isPalindrome(s)) {
			return true;
		}

		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return isPalindrome(s.substring(0, i) + s.substring(i + 1))
						|| isPalindrome(s.substring(0, j) + s.substring(j + 1));
			}
			i++;
			j--;
		}
		return true;
	}

	public static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(validPalindrome("cbbcc"));
	}

}
