package com.java.pointwest.manager;

import java.util.ArrayList;
import java.util.List;

import com.java.pointwest.bean.Animal;
import com.java.pointwest.bean.AnimalShelter;
import com.java.pointwest.bean.Cat;
import com.java.pointwest.bean.Dog;
import com.java.pointwest.bean.Parrot;
import com.java.pointwest.constant.Constant;

public class AnimalShelterManager {
	
	// manager function that will add a key entry to the animal shelter tree map 
	public void addShelter(AnimalShelter animalShelter, String chosenAnimal) {
		List<Animal> animalList = new ArrayList<Animal>();
		animalShelter.getShelter().put(chosenAnimal, animalList);
	}

	// manager function that handles the addition of an animal to the animal shelter
	public String addAnimal(AnimalShelter animalShelter, String animalName, String animalAge, String animalGender, String animalType) {
		int animalCount;
		int totalAnimalCount;
		String addAnimalStatus;

		// determines which animal to be initialized
		switch (animalType) {
		case "DOG":
			Animal dog = new Dog(animalName, Integer.parseInt(animalAge), animalGender, animalType);
			animalShelter.getShelter().get(animalType).add(dog);
			animalCount = animalShelter.getTotalDogCount();
			animalShelter.setTotalDogCount(++animalCount);
			break;
		case "CAT":
			Animal cat = new Cat(animalName, Integer.parseInt(animalAge), animalGender, animalType);
			animalShelter.getShelter().get(animalType).add(cat);
			animalCount = animalShelter.getTotalCatCount();
			animalShelter.setTotalCatCount(++animalCount);
			break;
		case "PARROT":
			Animal parrot = new Parrot(animalName, Integer.parseInt(animalAge), animalGender, animalType);
			animalShelter.getShelter().get(animalType).add(parrot);
			animalCount = animalShelter.getTotalParrotCount();
			animalShelter.setTotalParrotCount(++animalCount);
			break;
		}
		totalAnimalCount = animalShelter.getTotalAnimalCount();
		animalShelter.setTotalAnimalCount(++totalAnimalCount);
		addAnimalStatus = "\n>> " + animalName + " the " + animalType.toLowerCase() + " is now added to the " + animalType.toLowerCase() + " shelter\n";
		System.out.println(animalType + " Shelter animal count: " + animalShelter.getAnimalCount(animalType));
		return addAnimalStatus;
	}

	// manager function that handles the removal of an animal from the animal shelter
	public String removeAnimal(AnimalShelter animalShelter, String animalType, String animalId) {
		int animalCount;
		int totalAnimalCount;
		String removeAnimalStatus;
		Boolean isFound = false;
		
		animalCount = animalShelter.getAnimalCount(animalType);
		
		if (animalCount == 0) {
			removeAnimalStatus = "Sorry, you don't have any " + animalType.toLowerCase() + " in the shelter yet";
		} else {
			for(int i = 0; i < animalShelter.getShelter().get(animalType).size(); i++) {
				if(animalId.equals(animalShelter.getShelter().get(animalType).get(i).getAnimalId())) {
					animalShelter.getShelter().get(animalType).remove(i);
					
					switch(animalType.toUpperCase()) {
					case "DOG":
						animalCount = animalShelter.getTotalDogCount();
						animalShelter.setTotalDogCount(--animalCount);
						break;
						
					case "CAT":
						animalCount = animalShelter.getTotalCatCount();
						animalShelter.setTotalCatCount(--animalCount);
						break;
						
					case "PARROT":
						animalCount = animalShelter.getTotalParrotCount();
						animalShelter.setTotalParrotCount(--animalCount);
						break;
						
					}
					isFound = true;
					break;
				}
			}
			
		}
		
		// determines the return statement if the operation was successful
		if (isFound) {
			removeAnimalStatus = "\n>> Animal with ID: " + animalId + " is now removed from the " + animalType.toLowerCase() + " shelter\n";
		} else {
			removeAnimalStatus = "\n>> Animal with ID: " + animalId + " was not found in the " + animalType.toLowerCase() + " shelter\n";
		}
		totalAnimalCount = animalShelter.getTotalAnimalCount();
		animalShelter.setTotalAnimalCount(--totalAnimalCount);
		return removeAnimalStatus;
	}
	
	// manager function for feeding the selected animal
	public String feedAnimal(AnimalShelter animalShelter, String animalType, String animalId) {
		String feedAnimalStatus = "#";
		Boolean isFound = false;

		if (animalShelter.getAnimalCount(animalType) == 0) {
			feedAnimalStatus = "Sorry, you don't have any " + animalType  + " in the shelter yet";
		} else {
			for(int i = 0; i < animalShelter.getShelter().get(animalType).size(); i++) {
				if(animalId.equals(animalShelter.getShelter().get(animalType).get(i).getAnimalId())) {
					feedAnimalStatus = animalShelter.getShelter().get(animalType).get(i).eat();
					isFound = true;
					break;
				}
			}
		}
		
		// determines the return statement if the operation was successful
		if (!isFound) {
			feedAnimalStatus = "\n>> Animal with ID: " + animalId + " was not found in the " + animalType.toLowerCase() + " shelter \n";
		}
		return feedAnimalStatus;
	}

}
