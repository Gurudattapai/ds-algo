package learn;

import java.util.HashMap;
import java.util.Map;

public class LongestStringChain1048 {

	/*public int longestStrChain(String[] words) {
		
		if (words == null || words.length == 0) {
			return 0;
		}
		
		Map<Integer, Integer> chain = new HashMap<>();
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i+1; j < words.length; j++) {
				int chainLength = go(words, j, chain, words[i]);
			}
		}

	}

	private int go(String[] words, int index, Map<Integer, Integer> chain, String current) {		
		String wordAtIndex = words[index];
		boolean isChain = isChain(current, wordAtIndex);
		if (!isChain) {
			return 0;
		}
		
		if (chain.containsKey(index)) {
			return chain.get(index);
		}
		
		if (isChain && index == words.length - 1) {
			return 1;
		}
		
		int max = 0;
		for (int j = index + 1; j < words.length; j++) {
			int chainLength = go(words, j, chain, words[index]);
			max = Math.max(max, chainLength);
		}
		if (max > 0) {
			chain.put(index, max + 1);
		}
		return chain.get(index);
	}
	
	private boolean isChain(String word1, String word2) {
		if (Math.abs(word1.length() - word2.length()) != 1) {
			return false;
		}
		
		Map<Character, Integer> map = new HashMap<>();
		boolean word1Bigger = true;
		if (word1.length() < word2.length()) {
			word1Bigger = false;
		}
		
		if (word1Bigger) {
			for (int i = 0; i < word1.length(); i++) {
				map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0) + 1);
			}
			for (int i = 0; i < word2.length(); i++) {
				if (!map.containsKey(word2.charAt(i)))
			}
		} else {
			for (int i = 0; i < word2.length(); i++) {
				map.put(word2.charAt(i), map.getOrDefault(word2.charAt(i), 0) + 1);
			}
		}
		
		return true;
	}

	public static void main(String[] args) {

	}*/

}
