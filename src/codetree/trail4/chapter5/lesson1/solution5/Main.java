package codetree.trail4.chapter5.lesson1.solution5;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[n + 2];
		dp[0] = 1;
		dp[1] = 1;

		for (int count = 2; count <= n; count++) {
			for (int root = 1; root <= count; root++) {
				dp[count] += dp[root - 1] * dp[count - root];
			}
		}
		System.out.println(dp[n]);
	}
}

// public class Main {
// 	static int n;
// 	static int[] memo; // 메모이제이션
//
// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		n = sc.nextInt();
// 		memo = new int[n + 1];
// 		Arrays.fill(memo, -1);
//
// 		int answer = backtrack(n);
// 		System.out.println(answer);
// 	}
//
// 	// label: 남은 노드의 개수
// 	static int backtrack(int count) {
// 		if (memo[count] != -1) {
// 			return memo[count];
// 		}
// 		if (count <= 1) {
// 			return 1;
// 		}
// 		int result = 0;
// 		for (int root = 1; root < count + 1; root++) {
// 			int left = backtrack(root - 1);
// 			int right = backtrack(count - root);
// 			result += left * right;
// 		}
// 		memo[count] = result;
// 		return result;
// 	}
// }
