/**
 * 
 */
package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author vinod
 *
 */
public class WebsiteAnalyzer1 {

	private static Map<String, Integer> websitePopularity = new TreeMap<>();

	public void reportPageAccess(String pageUrl) {
		putInMap(pageUrl);
	}

	private void putInMap(String pageUrl) {
		if (websitePopularity.containsKey(pageUrl)) {
			websitePopularity.put(pageUrl, websitePopularity.get(pageUrl) + 1);
		} else {
			websitePopularity.put(pageUrl, 1);
		}
	}

	public List<String> getTopNPages(int n) {
		if (n <= 0) {
			return null;
		} else {
			return generateTopNPages(n);

		}
	}

	private List<String> generateTopNPages(int n) {
		SortedSet<Integer> counts = new TreeSet<>(websitePopularity.values());
		List<String> webSites = new ArrayList<>();
		for (int i = 0; i < n && counts.size() > 0; i++) {
			for (Map.Entry<String, Integer> entrySet : websitePopularity.entrySet()) {
				if (counts.last() == entrySet.getValue()) {
					if (webSites.size() == n) {
						break;
					}
					webSites.add(entrySet.getKey());
				}
			}
			counts.remove(counts.last());
		}
		return webSites;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		WebsiteAnalyzer1 analyzer = new WebsiteAnalyzer1();
		for (int i = 0; i < 5; i++) {
			analyzer.reportPageAccess(in.next());
		}
		in.close();
		List<String> webSites = analyzer.getTopNPages(2);
		for (String webSite : webSites) {
			System.out.println(webSite);
		}
	}

}
