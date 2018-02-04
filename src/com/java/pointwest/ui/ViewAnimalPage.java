package com.java.pointwest.ui;

import java.util.List;

import com.java.pointwest.bean.Animal;
import com.java.pointwest.bean.AnimalShelter;
import com.java.pointwest.bean.Menu;
import com.java.pointwest.constant.Constant;

public class ViewAnimalPage implements Menu {

	// function that will print the menu header for the view option
	@Override
	public void printMenuHeader(String animalType) {
		System.out.println("--------------------------------------");
		System.out.println("    Meet Our Lovely " + animalType + " Friends!");
		System.out.println("--------------------------------------");
	}
	
	public void printMenuHeader() {
		System.out.println("------------------------------------");
		System.out.println("   Meet Our Lovely Animal Friends!");
		System.out.println("------------------------------------");
	}
	
	// function that will print all animals in the shelter
	public void viewAllAnimals(AnimalShelter animalShelter) {
		int totalAnimalCount;

		totalAnimalCount = animalShelter.getTotalAnimalCount();

		if (totalAnimalCount != 0) {
			for (String animalType : animalShelter.getShelter().keySet()) {
				for (Animal animal : animalShelter.getShelter().get(animalType)) {
					System.out.println(animal.greet());
				}
			}
			System.out.println(" ");
		} else {
			System.out.println(Constant.EMPTY_ANIMAL_SHELTER_MESSAGE);
		}
	}

	// function that will print all animals in the shelter
	public void viewAnimal(AnimalShelter animalShelter, String animalType) {
		int animalCount;

		animalCount = animalShelter.getAnimalCount(animalType);

		if (animalCount != 0) {
			for (Animal animal : animalShelter.getShelter().get(animalType)) {
				System.out.println(animal.greet());
			}
			System.out.println("");
		} else {
			System.out.println("The " + animalType.toLowerCase() + " shelter is currently empty");
		}
	}

	// function which has no functionality based
	// on the current requirement of the "VIEW" option
	@Override
	public void printMenu(AnimalShelter animalShelter, String animalType) {
	}

	// function which has no functionality based
	// on the current requirement of the "VIEW" option
	@Override
	public String getMenuInput(AnimalShelter animalShelter, String animalType) {
		return null;
	}

}
