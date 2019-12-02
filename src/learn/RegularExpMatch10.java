package learn;

public class RegularExpMatch10 {

	public static boolean isMatch(String s, String p) {
		
		if (p.length() == 0 && s.length() == 0) {
			return true;
		}
		
		if ((p.length() == 0 && s.length() != 0) || (p.length() != 0 && s.length() == 0)) {
			return false;
		}
		if (p.equals(".")) {
			return s.length() == 1;
		}
		if (p.equals("*") || p.equals(".*")) {
			return true;
		}
		if (p.length() == 1) {
			return s.equals(p);
		}
		
		int sIndex = 0;
		int pIndex = 0;
		
		if (p.charAt(pIndex) != '.' && p.charAt(pIndex) != '*') {
			if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
				while (sIndex < s.length() && s.charAt(sIndex) == p.charAt(pIndex)) {
					sIndex++;
				}
				pIndex = pIndex+2;
				return isMatch(s.substring(sIndex), p.substring(pIndex));
			} else {
				if (s.charAt(sIndex) != p.charAt(pIndex)) {
					return false;
				} else {
					return isMatch(s.substring(sIndex+1), p.substring(pIndex+1));
				}
			}
		} else if (p.charAt(pIndex) == '.') {
			if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
				pIndex = pIndex + 2;
				boolean isMatch = false;
				while (!isMatch && sIndex < s.length()) {
					while (sIndex < s.length() && s.charAt(sIndex) != p.charAt(pIndex)) {
						sIndex++;
					}
					isMatch = isMatch(s.substring(sIndex), p.substring(pIndex));
					sIndex++;
				}
				return isMatch;
			}
			return isMatch(s.substring(sIndex+1), p.substring(pIndex+1));
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aaa", "a*a"));
	}

}
