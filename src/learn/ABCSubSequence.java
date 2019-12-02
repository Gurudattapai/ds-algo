package learn;

public class ABCSubSequence {

	public static int countAbcSequece(String s) {
		String pattern = "ABC";
		return count(s, pattern);
	}

	public static int count(String s, String pattern) {
		if (s.length() <= 0 && pattern.length() > 0) {
			return 0;
		}
		if (pattern.length() <= 0 && s.length() > 0) {
			return 1;
		}
		if (pattern.length() == 1 && s.length() == 1) {
			return 1;
		}
		if (pattern.length() == 1 && s.length() > 1) {
			
			//TODO
		}
		int index = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == pattern.charAt(index)) {
				count += count(s.substring(i + 1), pattern.substring(index + 1)) + count(s.substring(i + 1), pattern);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countAbcSequece("ABCABC"));
	}

}
