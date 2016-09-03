/**
 * 
 */
package com.vk.general;

import org.jsoup.Jsoup;

/**
 * @author vinod
 *
 */
public class HtmlEscapeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "Happy &amp; Sad";
	    System.out.println(s);

	    try {
	        // Change to "Happy & Sad". DOESN'T WORK!
			s = java.net.URLDecoder.decode(s, "UTF-8");
							/*
								 * java.net.URLDecoder deals only with the
								 * application/x-www-form-urlencoded MIME format
								 * (e.g. "%20" represents space), not with HTML
								 * character entities. I don't think there's
								 * anything on the Java platform for that. You
								 * could write your own utility class to do the
								 * conversion
								 */

	        System.out.println(s);
	        
	        System.out.println("Jsoup Works!!!");
	        System.out.println(Jsoup.parse(s).text());
	        
	        System.out.println(Jsoup.parse("medium-weight shirt \u2014 heavier").text());
	        
	        
	        
	        String str = Jsoup.parse("&lt;Fran&ccedil;ais&gt;").text();
	        System.out.print(str);
	        
	    } catch (Exception ex) {
	    	ex.printStackTrace();
	    }

	}

}
