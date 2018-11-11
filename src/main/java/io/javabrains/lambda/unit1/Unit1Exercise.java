package io.javabrains.lambda.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.javabrains.lambda.common.Person;

public class Unit1Exercise {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);
		
		// Step 1: Sort list by last name
		Collections.sort(people, (s1, s2) -> s1.getLastName().compareTo(s2.getLastName()));
		
		// Step 2: Create a method that prints all elements in the list
		
		people.forEach(p -> System.out.println(p));
		
		
		// Step 3: Create a method that prints all people that have last name beginning with C 
		System.out.println(" ------------------------- ");
		System.out.println("prints all people that have last name beginning with C ");
		people.forEach(p -> {
			if (p.getLastName().startsWith("C")) {
				System.out.println(p);
			}
			
		});

	}

}
