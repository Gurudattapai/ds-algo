package learn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SortByParity905 {

	public static int[] sortArrayByParity(int[] A) {
		
		/*Integer [] arr = new Integer [A.length];
		for (int i = 0; i < A.length; i++) {
			arr[i] = A[i];
		}
		
		Arrays.sort(arr, new Comparator<Integer> () {
			
			@Override
			public int compare(Integer a, Integer b) {
				if(a % 2 == 0 && b % 2 == 0) {
					return 0;
				} else if (a % 2 == 0 && b % 2 != 0) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		
		for (int i = 0; i< A.length; i++) {
			A[i] = arr[i];
		}
		return A;*/
		if (A == null || A.length == 0) {
			return A;
		}
		
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				list.add(0, A[i]);
			} else {
				list.add(A[i]);
			}
		}
		int [] arr = new int [list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortArrayByParity(new int [] {3,1,2,4})));
	}

}
