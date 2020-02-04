package learn;

import java.util.Arrays;

public class BoatsToSavePeople881 {

	public static int numRescueBoats(int[] people, int limit) {
		
		if (people == null || people.length == 0) {
			return 0;
		}
		Arrays.sort(people);
		int i = 0;
		int j = people.length - 1;
		int count = 0;
		while (i <= j) {
			if (people[i] + people[j] <= limit) {
				count++;
				i++;
				j--;
			} else {
				j--;
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(numRescueBoats(new int [] {2,3,7}, 8));

	}

}
