package learn;

public class DecodeWays91 {
	
	public static int numDecodings(String s) {
		int [] dp = new int [s.length() + 1];
		
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= s.length(); i++) {
			int last = Integer.parseInt(s.substring(i-1, i));
			int lastTwo = Integer.parseInt(s.substring(i-2, i));
			
			if (last >= 1) {
				dp[i] += dp[i-1];
			}
			
			if (lastTwo >= 10 && lastTwo <= 26) {
				dp[i] += dp[i-2];
			}
		}
		
		return dp[dp.length - 1];
		
	}
	
	
	public static void main(String [] args) {
		System.out.println(numDecodings("226"));
	}

}
