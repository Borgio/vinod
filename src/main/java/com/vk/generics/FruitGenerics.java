package com.vk.generics;

import java.util.ArrayList;
import java.util.List;

public class FruitGenerics {
	
	public static void main(String... args) {
		
		Apple[] applesArray = new Apple[1];
		applesArray[0] = new Apple();
		Fruit[] fruitsArray = applesArray;
		for (Fruit fruit : fruitsArray) {
			System.out.println("Fruit : "+fruit);
		}
		fruitsArray[0] = new Strawberry();
		
		/*List<Apple> apples = new ArrayList<Apple>();
		List<Fruit> fruits = apples;
		fruits.add(new Strawberry());*/


		List<Apple> apples = new ArrayList<Apple>();
		List<? extends Fruit> fruits = apples;
		//fruits.add(new Strawberry()); //error
		
		List<? super Fruit> fruitsSuper = new ArrayList<Fruit>();
		fruitsSuper.add(new Strawberry());
		
		List<? extends Fruit> fruitsExtends = new ArrayList<Fruit>();
		//fruitsB.add(new Strawberry()); // error
		

	}

}
