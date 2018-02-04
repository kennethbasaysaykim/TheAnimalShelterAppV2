package com.java.pointwest.bean;

public class Cat extends Animal{
	
	private String signitureSound = " meow meow meow...";
	private String eatingSound = " yum yum yum Deliciouso!";
	
	public Cat(String name, int age, String gender, String type) {
		super(name, age, gender, type);
	}
	
	@Override
	public String greet() {
		String greetingMesage = this.getAnimalId() + signitureSound + " Hi I'm " + this.getName() + " the Cat, I'm " + this.getAge() + " yrs old.";
		return greetingMesage;
	}

	@Override
	public String eat() {
		String eatingMessage = this.getName() + " says: " + this.eatingSound + "\n";
		return eatingMessage;
	}

}
