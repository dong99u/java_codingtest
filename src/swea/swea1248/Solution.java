package swea.swea1248;

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br;

	static int v; // 노드의 개수
	static int e; // 간선의 개수
	static int startNode1;
	static int startNode2;

	static int[] parent;
	static int[] left;
	static int[] right;
	static int[] depths;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			init();
			setDepth();

			if (depths[startNode1] < depths[startNode2]) {
				int k = depths[startNode2] - depths[startNode1];
				for (int i = 0; i < k; i++) {
					startNode2 = parent[startNode2];
				}
			} else if (depths[startNode1] > depths[startNode2]) {
				int k = depths[startNode1] - depths[startNode2];
				for (int i = 0; i < k; i++) {
					startNode1 = parent[startNode1];
				}
			}
			while (startNode1 != startNode2) {
				startNode1 = parent[startNode1];
				startNode2 = parent[startNode2];
			}
			int count = bfs(startNode1);

			System.out.printf("#%d %d %d", tc, startNode1, count);
			System.out.println();
		}
	}

	static void setDepth() {
		depths = new int[v + 1];

		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {1, 0});

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currNum = curr[0];
			int d = curr[1];

			depths[currNum] = d;

			if (left[currNum] != 0) {
				queue.add(new int[] {left[currNum], d + 1});
			}
			if (right[currNum] != 0) {
				queue.add(new int[] {right[currNum], d + 1});
			}

		}
	}

	static int bfs(int rootNum) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(rootNum);
		int count = 1;

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			if (left[curr] != 0) {
				queue.add(left[curr]);
				count++;
			}
			if (right[curr] != 0) {
				queue.add(right[curr]);
				count++;
			}
		}

		return count;
	}
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		startNode1 = Integer.parseInt(st.nextToken());
		startNode2 = Integer.parseInt(st.nextToken());

		parent = new int[v + 1];
		left = new int[v + 1];
		right = new int[v + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < e; i++) {
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			parent[c] = p;
			if (left[p] == 0) left[p] = c;
			else if (right[p] == 0) right[p] = c;
		}

	}
}
