package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		combination(candidates, 0, target, list, new ArrayList<Integer> ());
		return list;
	}
	
	public void combination(int[] candidates, int index, int target, List<List<Integer>> list, List<Integer> current) {
		
		if (candidates[index] > target) {
			return;
		}
		
		if (target == 0) {
			list.add(current);
			return;
		}
		
		for (int i = index; i < candidates.length; i++) {
			if (i == index || candidates[i] != candidates[i - 1]) {
				current.add(candidates[i]);
				combination(candidates, i + 1, target - candidates[i], list, current);
				current.remove(current.size() - 1);
			}
		}
		
	}

	public static void main(String[] args) {

	}

}
