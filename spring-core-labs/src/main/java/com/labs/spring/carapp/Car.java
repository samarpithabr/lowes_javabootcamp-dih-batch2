package com.labs.spring.carapp;

public class Car {
	String model;
	String manufacturer;
	String color;
	Engine engine;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Car(String model, String manufacturer, String color, Engine engine) {
		super();
		this.model = model;
		this.manufacturer = manufacturer;
		this.color = color;
		this.engine = engine;
	}
	public Car(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}
	public void setEngine(String string, int i) {
		// TODO Auto-generated method stub
		
	}

}
