package com.java.pointwest.ui;

import java.util.Scanner;
import com.java.pointwest.bean.AnimalShelter;
import com.java.pointwest.bean.Menu;
import com.java.pointwest.constant.Constant;
import com.java.pointwest.helper.AnimalPageMenuHelper;
import com.java.pointwest.manager.AnimalShelterManager;

public class AnimalMenuPage implements Menu{
	
	// function that will print the menu header for animal page
	@Override
	public void printMenuHeader(String animalType) {
		System.out.println("------------------------------------------");
		System.out.println("      Welcome to " + animalType + " Shelter!");
		System.out.println("------------------------------------------");
	}
	
	// function that prints the menu for add animal page 
	@Override
	public void printMenu(AnimalShelter animalShelter, String animalType) {
		int animalCount;
		int maxAnimalCount;
		boolean isAnimalExist;
		
		AnimalShelterManager animalShelterManager = new AnimalShelterManager();
		
		// creates an entry to the animal shelter tree map 
		isAnimalExist = animalShelter.getShelter().containsKey(animalType);
		if (!isAnimalExist) {
			animalShelterManager.addShelter(animalShelter, animalType);
		}

		animalCount = animalShelter.getAnimalCount(animalType);
		maxAnimalCount = animalShelter.getMaxAnimalCount(animalType);
		animalType = animalType.toLowerCase();
		
		System.out.println("Total " + animalType.toLowerCase() + " in the shelter: " + animalCount);

		if (animalCount == 0) {
			System.out.println(">> " + animalType + " shelter is currently empty\n");
			System.out.println(">> Please Select an Option");
			System.out.println("[1] Add a " + animalType);
			System.out.println("{2] Return to home page");
		} else if (animalCount == maxAnimalCount) {
			System.out.println(">> " + animalType + " shelter is currently full\n");
			System.out.println(">> Please Select an Option");
			System.out.println("[1] Remove a " + animalType);
			System.out.println("{2] View all " + animalType + "s");
			System.out.println("{3] Feed a " + animalType);
			System.out.println("{4] Return to home page");
		} else {
			System.out.println(">> Please Select an Option");
			System.out.println("[1] Add a " + animalType);
			System.out.println("[2] Remove a " + animalType);
			System.out.println("{3] View all " + animalType + "s");
			System.out.println("{4] Feed a " + animalType);
			System.out.println("[5] Return to home page");
		}
		System.out.print("Enter Choice: ");
	}

	// function that will get the menu input of the user for the animal menu page
	@Override
	public String getMenuInput(AnimalShelter animalShelter, String animalType) {
		Scanner scanner = new Scanner(System.in);
		String userChoice;
		String choiceEquivalent = "#";
		int animalTypeCount;

		userChoice = scanner.nextLine();
		AnimalShelterManager animalShelterManager = new AnimalShelterManager();
		animalTypeCount = animalShelter.getAnimalCount(animalType);
		choiceEquivalent = AnimalPageMenuHelper.getChoiceEquivalent(animalShelter, userChoice, animalType, animalTypeCount);
		return choiceEquivalent;
	}

}
