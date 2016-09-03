package com.test;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringEscapeUtils;

public class Test {

	public static void main(String[] args) {
		
		String str = "Capri* AND jacket*";
		if (str.contains("*")) {
			str = str.replaceAll("\\*", " ");
		}
		System.out.println(str);

		String[] parts = str.split(" ");
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < parts.length; i++){
			if (parts[i].trim().length() == 0 || parts[i].trim().contains("AND")) continue;
			if(sb.length() > 0){
				sb.append(" AND ");
			}
			
			sb.append(parts[i] + "*");
		}
		System.out.println(sb.toString());
		
		// xml string specical character 
		String xmlData = "				<deliveryaddress1>380 King's Road</deliveryaddress1> 		<skudescription>1.5\"</skudescription>";
		xmlData = xmlData.replaceAll("\'", "&apos;");
		xmlData = xmlData.replaceAll("\"", "&quot;");
		System.out.println("Escaped String  : "+xmlData);
		
		Date date = new Date(1463961600000L);
		System.out.println(date);
		
		Calendar cal = Calendar.getInstance();
		try {
			Date d1 = new SimpleDateFormat("yyyyMMddHHmmss").parse("20160516234300");
			System.out.println("Schedule Date : "+d1);
			cal.setTime(d1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("Time in millis : "+cal.getTimeInMillis());
		System.out.println("Calendar : "+cal);
		
		
		System.out.println("XML Escape : "+StringEscapeUtils.escapeXml11("C/o Stikeman Elliott 1155 René-Lévesque Blvd. West, 40th Floor"));
		
		for (int i=0; i<15; i++) {
			System.out.println(RandomStringUtils.randomAlphanumeric(7).toUpperCase());
		}
		
		char[] chars = { '0','1','2','3','4','5','6','7','8','9','A',
                'B','C','D','E','F','G','H','I','J','K','L',
                'M','N','O','P','Q','R','S','T','U','V','W',
                'X','Y','Z'};
		
		//example C3 order id 
		Random r = new Random(2000000019022L);
		
		char[] id = new char[8];
		for (int i = 0;  i < 8;  i++) {
		    id[i] = chars[r.nextInt(chars.length)];
		}
		
		System.out.println("New UUID : " +new String(id));
		//M4SU64C
		System.out.println("Base 36 UUID : "+Long.toString(00000754703L, 36));
		
		String orderId = "9876543210";
		long num = Long.valueOf(orderId);
		System.out.println("Order Id : "+num);
		String myNum = Long.toString(num, Character.MAX_RADIX); 
		System.out.println("Base 36 : "+myNum);
		
		A a1 = new A();
		System.out.println(a1.i);
		a1.print();
		a1.print1();
		
		A a2 = new B();
		System.out.println(a2.i);
		a2.print();
		a2.print1();
		
	}
}

class A {
	public int i=10;
	
	public void print() {
		System.out.println("In A");
	}
	
	public void print1() {
		print();
	}
}

class B extends A {
	public int i=20;
	
	public void print() {
		System.out.println("In B");
	}
	
	public void print1() {
		super.print1();
	}
}