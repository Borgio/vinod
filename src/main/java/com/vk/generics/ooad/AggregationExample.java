/**
 * 
 */
package com.vk.generics.ooad;

/**
 * 
 * By definition we know that two classes have aggregation relationship when one
 * class has the reference of other class but other class can still exist
 * outside the containing class.
 * 
 * 
 */
public class AggregationExample {
	
	
	/*Now consider two classes. Bike and Engine. We have following assumptions.

		A bike HAS-A engine
		An engine can exist without bike. (because we can manufacture engine separately and then mount on the bike)
		The bike must have an engine
	
	 */
	
	public static void main(String[] args) {

		Engine engine = new Engine();
		Bike bike = new Bike(engine);
 
		System.out.println(engine);
		System.out.println(bike.getEngine());
 
		bike = null;
 
		System.out.println(engine);
		
		/*
		 * Let us see what’s happening in aggregation example
		 * 
		 * Engine engine = new Engine() creates a new Engine object, we are
		 * creating it outside bike. We are creating a bike using new
		 * Bike(engine); i.e. passing the outside engine object to Bike
		 * constructor. After that we are printing engine and bike.getEngine() ,
		 * they are same objects. Now after setting bike = null; we are printing
		 * engine. It still gives same result It means even after we have
		 * destroyed bike, its engine still exists.
		 * 
		 * From above observations we can note that aggregation is a weak
		 * association and existence of the object does not depend upon
		 * existence of owning object. i.e. Engine still exists without a Bike
		 */
	}
	
	static class Engine {
		 
		public String toString() {
			return "Engine object";
		}
	 
	}
	
	static class Bike {
		 
		private Engine engine;
	 
		public Bike(Engine engine) {
	 
			this.engine = engine;
	 
		}
	 
		public Engine getEngine() {
			return engine;
		}
	 
		public void setEngine(Engine engine) {
			this.engine = engine;
		}
	 
		public String toString() {
			return "Bike [engine=" + engine + "]";
		}
	 
	}


}

