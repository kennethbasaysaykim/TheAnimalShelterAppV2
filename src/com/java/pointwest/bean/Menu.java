package com.java.pointwest.bean;

public interface Menu {
	
	public abstract void printMenuHeader(String animalType);
	
	public abstract void printMenu(AnimalShelter animalShelter, String animalType);
	
	public abstract String getMenuInput(AnimalShelter animalShelter, String animalType);
	
	
}
