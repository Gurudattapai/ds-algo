package learn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequentWords692 {

	public static List<String> topKFrequent(String[] words, int k) {
		
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			int count = 0;
			if (map.containsKey(words[i])) {
				count = map.get(words[i]);
			}
			map.put(words[i], count+1);
		}
		
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				int num = o2.getValue().compareTo(o1.getValue());
				if (num == 0) {
					return o1.getKey().compareTo(o2.getKey());
				}
				return num;
			}
		});
		List<String> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			list.add(entryList.get(i).getKey());
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(topKFrequent(new String [] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
	}

}
