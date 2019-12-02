package learn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder127 {
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		
		if (beginWord == endWord) {
			return 0;
		}
		Queue<String> q = new LinkedList<>();
		
		int count = 0;
		
		q.add(beginWord);
		q.add(null);
		Set<String> visited = new HashSet<>();
		
		while(!q.isEmpty()) {
			String word = q.poll();
			if (word == endWord) {
				return count+1;
			}
			if (word == null && q.isEmpty()) {
					return 0;
			}
			if (word == null) {
				q.add(null);
				count++;
				continue;
			}
			for (int i = 0; i < wordList.size(); i++) {
				String w = wordList.get(i);
				if (!visited.contains(w)) {
					int diff = checkDifference(word, w);
					if (diff == 1) {
						q.add(w);
						visited.add(w);
					}
				}
			}
			//count++;
		}
        return 0;
    }

	private static int checkDifference(String word, String w) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < word.length(); i++) {
			set.add(word.charAt(i));
		}
		for (int i = 0; i < w.length(); i++) {
			set.remove(w.charAt(i));
		}
		return set.size();
	}

	public static void main(String[] args) {
		String [] arr = new String [] {"hot","dot","dog","lot","log","cog"};
		List<String> wordList = Arrays.asList(arr);
		System.out.println(ladderLength("hit", "cog", wordList));
	}

}
