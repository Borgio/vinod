package com.vk.generics.extendsTest;

import java.util.ArrayList;
import java.util.List;

public class Mechanic {

	public void serviceVehicles(List<? extends Vehicle> vehicles) {
		for (Vehicle vehicle : vehicles) {
			vehicle.service();
		}
	}

	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(new Vehicle());
		vehicles.add(new Vehicle());
		
		List<Bike> bikes = new ArrayList<Bike>();
		bikes.add(new Bike());
		bikes.add(new Bike());
		
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car());
		cars.add(new Car());

		Mechanic mechanic = new Mechanic();

		mechanic.serviceVehicles(vehicles); // This works fine.
		mechanic.serviceVehicles(bikes); // Compiler error.
		mechanic.serviceVehicles(cars); //Compiler error. 

	}

}
