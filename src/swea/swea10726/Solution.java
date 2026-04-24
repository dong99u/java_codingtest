package swea.swea10726;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/swea/swea10726/input.txt"));

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			String answer = solution(n, m);

			System.out.printf("#%d %s\n", tc, answer);
		}
	}

	static String solution(int n, int m) {
		int mask = (1 << n) - 1;

		if ((m & mask) == mask) {
			return "ON";
		} else {
			return "OFF";
		}
	}
}
