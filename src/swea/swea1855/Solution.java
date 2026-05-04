package swea.swea1855;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {
	static int n;
	static int[] arr;
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			init();
			List<List<Integer>> graph = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}

			for (int i = 2; i <= n ; i++) {
				int u = i, v = arr[i - 2];
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			int answer = bfs(graph);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);
	}

	static int bfs(List<List<Integer>> graph) {
		boolean[] visited = new boolean[n + 1];
		Queue<int[]> queue = new ArrayDeque<>(1);
		queue.add(new int[] {1, 0});
		visited[1] = true;

		int result = 0;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currNode = curr[0], currDepth = curr[1];
			if (queue.isEmpty())
				result += currDepth;
			else
				result += currDepth * 2;
			for (Integer next : graph.get(currNode)) {
				if (!visited[next]) {
					queue.add(new int[] {next, currDepth + 1});
					visited[next] = true;
				}
			}
		}

		return result;
	}

	static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
	}

}
