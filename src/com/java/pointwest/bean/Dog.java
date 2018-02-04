package com.java.pointwest.bean;

public class Dog extends Animal {
	public String signitureSound = " arf arf argf...";
	private String eatingSound = " yum yum yum oishi!";
	
	public Dog(String name, int age, String gender, String type) {
		super(name, age, gender, type);
	}

	@Override
	public String greet() {
		String greetingMesage = this.getAnimalId() + signitureSound + " Hi I'm " + this.getName() + " the Dog, I'm " + this.getAge() + " yrs old.";
		return greetingMesage;
	}
	
	@Override
	public String eat() {
		String eatingMessage = this.getName() + " says: " + this.eatingSound + "\n";
		return eatingMessage;
	}
}
