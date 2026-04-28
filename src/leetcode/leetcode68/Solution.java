package leetcode.leetcode68;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static List<String> fullJustify(String[] words, int maxWidth) {
		int n = words.length;

		List<String> line = new ArrayList<>(List.of(words[0]));
		int sum = words[0].length();
		for (int i = 1; i < n; i++) {
			if (sum + 1 + words[i].length() > maxWidth) {
				sum = words[i].length();
			}
			line.add(words[i]);
		}
    }

	static String justifyLine(List<String> line) {
		StringBuilder sb = new StringBuilder();

		int sumLength = line.stream().mapToInt(String::length).sum();


	}
}