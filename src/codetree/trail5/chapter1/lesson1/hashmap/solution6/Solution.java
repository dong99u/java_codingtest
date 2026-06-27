package codetree.trail5.chapter1.lesson1.hashmap.solution6;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			HashMap<Integer, Integer> hashMap = new HashMap<>();
			int target = k - arr[i];

			for (int j = i + 1; j < n; j++) {
				if (hashMap.containsKey(target - arr[j])) {
					count += hashMap.get(target - arr[j]);
				}

				hashMap.merge(arr[j], 1, Integer::sum);
			}
		}

		System.out.println(count);
	}
}
