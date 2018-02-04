package com.java.pointwest.bean;

public class Parrot extends Animal{
	public String signitureSound = " tweet tweet tweet..";
	String eatingSound = " yum yum yum me likey...";
	
	public Parrot(String name, int age, String gender, String type) {
		super(name, age, gender, type);
	}
	
	@Override
	public String greet() {
		String greetingMesage = this.getAnimalId() + signitureSound + " Hi I'm " + this.getName() + " the Parrot, I'm " + this.getAge() + " yrs old.";
		return greetingMesage;
	}
	
	@Override
	public String eat() {
		String eatingMessage = this.getName() + " says: " + this.eatingSound + "\n";
		return eatingMessage;
	}
}
