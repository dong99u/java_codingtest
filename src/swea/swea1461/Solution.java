package swea.swea1461;

import java.util.*;
import java.io.*;

public class Solution {
	static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static final int MAX_SIZE = (int)1e9;

	static final int EMPTY = 0;
	static final int CORE = 1;
	static final int WIRE = 2;

	static BufferedReader br;
	static int n;
	static int[][] board;

	static List<int[]> cores;
	static int k;


	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/swea1461/sample_input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			init();

			cores = getCores();
			k = cores.size(); // 코어의 개수

			int[] answer = backtrack(0);
			sb.append('#').append(tc).append(' ').append(answer[1]).append("\n");
		}
		System.out.println(sb);

	}

	/**
	 * idx번째 코어를 고려할 때,
	 * 선택한 idx번째 코어부터 k - 1번째 코어의 개수와
	 * 최소 전선 길이
	 * @param idx 0-indexed
	 * @return (선택된 코어의 개수, 전선 길이)
	 */
	static int[] backtrack(int idx) {
		if (idx == k) {
			return new int[] {0, 0};
		}
		int x = cores.get(idx)[0], y = cores.get(idx)[1];
		int[] best = backtrack(idx + 1);
		for (int[] dir : DIR) {
			int len = tryConnect(x, y, dir);
			if (len < 0) continue;

			place(x, y, dir, len);
			int[] sub = backtrack(idx + 1);
			int[] cand = {sub[0] + 1, sub[1] + len};
			if (better(cand, best)) best = cand;
			unplace(x, y, dir, len);

		}
		return best;
	}

	/**
	 * cores가 큰 게 우선
	 * 같으면 length 가 작은 게 우선
	 * @param a
	 * @param b
	 * @return
	 */
	private static boolean better(int[] a, int[] b) {
		if (a[0] != b[0])
			return a[0] > b[0];
		return a[1] < b[1];
	}

	static void place(int x, int y, int[] dir, int len) {
		int nx = x, ny = y;
		for (int i = 0; i < len; i++) {
			nx += dir[0]; ny += dir[1];
			board[nx][ny] = WIRE;
		}
	}

	static void unplace(int x, int y, int[] dir, int len) {
		int nx = x, ny = y;
		for (int i = 0; i < len; i++) {
			nx += dir[0]; ny += dir[1];
			board[nx][ny] = EMPTY;
		}
	}

	/**
	 * (x, y) 코어에서 dir 방향으로 직선 연결 시도
	 * @param x
	 * @param y
	 * @param dir
	 * @return 가장자리까지의 거리(전선 길이). 불가능하면 -1.
	 */
	static int tryConnect(int x, int y, int[] dir) {
		int nx = x, ny = y, len = 0;
		while (true) {
			nx += dir[0]; ny += dir[1];
			if (!inRange(nx, ny)) return len;
			if (board[nx][ny] != EMPTY) return -1;
			len++;
		}
	}

	static boolean inRange(int x, int y) {
		return (0 <= x && x < n) && (0 <= y && y < n);
	}

	static List<int[]> getCores() {
		List<int[]> result = new ArrayList<>();
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (board[i][j] == 1) {
					result.add(new int[] {i, j});
				}
			}
		}

		return result;
	}

	static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
	}
}
