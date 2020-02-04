package learn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle120 {

	public int minimumTotal(List<List<Integer>> triangle) {
		
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		Map<String, Integer> dp = new HashMap<>();
		return triangle.get(0).get(0) + getMin(triangle, 0, 1, dp);

	}

	private int getMin(List<List<Integer>> triangle, int parentIndex, int level, Map<String, Integer> dp) {
		if (level >= triangle.size()) {
			return 0;
		}
		
		String key = level + "-" + parentIndex;
		if (dp.containsKey(key)) {
			return dp.get(key);
		}
		
		dp.put(key, Math.min(triangle.get(level).get(parentIndex) + getMin(triangle, parentIndex, level + 1, dp),
				triangle.get(level).get(parentIndex + 1) + getMin(triangle, parentIndex + 1, level + 1, dp)));
		return dp.get(key);
	}

	public static void main(String[] args) {

	}

}
