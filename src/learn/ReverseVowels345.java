package learn;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels345 {

	public static String reverseVowels(String s) {
		
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		
		if (s == null || s.isEmpty()) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder(s);
		StringBuilder vowelStringBuilder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				vowelStringBuilder.append(s.charAt(i));
			}
		}
		vowelStringBuilder.reverse();
		int index = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (set.contains(s.charAt(i))) {
				sb.deleteCharAt(i);
				sb.insert(i, vowelStringBuilder.charAt(index));
				index++;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(reverseVowels("leetcode"));
	}

}
