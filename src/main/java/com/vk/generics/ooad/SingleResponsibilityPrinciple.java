package com.vk.generics.ooad;

/**
 * 
 * It states that every object in your system should have a single
 * responsibility and objects services should be focused on carrying out single
 * task well.
 * 
 */
public class SingleResponsibilityPrinciple {

	public static void main(String[] args) {

	}

	static class Bike {

		public void start() {
		}

		public void stop() {
		}

		public void shiftGear() {
		}

		public void applyBreaks() {
		}

		public void wash() {
		}

		public void ride() {
		}

	}

	/*
	 * At first sight, all the methods seem placed properly in the Bike class.
	 * After all it’s all related to bike right? Not so right, let us try to
	 * apply single responsibility principle to above class. I’m going to
	 * explain the same trick that I learned from Head First Object Oriented
	 * Design and Analysis book.
	 * 
	 * The <className> <methodName> itself.
	 * 
	 * let us apply it to bike class and check whether the method should really
	 * belong to Bike class. If Yes, then keep it there , if No, need to move to
	 * another class.
	 * 
	 * The Bike starts itself : Yes The Bike stops itself: Yes The bike applies
	 * breaks itself : No The bike shifts gear itself : No The bike washes
	 * itself: No The bike rides itself: No
	 * 
	 */

	/*
	 * Now we’ve come to know that applyBreaks(), shiftGear(), wash() and ride()
	 * are not really the responsibilities of Bike itself. applyBreaks(),
	 * shiftGear() and ride() should belong to Rider class. wash() should belong
	 * to Washer class. So we can re-structure it as below after applying single
	 * responsibility principle.
	 */

	static class Bike_V1 {

		public void start() {
		}

		public void stop() {
		}

	}

	static class Rider {

		public void ride(Bike bike) {

		}

		public void shiftGear(Bike bike) {

		}

		public void applyBreaks(Bike bike) {

		}

	}

	static class Washer {

		public void wash(Bike bike) {

		}

	}
}
