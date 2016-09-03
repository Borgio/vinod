package com.javacodegeeks.patterns.abstractfactorypattern;

public class NYOrderXMLParser implements XMLParser{

	public String parse() {
		System.out.println("NY Parsing order XML...");
		return "NY Order XML Message";
	}

}

