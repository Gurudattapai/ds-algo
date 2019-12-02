package learn;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubString5 {
	public static String longestPalindrome(String s) {

		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			checkLong(s.substring(0, i + 1), map);
		}
		return map.get(s);
	}

	private static String checkLong(String string, Map<String, String> map) {
		if (map.get(string) != null) {
			return map.get(string);
		}

		if (string.length() == 0) {
			map.put(string, "");
			return "";
		}
		if (string.length() == 1) {
			map.put(string, string);
			return string;
		}

		if (checkPalindrome(string)) {
			map.put(string, string);
			return string;
		}

		int len = string.length();
		String first = checkLong(string.substring(0, len - 1), map);
		String sec = checkLong(string.substring(1, len), map);
		if (first.length() >= sec.length()) {
			map.put(string, first);
			return first;
		} else {
			map.put(string, sec);
			return sec;
		}

	}

	private static boolean checkPalindrome(String string) {
		int left = 0;
		int right = string.length() - 1;
		while (left <= right) {
			if (string.charAt(left) != string.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}

}
