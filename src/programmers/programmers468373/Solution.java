package programmers.programmers468373;

import java.util.*;

public class Solution {

	public int solution(int n, int infection, int[][] edges, int k) {
		List<List<int[]>> graph = initGraph(n, edges);
		boolean[] visited = new boolean[n + 1];
		List<Integer> infectedNodes = new ArrayList<>();
		infectedNodes.add(infection);




    }

	static int bfs(List<Integer> startNodes, boolean[] visited) {
		Queue<Integer> queue = new ArrayDeque<>(startNodes);

		while (!queue.isEmpty()) {
			int currNode = queue.poll();

		}
	}



	static List<List<int[]>> initGraph(int n, int[][] edges) {
		List<List<int[]>> graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];
			int category = edge[2];

			graph.get(from).add(new int[] {to, category});
			graph.get(to).add(new int[] {from, category});
		}

		return graph;
	}
}
