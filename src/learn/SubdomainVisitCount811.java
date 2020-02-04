package learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount811 {

	public static List<String> subdomainVisits(String[] cpdomains) {
		
		if (cpdomains == null || cpdomains.length == 0) {
			return new ArrayList<>();
		}
		
		List<String> returnList = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		
		for (String s : cpdomains) {
			String [] arr = s.split(" ");
			map.put(arr[1], map.getOrDefault(s, 0) + Integer.parseInt(arr[0]));
			int from = 0;
			int index = arr[1].indexOf(".", from);
			while (index != -1) {
				String sub = arr[1].substring(index + 1);
				map.put(sub, map.getOrDefault(sub, 0) + Integer.parseInt(arr[0]));
				from = index + 1;
				index = arr[1].indexOf(".", from);
			}
		}
		
		for (String key : map.keySet()) {
			returnList.add(map.get(key) + " " + key);
		}
		
		return returnList;

	}

	public static void main(String[] args) {
		System.out.println(subdomainVisits(new String [] {"9001 discuss.leetcode.com"}));
	}

}
