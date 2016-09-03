package com.vk.generics.ooad;

/**
 * 
 * Don’t repeat yourself design principle is about abstracting out common code
 * and putting it in a single location. It discourages repetitive code.
 *
 */
public class DontRepeatYourself {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Mechanic {

		public void serviceCar() {

			System.out.println("servicing car now");

		}

		public void serviceBike() {

			System.out.println("servicing bike now");

		}

	}

	/*
	 * Notice that there are two methods serviceCar() and serviceBike(). The
	 * mechanic services bikes according to their own method. Nothing strange
	 * about it.
	 * 
	 * Now consider the workshop is offering you other services, the mechanic
	 * will wash your bike and then service, he is also offering to polish
	 * vehicles in the service itself.
	 * 
	 * Now we have to update the code for serviceCar() and serviceBike() also
	 */

	static class Mechanic_V1 {
		public void serviceCar() {

			// washing vehicle here
			System.out.println("servicing car now");
			// polishing vehicle here
		}

		public void serviceBike() {

			// washing vehicle here
			System.out.println("servicing bike now");
			// polishing vehicle here
		}
	}

	/*
	 * Now what is the problem here? Whenever some procedure changes, methods
	 * serviceCar and serviceBike also change. There is code duplication, one
	 * piece of code is repeating for same purpose. Here comes the application
	 * of don’t repeat yourself principle. It states to abstract out the code
	 * that is being duplicated. So we can write a separate method that performs
	 * the tasks which mechanic offers other than servicing.
	 */

	static class Mechanic_V2 {

		public void serviceCar() {

			System.out.println("servicing car now");
			performOtherTasks();
		}

		public void serviceBike() {

			System.out.println("servicing bike now");
			performOtherTasks();
		}

		public void performOtherTasks() {

			// do washing here
			// or do something else
			System.out.println("performing tasks other than servicing");
			// do whatever you want to do in the servicing package
		}

	}
	
	/*
	 * Now you have created a method performOtherTasks() by applying don’t
	 * repeat yourself principle. serviceCar() and serviceBike() simply call it.
	 * Now whatever changes the workshop offers in service package, they can be
	 * included in the same method. That code need not replicate in serviceCar()
	 * and serviceBike(). Thus it makes code more cohesive and maintainable.
	 */
}
