/**
 * 
 */
package com.vk.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author vinod
 *
 */
public class UserDefinedSortingComparable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee emp1 = new Employee("1", "prasad", "kharkar");
		Employee emp2 = new Employee("5", "Aniket", "Kulkarni");
		Employee emp3 = new Employee("3", "Kaustubh", "pande");
		Employee emp4 = new Employee("4", "Pranil", "Gilda");
		Employee emp5 = new Employee("2", "Nilesh", "Deshmukh");

		List<Employee> employees = new ArrayList<Employee>();

		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);

		System.out.println("Employees before sorting");

		for (Employee emp : employees) {
			System.out.println(emp);
		}

		Collections.sort(employees);
		System.out.println("Employees after sorting");

		for (Employee emp : employees) {
			System.out.println(emp);
		}

	}

	static class Employee implements Comparable<Employee> {

		private String id;
		private String firstName;
		private String lastName;

		Employee(String id, String firstName, String lastName) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String toString() {
			return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
		}

		/*
		 * compareTo method is overridden so that the Employee objects can be
		 * written.
		 */
		public int compareTo(Employee employee) {
			return this.id.compareTo(employee.getId());
		}
	}
}
