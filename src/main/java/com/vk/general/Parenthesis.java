package com.vk.general;

import java.util.HashSet;
import java.util.Set;

public class Parenthesis {

	public static void main(String[] args) {

		Parenthesis parenthis = new Parenthesis();
		Set<String> sets = parenthis.getAllParenthesisCombination(3);
		System.out.println(sets);

	}

	public Set<String> getAllParenthesisCombination(int n) {
		if (n == 0)
			return null;
		else if (n == 1) {
			Set<String> set = new HashSet<String>();
			set.add("()");
			return set;
		} else {
			Set<String> set = getAllParenthesisCombination(n - 1);
			Set<String> newSet = new HashSet<String>();
			for (String str : set) {
				newSet.add("()" + str);
				newSet.add(str + "()");
				newSet.add("(" + str +")");
			}
			return newSet;
		}
	}
	
}
