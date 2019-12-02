package learn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {

	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		return wordBreak(s, dict);
	}
	
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s.length() == 0) {
			return true;
		}
		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(0, i+1);
			if (dict.contains(sub)) {
				boolean canBeSentence = wordBreak(s.substring(i+1), dict);
				if (canBeSentence) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String s = "catsandog";
		List<String> list = new ArrayList<>();
		list.add("cats");
		list.add("dog");
		list.add("sand");
		list.add("and");
		list.add("cat");
		System.out.println(wordBreak(s, list));
	}

}
