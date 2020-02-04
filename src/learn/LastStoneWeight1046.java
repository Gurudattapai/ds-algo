package learn;

import java.util.PriorityQueue;

public class LastStoneWeight1046 {

	public static int lastStoneWeight(int[] stones) {
		
		if (stones == null || stones.length == 0) {
			return 0;
		}
		
		if (stones.length == 1) {
			return stones[0];
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int i: stones) {
			pq.add(i);
		}
		
		while(pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();
			if (first - second == 0) {
				continue;
			}
			pq.add(first - second);
		}
		
		return pq.size() == 0 ? 0 : pq.poll();

	}

	public static void main(String[] args) {
		System.out.println(lastStoneWeight(new int [] {2,7,4,1,8,1}));
	}

}
