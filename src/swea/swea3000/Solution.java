package swea.swea3000;

import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			PriorityQueue<Integer> lowerMaxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // 최대 힙
			PriorityQueue<Integer> upperMinHeap = new PriorityQueue<>(Comparator.naturalOrder()); // 최소 힙

			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			lowerMaxHeap.offer(a);

			long medianSum = 0;
			for (int i = 1; i <= n; i++) {
				int[] x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

				for (int j = 0; j < 2; j++) {
					if (x[j] < lowerMaxHeap.peek()) {
						lowerMaxHeap.offer(x[j]);
					} else {
						upperMinHeap.offer(x[j]);
					}

					if (lowerMaxHeap.size() > upperMinHeap.size() + 1) {
						upperMinHeap.offer(lowerMaxHeap.poll());
					}

					if (lowerMaxHeap.size() < upperMinHeap.size()) {
						lowerMaxHeap.offer(upperMinHeap.poll());
					}
				}

				medianSum = (medianSum + lowerMaxHeap.peek()) % 20171109;
			}

			sb.append("#").append(tc).append(" ").append(medianSum).append("\n");
		}

		System.out.println(sb.toString());

	}


}
