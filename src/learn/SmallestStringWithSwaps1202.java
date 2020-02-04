package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SmallestStringWithSwaps1202 {

	public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		
		if (s == null || s.length() == 0) {
			return "";
		}
		
		if (pairs == null || pairs.size() == 0) {
			return s;
		}
		
		Set<String> seen = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		seen.add(s);
		q.add(s);
		String smallest = s;
		while (!q.isEmpty()) {
			String current = q.poll();
			for (int i = 0; i < pairs.size(); i++) {
				String swappedString = swap(current, pairs.get(i).get(0), pairs.get(i).get(1));
				if (!seen.contains(swappedString)) {
					seen.add(swappedString);
					q.add(swappedString);
				}
				if (smallest.compareTo(swappedString) > 0) {
					smallest = swappedString;
				}
			}
		}
		return smallest;

	}
	
	public static String swap(String s, int index1, int index2) {
		char ch = s.charAt(index1);
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(index1, s.charAt(index2));
		sb.setCharAt(index2, ch);
		return sb.toString();
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(0);
		list1.add(3);
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		list.add(list1);
		list.add(list2);
		System.out.println(smallestStringWithSwaps("dcab", list));
	}

}
