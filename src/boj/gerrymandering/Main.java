package boj.gerrymandering;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	static int n;
	static final int MAX_SIZE = (int) 1e9;
	static int[] arr;

	static Set<Integer> total;

	static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		total = IntStream.rangeClosed(1, n)
				.boxed()
				.collect(Collectors.toCollection(HashSet::new));

		arr = new int[n + 1]; // 각 인구수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		graph = new ArrayList[n + 1];

		for (int u = 1; u < n + 1; u++) {
			graph[u] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			for (int v = 0; v < j; v++) {
				graph[u].add(Integer.parseInt(st.nextToken()));
			}
		}

		int answer = MAX_SIZE;
		for (int max_count = 1; max_count < n; max_count++) {
			Set<Integer> aSelected = new HashSet<>();
			answer = Math.min(answer, backtrack(1, 0, max_count, aSelected));
		}

		System.out.println(answer == MAX_SIZE ? -1 : answer);
	}

	static int backtrack(int idx, int count, int max_count, Set<Integer> aSelected) {
		if (idx == n + 1) {
			if (count != max_count) {
				return MAX_SIZE;
			}
		}
		if (count == max_count) {
			Set<Integer> bSelected = new HashSet<>(total);
			bSelected.removeAll(aSelected);

			return bfs(aSelected, bSelected);
		}

		int result = MAX_SIZE;
		for (int i = idx; i < n + 1; i++) {
			aSelected.add(i);
			result = Math.min(result, backtrack(i + 1, count + 1, max_count, aSelected));
			aSelected.remove(i);
		}

		return result;
	}

	static int bfs(Set<Integer> aSelected, Set<Integer> bSelected) {
		Integer aStartNode = aSelected.iterator().next();
		Integer bStartNode = bSelected.iterator().next();

		Queue<Integer> aQueue = new ArrayDeque<>();
		Queue<Integer> bQueue = new ArrayDeque<>();

		Set<Integer> aVisited = new HashSet<>();
		Set<Integer> bVisited = new HashSet<>();

		aQueue.offer(aStartNode);
		bQueue.offer(bStartNode);

		aVisited.add(aStartNode);
		bVisited.add(bStartNode);

		while (!aQueue.isEmpty()) {
			Integer currNode = aQueue.poll();

			for (Integer nextNode : graph[currNode]) {
				if (aSelected.contains(nextNode)) {
					if (aVisited.contains(nextNode)) continue;
					aVisited.add(nextNode);
					aQueue.offer(nextNode);
				}
			}
		}

		if (!aVisited.equals(aSelected)) {
			return MAX_SIZE;
		}

		while (!bQueue.isEmpty()) {
			Integer currNode = bQueue.poll();

			for (Integer nextNode : graph[currNode]) {
				if (bSelected.contains(nextNode)) {
					if (bVisited.contains(nextNode)) continue;
					bVisited.add(nextNode);
					bQueue.offer(nextNode);
				}
			}
		}

		if (!bVisited.equals(bSelected)) {
			return MAX_SIZE;
		}
		int aSum = aSelected.stream().map(e -> arr[e]).reduce(0, Integer::sum);
		int bSum = bSelected.stream().map(e -> arr[e]).reduce(0, Integer::sum);

		return Math.abs(aSum - bSum);

	}
}
