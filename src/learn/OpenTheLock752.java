package learn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock752 {

	public static int openLock(String[] deadends, String target) {
		Set<String> dead_ends = new HashSet<>(Arrays.asList(deadends));
		
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		
		queue.add("0000");
		queue.add(null);
		int level = 0;
		while (!queue.isEmpty()) {
			String currentPos = queue.poll();
			
			if (currentPos == null) {
				level++;
				if (queue.isEmpty()) {
					break;
				}
				queue.add(null);
				continue;
			}
			visited.add(currentPos);
			
			if (dead_ends.contains(currentPos)) {
				continue;
			}
			
			
			if (currentPos.equals(target)) {
				return level;
			}
			
			StringBuilder sb = new StringBuilder(currentPos);
			for (int i = 0; i < 4; i++) {
				char currentChar = sb.charAt(i);
				String s1 = sb.substring(0, i) + (currentChar == '9' ? 0 : currentChar - '0' + 1)
						+ sb.substring(i + 1);
				String s2 = sb.substring(0, i) + (currentChar == '0' ? 9 : currentChar - '0' - 1)
						+ sb.substring(i + 1);
				if (!visited.contains(s1) && !dead_ends.contains(s1)) {
					queue.add(s1);
					visited.add(s1);
				}
				if (!visited.contains(s2) && !dead_ends.contains(s2)) {
					queue.add(s2);
					visited.add(s2);
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(openLock(new String [] {"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
	}

}
