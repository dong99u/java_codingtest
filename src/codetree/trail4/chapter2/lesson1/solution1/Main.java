package codetree.trail4.chapter2.lesson1.solution1;

import java.util.*;

public class Main {
	static int k;
	static int n;
	static ArrayList<Integer> selected = new ArrayList<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		k = sc.nextInt();
		n = sc.nextInt();

		backtrack(0);
		System.out.println(sb.toString());
	}

	// 노드 라벨: (depth)
	static void backtrack(int depth) {
		if (depth == n) {
			for (Integer i : selected) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= k; i++) {
			selected.add(i);
			backtrack(depth + 1);
			selected.remove(selected.size() - 1);
		}
	}
}
