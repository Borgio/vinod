package com.vk.ds.trie;

import java.util.List;

/**
 * 
 * @author vinod
 * https://mishrabagish.wordpress.com/2014/02/20/implementing-partial-search-using-trie-in-java/
 */
public class TrieSearch {

	public static void main(String[] args) {
		
		Trie trie = new Trie();
		trie.addWord("Java");
		trie.addWord("JavaOne");
		trie.addWord("JavaTwo");
		trie.addWord("JavaThree");
		trie.addWord("JavaFour");
		trie.addWord("JavaFive");
		
		
		List<String> matches = trie.search("JavaT");
		if(matches==null || matches.size() == 0)
		{
			System.out.println("Noh found");
		}
		else
		{
			for(String str:matches)
			{
				System.out.println(str);
			}
		}

	}

}
