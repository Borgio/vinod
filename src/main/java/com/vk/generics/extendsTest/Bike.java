package com.vk.generics.extendsTest;

public class Bike extends Vehicle {
	@Override
	public void service() {
		System.out.println("Bike specific servicing");
	}
}