package leetcode.leetcode2681;

import java.util.*;

public class Solution {

	static ArrayList<Integer> selected = new ArrayList<>();
	public static void main(String[] args) {
		System.out.println(sumOfPower(new int[] {1, 1, 1}));

	}

	public static int sumOfPower(int[] nums) {
		int answer = 0;
		for (int i = 1; i <= nums.length; i++) {
			answer += getCombinations(nums, 0, i);
		}
		return answer;
    }

	static int getCombinations(int[] nums, int idx, int count) {
		if (selected.size() == count) {
			return getOperatedResult();
		}

		int result = 0;
		for (int i = idx; i < nums.length; i++) {
			selected.add(nums[i]);
			result += getCombinations(nums, i + 1, count);
			selected.removeLast();
		}

		return result;
	}

	static int getOperatedResult() {
		int maxValue = selected.getFirst();
		int minValue = selected.getFirst();

		// 최소, 최대 값 구하기
		for (int num : selected) {
			if (maxValue < num) maxValue = num;
			if (minValue > num) minValue = num;
		}

		return (maxValue * maxValue) * minValue;

	}
}
