/**
 * 
 */
package com.vk.generics.ooad;

/**
 * Two classes have composition relationship when one class completely depends
 * upon other class and it does not have existence outside the owning class.
 * When owning class is destroyed, then the owned class also gets destroyed.
 * 
 */
public class CompositionExample {

	/**
	 * For our composition example article, consider following scenario
	 * 
	 * A Wall class which contains Window object i.e. a Wall HAS-A Window The
	 * Window cannot exist without a wall, how could it exist? So whenever a
	 * wall is demolished, window also does not exist.
	 */

	public static void main(String[] args) {

		/**
		 * Things to notice in composition example
		 * 
		 * Wall class has reference to Window class by declaring an instance member private Window window; 
		 * Wall has a no argument constructor in which a Window object is created. 
		 * So whenever you create a Wall using new Wall(), automatically a new Window() is created and assigned to
		 * window instance member 
		 * In this scenario we cannot set window from outside. It simply cannot exist outside the Wall 
		 * Now if we make wall = null; then window object is also removed, because it does not have
		 * a outside reference. 
		 * So the existence of Window depends completely upon existence of Wall. 
		 * 

		 * So this composition example explains that
		 * composition is a strong association. The owned object cannot exist
		 * when the owner does not exist.
		 * 
		 * 
		 */

	}

	static class Window {

	}

	class Wall {

		private Window window;

		public Wall() {
			this.window = new Window();
		}

	}
}
