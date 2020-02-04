package learn;

public class DecodedIndexAtIndex880 {

	public static String decodeAtIndex(String S, int K) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (!Character.isDigit(S.charAt(i))) {
				sb.append(S.charAt(i));
			} else {
				int index = 1;
				int digit = S.charAt(i) - '0';
				String initialString = sb.toString();
				while(index <= digit - 1) {
					sb.append(initialString);
					index++;
				}
			}
			if (sb.length() >= K) {
				break;
			}
		}
		return sb.charAt(K - 1) + "";
	}

	public static void main(String[] args) {
		System.out.println(decodeAtIndex("a2b3c4d5e6f7g8h9", 10));
	}

}
