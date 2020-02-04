package learn;

public class FlippingAnImage832 {

	public static int[][] flipAndInvertImage(int[][] A) {
		
		if (A == null || A.length == 0) {
			return new int [0][0];
		}
		
		int [][] flippedImage = new int [A.length][A[0].length];
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				flippedImage[i][A.length-j-1] = A[i][j];
				flippedImage[i][A.length-j-1] ^= 1;
			}
		}
		return flippedImage;

	}

	public static void main(String[] args) {
		int [][] arr = new int [3][3];
		arr[0] = new int [] {1,1,0};
		arr[1] = new int [] {1,0,1};
		arr[2] = new int [] {0,0,0};
		System.out.println(flipAndInvertImage(arr));
	}

}
