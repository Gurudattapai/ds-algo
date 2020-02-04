package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExclusiveTimeOfFunctions636 {

	public static int[] exclusiveTime(int n, List<String> logs) {

		if (n == 0) {
			return new int[0];
		}

		/*
		 * Collections.sort(logs, new Comparator<String> () {
		 * 
		 * @Override public int compare(String o1, String o2) { return
		 * o1.split(":")[2].compareTo(o2.split(":")[2]); } });
		 */

		Map<Integer, Integer> map = new TreeMap<>();
		String first = logs.get(0);
		String[] arr = first.split(":");
		int funcId = Integer.parseInt(arr[0]);
		// String process = arr[1];
		int startTime = Integer.parseInt(arr[2]);
		map.put(funcId, 0);
		for (int i = 1; i < logs.size(); i++) {
			String current = logs.get(i);
			String[] currentArr = current.split(":");
			int curId = Integer.parseInt(currentArr[0]);
			//String curProcess = currentArr[1];
			int curStartTime = Integer.parseInt(currentArr[2]);
			int total = curStartTime - startTime == 0 ? 1 : curStartTime - startTime;
			map.put(funcId, map.getOrDefault(funcId, 0) + (total));
			if (i == logs.size() - 1) {
				map.put(curId, map.get(curId) + (total));
			}
			funcId = curId;
			startTime = curStartTime;
			// process = curProcess;
		}
		List<Integer> values = new ArrayList<>(map.values());
		//Collections.sort(values);
		int[] returnArr = new int[values.size()];
		for (int i = 0; i < values.size(); i++) {
			returnArr[i] = values.get(i);
		}
		return returnArr;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("0:start:0");
		list.add("1:start:2");
		list.add("1:end:5");
		list.add("0:end:6");
		System.out.println(
				Arrays.toString(exclusiveTime(2, list)));
	}

}
