package swea.swea1231;

import java.util.*;
import java.io.*;

public class Solution {

	static BufferedReader br;

	static int n;
	static int[] left;
	static int[] right;
	static char[] value;


	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			init();
			System.out.printf("#%d ", tc);
			preOrder(1);
			System.out.println();
		}

	}

	static void preOrder(int currNode) {
		if (currNode == 0) return;
		preOrder(left[currNode]);
		System.out.printf("%c", value[currNode]);
		preOrder(right[currNode]);
	}

	static void init() throws IOException {
		n = Integer.parseInt(br.readLine());
		left = new int[n + 1];
		right = new int[n + 1];
		value = new char[n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int curr = Integer.parseInt(st.nextToken());
			value[curr] = st.nextToken().charAt(0);
			if (st.hasMoreElements()) {
				left[curr] = Integer.parseInt(st.nextToken());
			}
			if (st.hasMoreElements()) {
				right[curr] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
