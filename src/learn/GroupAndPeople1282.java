package learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAndPeople1282 {

	public static List<List<Integer>> groupThePeople(int[] groupSizes) {
		
		List<List<Integer>> returnList = new ArrayList<>();
		if (groupSizes == null || groupSizes.length == 0) {
			return returnList;
		}
		
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < groupSizes.length; i++) {
			if (!map.containsKey(groupSizes[i])) {
				map.put(groupSizes[i], new ArrayList<>());
			}
			map.get(groupSizes[i]).add(i);
		}
		
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			int size = entry.getKey();
			List<Integer> list = entry.getValue();
			if (list.size() > size) {
				int index = 0;
				while (index < list.size()) {
					List<Integer> intList = new ArrayList<>();
					int end = index + size;
					for (int i = index; i < end; i++) {
						intList.add(list.get(i));
					}
					index = end;
					returnList.add(intList);
				}
			} else {
				returnList.add(list);
			}
		}
		return returnList;		
	}

	public static void main(String[] args) {
		System.out.println(groupThePeople(new int [] {2,1,3,3,3,2}));
	}

}
