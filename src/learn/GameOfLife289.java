package learn;

import java.util.HashSet;
import java.util.Set;

public class GameOfLife289 {

	public static void gameOfLife(int[][] board) {
		Set<Obj> set = new HashSet<>();
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				boolean isLive = checkLive(board, i, j);
				if (isLive && board[i][j] == 0) {
					Obj o = new Obj(i, j);
					set.add(o);
				} else if (!isLive && board[i][j] == 1) {
					Obj o = new Obj(i, j);
					set.add(o);
				}
			}
		}
		for (Obj o : set) {
			int i = o.i;
			int j = o.j;
			board[i][j] = Math.abs(board[i][j] - 1);
		}

	}

	private static boolean checkLive(int[][] board, int i, int j) {
		int liveCount = 0;
		for (int row = i > 0 ? i-1 : i; row <= (i < board.length - 1 ? i + 1 : i); row++) {
			for (int col = j > 0 ? j - 1 : j; col <= (j < board[0].length - 1 ? j + 1 : j); col++) {
				if (row == i && col == j) {
					continue;
				}
				if (board[row][col] == 1) {
					liveCount++;
				}
			}
		}
		if (board[i][j] == 0 && liveCount == 3) {
			return true;
		}
		if (board[i][j] == 0 && liveCount < 2) {
			return false;
		}
		if (board[i][j] == 1 && (liveCount == 2 ||  liveCount == 3)) {
			return true;
		}
		if (board[i][j] == 1 && liveCount > 3) {
			return false;
		}
		return false;
	}

	public static void main(String[] args) {
		int [][] arr = new int [4][4];
		for (int i = 0; i < arr.length; i++) {
			if (i == 0)  {
				int [] a = new int [] {0,1,0};
				arr[i] = a;
			}
			if (i == 1)  {
				int [] a = new int [] {0,0,1};
				arr[i] = a;
			}
			if (i == 2)  {
				int [] a = new int [] {1,1,1};
				arr[i] = a;
			}
			if (i == 3)  {
				int [] a = new int [] {0,0,0};
				arr[i] = a;
			}
		}
		gameOfLife(arr);
	}
}

class Obj {
	int i;
	int j;

	public Obj(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
