package learn;

public class ABCSubSequence {

	public static int countAbcSequece(String s) {
		StringBuilder strBuilder = new StringBuilder(s);
		String pattern = "ABC";
		int index = 0;
		int count = 0;
		while (index != -1 && strBuilder.length() > 0) {
			int strIndex = strBuilder.toString().indexOf(pattern.charAt(index));
			if (strIndex == -1) {
				return count;
			} else {
				index++;
				strBuilder.delete(0, strIndex+1);
			}
			if (index > 2) {
				index = 0;
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countAbcSequece("BAC"));
	}

}
