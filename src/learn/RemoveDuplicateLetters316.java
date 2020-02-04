package learn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateLetters316 {

	public static String removeDuplicateLetters(String s) {
		
		if (s == null || s.length() == 0) {
			return "";
		}
		
		Set<Character> set = new HashSet<>();
		Set<String> uniqueStrings = new TreeSet<>();
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if (set.contains(current)) {
				if (uniqueStrings.isEmpty()) {
					uniqueStrings.add(string.toString());
				}
				Iterator<String> it = uniqueStrings.iterator();
				while (it.hasNext()) {
					String str = it.next();
					int index = str.indexOf(current);
					String result = str.substring(0, index) + str.substring(index + 1) + current;
					uniqueStrings.add(result);
				}
			} else {
				if (uniqueStrings.isEmpty()) {
					string.append(current);
				} else {
					Iterator<String> it = uniqueStrings.iterator();
					while (it.hasNext()) {
						String str = it.next();
						str += current;
						uniqueStrings.add(str);
						it.remove();
					}
				}
				set.add(current);
			}
		}
		if (uniqueStrings.isEmpty()) {
			return string.toString();
		}
		for (String str : uniqueStrings) {
			return str;
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcabc"));
	}

}
