package swea.swea1288;

import java.io.*;
import java.util.*;

public class Solution {

	static int n;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/swea1288/input.txt"));
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();

			int answer = solution(n);
			System.out.println("#" + tc + " " + answer);
		}

	}

	static int solution(int n) {
		int k = 1;

		int visited = 0;

		while (true) {
			int value = k * n;
			String s = String.valueOf(value);
			for (char c : s.toCharArray()) {
				int num = c - '0';
				int mask = 1 << num;
				visited |= mask;
			}
			if (visited == (1 << 10) - 1) {
				return k * n;
			}
			k++;
		}
	}

}
