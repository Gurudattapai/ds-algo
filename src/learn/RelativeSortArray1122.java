package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelativeSortArray1122 {
	
	static Map<Integer, Integer> positionMap = new HashMap<>();

	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		
		if (arr2 == null || arr2.length == 0) {
			Arrays.sort(arr1);
			return arr1;
		}
		
		for (int i = 0; i < arr2.length ; i++) {
			positionMap.put(arr2[i], i);
		}
		
		List<Integer> list = new ArrayList<>();
		for (int num : arr1) {
			list.add(num);
		}
		
		Collections.sort(list, new Comparator<Integer> () {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (positionMap.get(o1) != null && positionMap.get(o2) != null) {
					return positionMap.get(o1) - positionMap.get(o2);
				}
				if (positionMap.get(o1) != null && positionMap.get(o2) == null) {
					return -1;
				}
				if (positionMap.get(o1) == null && positionMap.get(o2) != null) {
					return 1;
				}
				if (positionMap.get(o1) == null && positionMap.get(o2) == null) {
					return o1 - o2;
				}
				return -1;
			}	
		});
		
		int [] arr = new int [list.size()];
		int index = 0;
		for (int l : list) {
			arr[index++] =  l;
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(relativeSortArray(new int [] {26,21,11,20,50,34,1,18}, new int [] {21,11,26,20})));
	}

}
