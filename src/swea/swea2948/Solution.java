package swea.swea2948;

import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br;

	static int n; // 첫 번째 문자열 집합의 크기
	static int m; // 두 번째 문자열 집합의 크기
	static HashMap<String, Integer> hashMap;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			init();

			int answer = 0;
			for (Integer value : hashMap.values()) {
				answer += value > 1 ? value - 1 : 0;
			}

			for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {

			}

			sb.append("#").append(tc).append(" ").append(answer).append("\n");

		}

		System.out.println(sb.toString());
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		hashMap = new HashMap<>();

		for (int i = 0; i < 2; i++) {
			for (String s : br.readLine().split(" ")) {
				hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
			}
		}

	}


}
