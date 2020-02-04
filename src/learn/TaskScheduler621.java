package learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler621 {

	public static int leastInterval(char[] tasks, int n) {
		
		if (tasks == null || tasks.length == 0) {
			return 0;
		}
		
		Map<Character, Integer> map = new HashMap<>();
		for (char c : tasks) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		pq.addAll(map.values());
		int cycles = 0;
		while(!pq.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				if (!pq.isEmpty()) {
					list.add(pq.remove());
				}
			}
			
			for (int i : list) {
				if (--i > 0) {
					pq.add(i);
				}
			}
			
			cycles += pq.isEmpty() ? list.size() : n + 1;
		}
		return cycles;

	}

	public static void main(String[] args) {
		System.out.println(leastInterval(new char [] {'A','A','A','B','B','B'}, 2));
	}

}
