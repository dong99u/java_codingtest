package swea.swea3304;

import java.util.*;
import java.io.*;

public class Solution {


	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();

		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String[] s = br.readLine().split(" ");
			String a = s[0];
			String b = s[1];

			int[][] dp = new int[b.length() + 1][a.length() + 1];

			for (int i = 1; i < b.length() + 1; i++) {
				for (int j = 1; j < a.length() + 1; j++) {
					if (a.charAt(j - 1) == b.charAt(i - 1)) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}
			int answer = dp[b.length()][a.length()];

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}


}
