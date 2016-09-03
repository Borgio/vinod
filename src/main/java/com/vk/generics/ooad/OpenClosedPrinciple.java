/**
 * 
 */
package com.vk.generics.ooad;

/**
 * Open Closed Principle tells us “You should not modify existing behavior but
 * if you want, you can extend it according to your needs.” i.e. Code is open
 * for extension but closed for modification.
 *
 */
public class OpenClosedPrinciple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Mechanic mechanic = new Mechanic();
		mechanic.doService();
	}

	static class Mechanic {

		public void doService() {

			// is Vehicle service?
			Vehicle vehicle = new Vehicle();
			vehicle.service();

			/*
			 * Vehicle class code is not modified and mechanic creates Bike
			 * class extending Vehicle to add bike servicing specific code.
			 */

			// is Bike service?
			Bike cbr = new Bike();
			cbr.service();
		}

	}

	static class Vehicle {

		public void service() {

			System.out.println("General procedures being done on your vehicle");
		}

	}

	static class Bike extends Vehicle {

		@Override
		public void service() {

			System.out.println("Now doing Bike specific servicing");

		}
	}

	static class Car extends Vehicle {

		@Override
		public void service() {

			System.out.println("Now doing Car specific servicing");

		}
	}
}
