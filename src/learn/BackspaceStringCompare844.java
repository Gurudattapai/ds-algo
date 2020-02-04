package learn;

public class BackspaceStringCompare844 {

	public static boolean backspaceCompare(String S, String T) {
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		
		int min = Math.min(S.length(), T.length());
		
		for (int i = 0; i < min; i++) {
			if (S.charAt(i) != '#') {
				s1.append(S.charAt(i));
			} else {
				if (s1.length() > 0)
				s1.deleteCharAt(s1.length() - 1);
			}
			if (T.charAt(i) != '#') {
				s2.append(T.charAt(i));
			} else {
				if (s2.length() > 0)
				s2.deleteCharAt(s2.length() - 1);
			}
		}
		
		if (S.length() > T.length()) {
			for (int i = min; i < S.length(); i++) {
				if (S.charAt(i) != '#') {
					s1.append(S.charAt(i));
				} else {
					if (s1.length() > 0)
					s1.deleteCharAt(s1.length() - 1);
				}
			}
		} else {
			for (int i = min; i < T.length(); i++) {
				if (T.charAt(i) != '#') {
					s2.append(T.charAt(i));
				} else {
					if (s2.length() > 0)
					s2.deleteCharAt(s2.length() - 1);
				}
			}
		}
		return s1.toString().equals(s2.toString());

	}
	
	public static void main(String[] args) {
		System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p"));
	}

}
