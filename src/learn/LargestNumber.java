package learn;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	
	public static String largestNumber(int[] nums) {
		Integer[] arr = Arrays.stream(nums).boxed().toArray( Integer[]::new );
		Arrays.sort(arr, new IntComp());
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			strBuilder.append(arr[i]);
		}
		return strBuilder.toString();
    }
	
	public static void main(String [] args) {
		int [] arr = new int [] {3,30,34,5,9};
		System.out.print(largestNumber(arr));
	}
	
	

}

class IntComp implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		/*int firstDigit1 = Integer.parseInt(o1.toString().substring(0, 1));
		int firstDigit2 = Integer.parseInt(o2.toString().substring(0, 1));
		if (firstDigit1 > firstDigit2) {
			return -1;
		} else if(firstDigit1 < firstDigit2) {
			return 1;
		} else {
			/*if (o1.toString().length() > o2.toString().length()) {
				return -1;
			} else if (o1.toString().length() < o2.toString().length()) {
				return 1;
			} else {
				String first = o1.toString();
				String sec = o2.toString();
				for (int i = 1; i < first.length(); i++) {
					if (Integer.parseInt(first.substring(i, i + 1)) > Integer.parseInt(sec.substring(i, i + 1))) {
						return -1;
					} else if (Integer.parseInt(first.substring(i, i + 1)) > Integer.parseInt(sec.substring(i, i + 1))) {
						return 1;
					}
				}
				return 0;
			}
			if (o1.toString().length() != o2.toString().length()) {
				String first = o1.toString();
				String sec = o2.toString();
				String con = null;
				if (first.length() > sec.length()) {
					con = first;
				} else {
					con = sec;
				}
				for (int i = 1; i < con.length(); i++) {
					if(Integer.parseInt(con.substring(i, i+1)) > 0) {
						if (con == first) {
							return -1;
						} else {
							return 1;
						}
					}
				}
				return 0;
			} else {
				String first = o1.toString();
				String sec = o2.toString();
				for (int i = 1; i < first.length(); i++) {
					if (Integer.parseInt(first.substring(i, i + 1)) > Integer.parseInt(sec.substring(i, i + 1))) {
						return -1;
					} else if (Integer.parseInt(first.substring(i, i + 1)) > Integer.parseInt(sec.substring(i, i + 1))) {
						return 1;
					}
				}
			return 0;
		}
	}*/
		String XY=o1.toString() + o2.toString(); 
        
        String YX=o2.toString() + o1.toString(); 
          
        return XY.compareTo(YX) > 0 ? -1:1; 
	}	
}
