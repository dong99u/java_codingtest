package leetcode.leetcode811;

import java.util.*;
import java.util.stream.*;

public class Solution {


	public static void main(String[] args) {
		String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

		List<String> strings = subdomainVisits(cpdomains);

		for (String string : strings) {
			System.out.println(string);
		}
	}

	public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> hashMap = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int num = Integer.parseInt(split[0]);
            String[] splitDomain = split[1].split("\\.");

            for (int i = 0; i < splitDomain.length; i++) {
                String key = String.join(".", Arrays.copyOfRange(splitDomain, i, splitDomain.length));
                hashMap.merge(key, num, Integer::sum);
            }
        }

        return hashMap.entrySet().stream()
            .map(e -> e.getValue() + " " + e.getKey())
            .collect(Collectors.toList());
    }
}
