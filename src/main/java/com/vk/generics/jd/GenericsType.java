package com.vk.generics.jd;

/**
 * 
 * http://www.journaldev.com/1663/java-generics-example-method-class-interface
 *
 */
public class GenericsType<T> {
	
	/*
	 * 	E – Element (used extensively by the Java Collections Framework, for example ArrayList, Set etc.)
		K – Key (Used in Map)
		N – Number
		T – Type
		V – Value (Used in Map)
		S,U,V etc. – 2nd, 3rd, 4th types
	 */

	private T t;

	public T get() {
		return this.t;
	}

	public void set(T t1) {
		this.t = t1;
	}

	public static void main(String args[]) {
		GenericsType<String> type = new GenericsType<>();
		type.set("Pankaj"); // valid
		
		GenericsType type1 = new GenericsType(); // raw type
		type1.set("Pankaj"); // valid
		type1.set(10); // valid and autoboxing support
	}
}
