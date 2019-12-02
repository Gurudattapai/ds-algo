package learn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NetworkDelayTime743 {

	public static int networkDelayTime(int[][] times, int N, int K) {
		int[][] graph = constructGraph(times, N);
		Set<Integer> visited = new HashSet<>();
		int max = 0;
		int[] arr = new int[N];
		Arrays.fill(arr, Integer.MAX_VALUE);
		visited.add(K - 1);
		for (int i = 0; i < N; i++) {
			if (i == K-1) {
				arr[i] = 0;
				continue;
			}
			if (visited.contains(i) && graph[K - 1][i] > 0) {
				arr[i] = Math.min(arr[i], graph[K - 1][i]);
				continue;
			}
			if (graph[K - 1][i] > 0) {
				dfs(times, i, visited, N, graph, arr, graph[K - 1][i]);
				arr[i] = Math.min(arr[i], graph[K - 1][i]);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		return visited.size() == N ? max : -1;
	}

	private static void dfs(int[][] times, int i, Set<Integer> visited, int N, int[][] graph, int[] arr, int parent) {
		visited.add(i);
		for (int j = 0; j < N; j++) {
			if (visited.contains(j) && graph[i][j] > 0) {
				arr[j] = Math.min(arr[j], parent + graph[i][j]);
				continue;
			}
			if (graph[i][j] > 0) {
				dfs(times, j, visited, N, graph, arr, parent + graph[i][j]);
				arr[j] = Math.min(arr[j], parent + graph[i][j]);
			}
		}
	}

	public static int[][] constructGraph(int[][] times, int n) {
		int[][] arr = new int[n][n];
		for (int i = 0; i < times.length; i++) {
			int u = times[i][0];
			int v = times[i][1];
			int w = times[i][2];
			arr[u - 1][v - 1] = w;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		arr[0] = new int[] { 2, 1, 1 };
		arr[1] = new int[] { 2, 3, 1 };
		arr[2] = new int[] { 3, 4, 1 };
		System.out.println(networkDelayTime(arr, 4, 2));
	}

}
