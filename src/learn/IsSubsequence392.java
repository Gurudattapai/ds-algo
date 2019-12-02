package learn;

public class IsSubsequence392 {

	public static boolean isSubsequence(String s, String t) {
		/*if (s.length() == 0) {
			return true;
		}
		boolean [][] dp = new boolean [s.length()][t.length()];
		
		for (int col = 0; col < t.length(); col++) {
			if (col == 0) {
				dp[0][0] = s.charAt(0) == t.charAt(0) ? true : false;
			} else {
				dp[0][col] = dp[0][col-1] || s.charAt(0) == t.charAt(col);
			}
		}
		
		for (int row = 1; row < s.length(); row++) {
			dp[row][0] = false;
		}
		
		for (int row = 1; row < s.length(); row++) {
			for (int col = 1; col < t.length(); col++) {
				if (row > col) {
					dp[row][col] = false;
				} else {
					dp[row][col] = dp[row][col-1] || (dp[row-1][col] && s.charAt(row) == t.charAt(col));
				}
			}
		}
		return dp[s.length()-1][t.length()-1];*/
		int i = 0;
        int cursor = 0;
        while (i < s.length()) {
            cursor = t.indexOf(s.charAt(i++), cursor);
            if (cursor < 0) break;
            cursor++;
        }
        return i == s.length() && cursor >= 0;
	}

	public static void main(String[] args) {
		System.out.println(isSubsequence("abc", "ahbgdc"));
	}

}
