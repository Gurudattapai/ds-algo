package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MostFrequentSubTreeSum508 {

	public static int[] findFrequentTreeSum(TreeNode root) {
		if (root == null) {
			return new int [0];
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		subTreeSum(root, map);
		
		List<Map.Entry<Integer, Integer> > list = 
	               new LinkedList<Map.Entry<Integer, Integer> >(map.entrySet()); 
	  
	        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
	            public int compare(Map.Entry<Integer, Integer> o1,  
	                               Map.Entry<Integer, Integer> o2) 
	            { 
	                return (o1.getValue()).compareTo(o2.getValue()); 
	            } 
	        });
		
	    int max = list.get(list.size() - 1).getValue();
	    List<Integer> ret = new ArrayList<>();
	    ret.add(list.get(list.size() - 1).getKey());
	    for (int i = list.size() - 2; i >= 0; i--) {
	    	if (list.get(i).getValue() == max) {
	    		ret.add(list.get(i).getKey());
	    	} else {
	    		break;
	    	}
	    }
	    int[] array = ret.stream().mapToInt(i->i).toArray();
	    return array;
	}
	
	public static int subTreeSum(TreeNode root, Map<Integer, Integer> map) {
		if (root == null) {
			return 0;
		}
		
		if (root.left == null && root.right == null) {
			map.put(root.val, map.get(root.val) == null ? 1 : map.get(root.val) + 1);
			return root.val;
		}
		
		int leftSum = subTreeSum(root.left, map);
		int rightSum = subTreeSum(root.right, map);
		
		int sum = root.val + leftSum + rightSum;
		map.put(sum, map.get(sum) == null ? 1 : map.get(sum) + 1);
		return sum;	
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode (5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(-5);
		System.out.println(Arrays.toString(findFrequentTreeSum(root)));
	}

}
