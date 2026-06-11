package swea.swea3282;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int n; // 가방 개수
	static int k; // 가방의 최대 부피

	static int[][] memo; // 메모이제이션 테이블

	static int[] weights; // 각 물건의 부피
	static int[] values; // 각 물건의 가치

	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			init(); // input 초기화

			memo = new int[n + 1][k + 1];
			// 메모 초기화
			for (int[] m : memo) {
				Arrays.fill(m, -1);
			}

			int answer = dp(0, 0);

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb.toString());

	}

	/**
	 * 탑-다운 dp 방식으로 가방에 담을 수 있는 최대 가치를 구함.
	 * 각 물건마다 선택/비선택을 해서 구함
	 * @param idx 물건의 인덱스
	 * @param acc 선택한 물건 부피의 누적합
	 * @return
	 */
	static int dp(int idx, int acc) {
		if (idx == n) return 0;
		if (memo[idx][acc] != -1) return memo[idx][acc];

		int skip = dp(idx + 1, acc);
		int take = 0;
		if (acc + weights[idx] <= k)
			take = values[idx] + dp(idx + 1, acc + weights[idx]);

		memo[idx][acc] = Math.max(skip, take);
		return memo[idx][acc];

	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		weights = new int[n];
		values = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			weights[i] = v;
			values[i] = c;
		}


	}
}
