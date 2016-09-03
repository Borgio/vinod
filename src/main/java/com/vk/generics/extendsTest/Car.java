package com.vk.generics.extendsTest;

public class Car extends Vehicle {

	@Override
	public void service() {
		System.out.println("Car specific servicing");
	}

}
