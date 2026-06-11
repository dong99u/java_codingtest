package swea.swea2930;

import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

			int n = Integer.parseInt(br.readLine());

			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if (Integer.parseInt(st.nextToken()) == 1) {
					pq.offer(Integer.parseInt(st.nextToken()));
				} else {
					Integer poll = pq.poll();
					sb.append(poll != null ? poll : -1).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}


}
