package swea.swea1868;

import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br;
	static int n;
	static char[][] grid;

	static final int[][] DIR = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/swea1868/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			init();

			boolean[][] visited = new boolean[n][n];
			int answer = 0;
			List<int[]> zeroBombPos = getZeroBombPos();
			for (int[] pos : zeroBombPos) {
				int x = pos[0];
				int y = pos[1];
				if (!visited[x][y]) {
					answer++;
					bfs(x, y, visited);
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == '.' && !visited[i][j]) {
						answer++;
					}
				}
			}

			System.out.printf("#%d %d", tc, answer);
			System.out.println();
		}

	}

	static void bfs(int x, int y, boolean[][] visited) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int cx = curr[0];
			int cy = curr[1];

			int bombCount = getBombCount(cx, cy);
			visited[cx][cy] = true;
			if (bombCount == 0) {
				for (int[] d : DIR) {
					int nx = cx + d[0];
					int ny = cy + d[1];
					if (inRange(nx, ny) && grid[nx][ny] == '.' && !visited[nx][ny]) {
						queue.add(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
			}
		}
	}

	static List<int[]> getZeroBombPos() {
		List<int[]> result = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '.' && getBombCount(i, j) == 0) {
					result.add(new int[] {i, j});
				}
			}
		}

		return result;
	}

	static int getBombCount(int x, int y) {
		int result = 0;
		for (int[] d : DIR) {
			int nx = x + d[0];
			int ny = y + d[1];

			if (inRange(nx, ny) && grid[nx][ny] == '*') {
				result++;
			}
		}

		return result;
	}

	static boolean inRange(int x, int y) {
		return (0 <= x && x < n) && (0 <= y && y < n);
	}

	static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		grid = new char[n][n];
    	for (int i = 0; i < n; i++) {
			grid[i] = br.readLine().toCharArray();
		}
	}
}
