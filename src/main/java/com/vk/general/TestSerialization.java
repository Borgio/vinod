package com.vk.general;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialization {

	public static void main(String[] args) {

		Bike bike = new Bike(250, "black");
		writeObject("D:\\serTest.ser", bike);

		Bike deSerializedBike = null;
		try {
			System.out.println("before reading bike from file :" + deSerializedBike);
			deSerializedBike = (Bike) readSerializedObject("D:\\serTest.ser");
			System.out.println("after reading bike from file  :" + deSerializedBike);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method takes two parameters, Object to be serialized and the name of
	 * file in which the object should be written
	 */
	public static void writeObject(String outFile, Object object) {
		try {
			FileOutputStream fos = new FileOutputStream(outFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public static Object readSerializedObject(String fileName) throws Exception {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		return ois.readObject();

	}
}

class Bike implements Serializable {
	private int engineCapacity;
	private String color;

	public Bike(int engineCapacity, String color) {
		this.engineCapacity = engineCapacity;
		this.color = color;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return "Bike [engineCapacity=" + engineCapacity + ", color=" + color + "]";
	}

}