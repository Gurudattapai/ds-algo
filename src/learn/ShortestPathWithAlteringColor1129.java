package learn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathWithAlteringColor1129 {

	public static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
		
		Connection [][] graph = constructGraph(n, red_edges, blue_edges);
		
		int [] returnArray = new int [n];
		Arrays.fill(returnArray, Integer.MAX_VALUE);
		returnArray[0] = 0;
		
		
		Set<Integer> visitedWithBlue = new HashSet<>();
		Set<Integer> visitedWithRed = new HashSet<>();
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visitedWithBlue.add(0);
		q.add(null);
		boolean isPrevRed = false;
		int level = 1;
		while(!q.isEmpty()) {
			Integer current = q.poll();
			if (current == null) {
				level++;
				isPrevRed = !isPrevRed;
				if (q.isEmpty()) {
					break;
				}
				q.add(null);
				continue;
			}
			//visited.add(current);
			for (int i = 0; i < graph.length; i++) {
				Connection connection = graph[current][i];
				if (connection != null) {
					if (!isPrevRed && connection.isRed && !visitedWithRed.contains(i)) {
						q.add(i);
						visitedWithRed.add(i);
						returnArray[i] = Math.min(returnArray[i], level);
					} else if (isPrevRed && connection.isBlue && !visitedWithBlue.contains(i)) {
						q.add(i);
						visitedWithBlue.add(i);
						returnArray[i] = Math.min(returnArray[i], level);
					}
				}
			}
			
		}
		
		q = new LinkedList<>();
		visitedWithBlue = new HashSet<>();
		visitedWithRed = new HashSet<>();
		q.add(0);
		visitedWithRed.add(0);
		q.add(null);
		isPrevRed = true;
		level = 1;
		while(!q.isEmpty()) {
			Integer current = q.poll();
			if (current == null) {
				level++;
				isPrevRed = !isPrevRed;
				if (q.isEmpty()) {
					break;
				}
				q.add(null);
				continue;
			}
			//visited.add(current);
			for (int i = 0; i < graph.length; i++) {
				Connection connection = graph[current][i];
				if (connection != null) {
					if (!isPrevRed && connection.isRed && !visitedWithRed.contains(i)) {
						q.add(i);
						visitedWithRed.add(i);
						returnArray[i] = Math.min(returnArray[i], level);
					} else if (isPrevRed && connection.isBlue && !visitedWithBlue.contains(i)) {
						q.add(i);
						visitedWithBlue.add(i);
						returnArray[i] = Math.min(returnArray[i], level);
					}
				}
			}
		}
		
		for (int i = 0; i < returnArray.length; i++) {
			if (returnArray[i] == Integer.MAX_VALUE) {
				returnArray[i] = -1;
			}
		}
		
		return returnArray;
	}
	
	public static Connection [][] constructGraph(int n, int[][] red_edges, int[][] blue_edges) {
		Connection [][] graph = new Connection [n][n];
		
		for (int i = 0; i < red_edges.length; i++) {
			int src = red_edges[i][0];
			int dest = red_edges[i][1];
			if (graph[src][dest] == null) {
				Connection connection = new Connection();
				connection.isRed = true;
				graph[src][dest] = connection;
			} else {
				graph[src][dest].isRed = true;
			}
		}
		
		for (int i = 0; i < blue_edges.length; i++) {
			int src = blue_edges[i][0];
			int dest = blue_edges[i][1];
			if (graph[src][dest] == null) {
				Connection connection = new Connection();
				connection.isBlue = true;
				graph[src][dest] = connection;
			} else {
				graph[src][dest].isBlue = true;
			}
		}
		return graph;
	}

	public static void main(String[] args) {
		int [][] red_edges = new int [4][2];
		red_edges[0] = new int [] {0,1};
		red_edges[1] = new int [] {1,2};
		red_edges[2] = new int [] {2,3};
		red_edges[3] = new int [] {3,4};
		int [][] blue_edges = new int [3][2];
		blue_edges[0] = new int [] {1,2};
		blue_edges[1] = new int [] {2,3};
		blue_edges[2] = new int [] {3,1};
		System.out.println(Arrays.toString(shortestAlternatingPaths(5, red_edges, blue_edges)));
	}

}


class Connection {
	public boolean isRed;
	public boolean isBlue;
}