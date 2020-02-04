package learn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DuplicateZeros1089 {

	public static int[] duplicateZeros(int[] arr) {
		
		if (arr == null || arr.length == 0) {
			return new int [0];
		}
		
		int index = arr.length - 1;
		for (int i = 0; i < index; i++) {
			if (arr[i] == 0) {
				arr[index--] = 0;
			}
		}
		
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			if (list.size() != 0) {
				int temp = arr[i];
				int prev = list.remove(0);
				arr[i] = prev;
				list.add(temp);
				if (prev == 0) {
					if (i < arr.length - 1) {
						list.add(arr[i+1]);
						arr[i+1] = 0;
					}
					i++;
				}
			} else if (arr[i] == 0) {
				if (i < arr.length - 1) {
					list.add(arr[i+1]);
					arr[i+1] = 0;
				}
				i++;
			}
		}
		return arr;
		
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(duplicateZeros(new int [] {1,0,2,3,0,4,5,0})));
	}

}
