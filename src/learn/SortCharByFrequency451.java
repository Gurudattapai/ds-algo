package learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortCharByFrequency451 {

	public static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		List<Map.Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(map.entrySet());
		Collections.sort(list, (a, b) -> a.getValue() - b.getValue());
		StringBuilder sb = new StringBuilder();
		for (int i = list.size() - 1; i >= 0; i--) {
			for (int j = 0; j < list.get(i).getValue(); j++) {
				sb.append(list.get(i).getKey());
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
	}

}
