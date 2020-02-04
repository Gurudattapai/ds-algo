package learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak139 {

	public static boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);
		Map<Integer, Boolean> dp = new HashMap<>();
		return wordBreak(s, dict, dp, 0);
	}
	
	public static boolean wordBreak(String s, Set<String> dict, Map<Integer, Boolean> dp, int index) {
		if (index >= s.length()) {
			return true;
		}
		if (dp.containsKey(index)) {
			return dp.get(index);
		}
		for (int i = index; i < s.length(); i++) {
			String sub = s.substring(index, i+1);
			if (dict.contains(sub)) {
				boolean canBeSentence = wordBreak(s, dict, dp, i+1);
				dp.put(index, canBeSentence);
				if (canBeSentence) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String s = "leetcode";
		List<String> list = new ArrayList<>();
		list.add("leet");
		list.add("code");
		//list.add("sand");
		//list.add("and");
		//list.add("cat");
		System.out.println(wordBreak(s, list));
	}

}
