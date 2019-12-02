package learn;

public class RemoveKDigits402 {

	public static String removeKdigits(String num, int k) {
		/*if (num.length() == k) {
			return "0";
		}
		if (k == 0) {
			return num;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < num.length(); i++) {
			min = Math.min(getMin(num.substring(0, i) + num.substring(i + 1), k-1), min);
		}
		return min + "";*/
		
		if (num.length() == k)
            return "0";

        StringBuilder sb = new StringBuilder(num);
        for (int j = 0; j < k; j++) {
            int i = 0;
            while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            sb.delete(i, i + 1);
        }

        //remove leading 0's
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.delete(0, 1);

        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
	}

	private static int getMin(String string, int k) {
		if (k == 0) {
			return Integer.parseInt(string);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < string.length(); i++) {
			min = Math.min(getMin(string.substring(0, i) + string.substring(i + 1), k-1), min);
		}
		return min;
	}

	public static void main(String[] args) {
		System.out.println(removeKdigits("1432219", 3));
	}

}
