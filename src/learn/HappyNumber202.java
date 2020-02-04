package learn;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber202 {

	public static boolean isHappy(int n) {
		
		Set<Integer> set = new HashSet<>();
		int current = n;
		while (current != 1) {
			set.add(current);
			int sum = 0;
			while (current != 0) {
				sum += (current % 10) * (current % 10);
				current /= 10;
			}
			
			if (set.contains(sum)) {
				return false;
			}
			current = sum;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}

}
