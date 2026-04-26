package swea.swea5122;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
	static BufferedReader br;

	static int n, m, l;
	static LinkedList<Integer> ll;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/swea5122/sample_input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			init();

			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Character c = st.nextToken().charAt(0);

				switch (c) {
					case 'I': {
						int idx = Integer.parseInt(st.nextToken());
						int val = Integer.parseInt(st.nextToken());
						ll.add(idx, val);
						break;
					}
					case 'D': {
						int idx = Integer.parseInt(st.nextToken());
						ll.remove(idx);
						break;
					}
					case 'C': {
						int idx = Integer.parseInt(st.nextToken());
						int val = Integer.parseInt(st.nextToken());
						ll.set(idx, val);
						break;
					}
				}
			}

			int answer = ll.size() <= l ? -1 : ll.get(l);

			System.out.printf("#%d %d\n", tc, answer);
		}
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		ll = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
			.collect(Collectors.toCollection(LinkedList::new));
	}


}
