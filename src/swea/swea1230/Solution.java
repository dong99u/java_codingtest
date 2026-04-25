package swea.swea1230;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Solution {
	static int n;
	static LinkedList<Integer> linkedList;
	static int orderCount;
	static StringTokenizer orderSt;
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/swea/swea1230/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			init();

			while (orderSt.hasMoreTokens()) {
				Character c = orderSt.nextToken().charAt(0);
				switch (c) {
					case 'I': {
						int x = Integer.parseInt(orderSt.nextToken());
						int y = Integer.parseInt(orderSt.nextToken());
						ListIterator<Integer> it = linkedList.listIterator(x);
						for (int i = 0; i < y; i++) {
							int ss = Integer.parseInt(orderSt.nextToken());
							it.add(ss);

						}
						break;
					}
					case 'D': {
						int x = Integer.parseInt(orderSt.nextToken());
						int y = Integer.parseInt(orderSt.nextToken());
						ListIterator<Integer> it = linkedList.listIterator(x);
						for (int i = 0; i < y; i++) {
							it.next();
							it.remove();
						}
						break;
					}
					case 'A': {
						int y = Integer.parseInt(orderSt.nextToken());
						for (int i = 0; i < y; i++) {
							int ss = Integer.parseInt(orderSt.nextToken());
							linkedList.addLast(ss);
						}
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(linkedList.get(i)).append(" ");
			}
			System.out.println(sb);
		}
	}

	static void init() throws IOException {

		n = Integer.parseInt(br.readLine());
		linkedList = Arrays.stream(br.readLine().split(" "))
			.map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
		orderCount = Integer.parseInt(br.readLine());
		orderSt = new StringTokenizer(br.readLine());

	}
}
