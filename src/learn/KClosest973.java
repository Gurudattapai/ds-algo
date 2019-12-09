package learn;

import java.util.Arrays;
import java.util.Comparator;

public class KClosest973 {

	public static int[][] kClosest(int[][] points, int K) {

		Arrays.sort(points, new Comparator<int[]>() {
			int [] origin = new int [] {0,0};
			@Override
			public int compare(int[] o1, int[] o2) {
				Double dist1 = Math.sqrt((Math.pow(o1[0] - origin[0], 2) + (Math.pow(o1[1] - origin[1], 2))));
				Double dist2 = Math.sqrt((Math.pow(o2[0] - origin[0], 2) + (Math.pow(o2[1] - origin[1], 2))));
				return dist1.compareTo(dist2);
			}
		});

		int [][] arr = new int [K][2];
		for (int i = 0; i < K; i++) {
			arr[i] = points[i];
		}
		return arr;
	}

	public static void main(String[] args) {
		int [][] points = new int [3][2];
		points [0] = new int [] {3,3};
		points [1] = new int [] {5,-1};
		points [2] = new int [] {-2,4};
		System.out.println(Arrays.toString(kClosest(points, 2)));
	}

}
