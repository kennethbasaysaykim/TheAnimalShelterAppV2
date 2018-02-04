package com.java.pointwest.bean;

public abstract class Animal {
	public static int animalIdCounter = 1000;
	private String name;
	private int age;
	private String gender;
	private String type;
	private String animalId;
	
	public Animal(String name, int age, String gender, String type){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.type = type;
		this.animalId = Integer.toString(animalIdCounter++);
	}
	
	// functions to be overwritten by the subclasses of the animal class
	public abstract String greet();
	public abstract String eat();
	
	public String getAnimalId() {
		return animalId;
	}

	public void setAnimalId(String animalId) {
		this.animalId = animalId;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
