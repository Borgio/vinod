/**
 * 
 */
package com.vk.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author vinod
 *
 */
public class UserDefinedSortingComparator {

	public void printEmployeeDetails(List<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	public static void main(String[] args) {
		Employee emp1 = new Employee("1", "prasad", "kharkar");
		Employee emp2 = new Employee("5", "Aniket", "Kulkarni");
		Employee emp3 = new Employee("3", "Kaustubh", "pande");
		Employee emp4 = new Employee("4", "Pranil", "Gilda");
		Employee emp5 = new Employee("2", "Nilesh", "Deshmukh");

		List<Employee> employees = new ArrayList<Employee>();
		UserDefinedSortingComparator employeeSort = new UserDefinedSortingComparator();

		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);

		System.out.println("Unsorted employees");
		employeeSort.printEmployeeDetails(employees);
		Collections.sort(employees, new IdSorter());
		System.out.println("employees sorted using id");
		employeeSort.printEmployeeDetails(employees);
		System.out.println("employees sorted using first name");
		Collections.sort(employees, new FirstNameSorter());
		employeeSort.printEmployeeDetails(employees);
		System.out.println("employees sorted using last name");
		Collections.sort(employees, new LastNameSorter());
		employeeSort.printEmployeeDetails(employees);

	}

}

class IdSorter implements Comparator<Employee> {
	public int compare(Employee anEmployee, Employee anotherEmployee) {
		return anEmployee.getId().compareTo(anotherEmployee.getId());
	}
}

class FirstNameSorter implements Comparator<Employee> {

	public int compare(Employee anEmployee, Employee anotherEmployee) {
		return anEmployee.getFirstName().compareTo(anotherEmployee.getFirstName());
	}
}

class LastNameSorter implements Comparator<Employee> {

	public int compare(Employee anEmployee, Employee anotherEmployee) {
		return anEmployee.getLastName().compareTo(anotherEmployee.getLastName());
	}
}

class Employee {
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
}
