package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * http://ideone.com/ilSrA7
 * 
 */
public class MinimumSubString {

	public static void findMinSS(String input1, String input2) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input2.length(); i++) {
			Integer count = map.get(input2.charAt(i));
			if (count == null) {
				map.put(input2.charAt(i), 1);
			} else {
				map.put(input2.charAt(i), count + 1);
			}
		}
		int sw = -1;
		int ew = -1;
		int found = 0;
		int minS = -1;
		int minE = -1;
		int min = input1.length();
		Map<Character, Integer> fm = new HashMap<>();
		for (int j = 0; j < input1.length(); j++) {
			Integer exC = map.get(input1.charAt(j));
			if (exC == null) {
				continue;
			}
			if (sw == -1) {
				sw = j;
				minS = sw;
			}
			Integer fC = fm.get(input1.charAt(j));
			if (fC == null) {
				fC = 0;
			}
			if (fC < exC) {
				found++;
			}
			if (found == input2.length()) {
				ew = j;
				if (ew - sw + 1 < min) {
					minS = sw;
					minE = j;
					min = ew - sw + 1;
				}
			}
			fm.put(input1.charAt(j), fC + 1);
			if (sw != -1 && input1.charAt(sw) == input1.charAt(j)) {
				sw = cleanup(input1, sw, fm, map);
				ew = j;
				if (found == input2.length() && ew - sw + 1 < min) {
					minS = sw;
					minE = j;
					min = ew - sw + 1;
				}
			}

		}

		System.out.println(input1.substring(minS, minE + 1));
	}

	public static int cleanup(String s, int si, Map<Character, Integer> fm, Map<Character, Integer> t) {
		for (int i = si; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (t.get(c) == null) {
				continue;
			}
			Integer exC = t.get(c);
			Integer cWC = fm.get(c);
			if (cWC > exC) {
				fm.put(c, cWC - 1);
				continue;
			}
			return i;

		}
		return -1;
	}

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		findMinSS("this is a test string", "tist");
	}
}
