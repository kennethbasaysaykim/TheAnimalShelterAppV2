package com.java.pointwest.ui;

import java.util.Scanner;

import com.java.pointwest.bean.AnimalShelter;
import com.java.pointwest.bean.Menu;
import com.java.pointwest.constant.Constant;
import com.java.pointwest.helper.AddAnimalPageMenuHelper;
import com.java.pointwest.manager.AnimalShelterManager;

public class AddAnimalPage implements Constant, Menu{
	
	// function that will print the menu header for add animal option
	@Override
	public void printMenuHeader(String animalType) {
		animalType = animalType.toLowerCase();
		System.out.println("-------------------------------------");
		System.out.println("        Add a " + animalType + " to shelter     ");
		System.out.println("-------------------------------------");
	}
	
	// function that prints the menu for add animal option
	@Override
	public void printMenu(AnimalShelter animalShelter, String animalType) {
		System.out.println(">> Please provide the ff. information to add a dog");
	}
	
	// function that will get the menu input of the user for the add animal page
	@Override
	public String getMenuInput(AnimalShelter animalShelter, String animalType) {
		AnimalShelterManager animalShelterManager = new AnimalShelterManager();
		Scanner scanner = new Scanner(System.in);
		String animalNameInput;
		String animalAgeInput = "0";
		String animalGenderInput;
		String resultStatus;
		String temp;
		boolean isValidAge = false;
		boolean isValidGender = false;

		System.out.print("Enter the " + animalType.toLowerCase() + "'s name: ");
		animalNameInput = scanner.nextLine();

		// this block checks if the age input is valid (assumption: expected animal life span is 0-15 yrs)
		while (!isValidAge) {
			System.out.print("Enter " + animalNameInput + "'s age (0-18): ");
			animalAgeInput = scanner.next();

			for (int i = 0; i <= Constant.MAX_VALID_ANIMAL_AGE; i++) {
				temp = i + "";
				if (temp.equals(animalAgeInput)) {
					isValidAge = true;
				}
			}

			if (!isValidAge) {
				System.out.println(Constant.NOT_A_VALID_AGE_ERROR_MESSAGE);
			}
		}
		
		do {
			System.out.print("Enter " + animalNameInput + "'s gender (M or F): ");
			animalGenderInput = scanner.next();
			
			if("M".equalsIgnoreCase(animalGenderInput) || "F".equalsIgnoreCase(animalGenderInput)) {
				isValidGender = true;
			}else {
				System.out.println(Constant.NOT_A_VALID_GENDER_ERROR_MESSAGE);
			}
			
		}while(!isValidGender);
		
		resultStatus = animalShelterManager.addAnimal(animalShelter, animalNameInput, animalAgeInput, animalGenderInput, animalType);
		System.out.println(resultStatus);
		return "#";
	}
	
	// function that will check if the program reached the maximum allowed number of animals inside the shelter
	public boolean checkIfShelterIsFull(AnimalShelter animalShelter) {
		Scanner scanner = new Scanner(System.in);
		String choiceEquivalent = "CONTINUE";
		String userChoice;
		boolean isOperationCompleted = false;
		boolean isTerminated = false;
		int totalAnimalCount;
		
		totalAnimalCount = animalShelter.getTotalAnimalCount();

		if (totalAnimalCount == animalShelter.getMaxAnimalCount()) {
			do {
				System.out.println(Constant.MAX_ANIMAL_COUNT_REACHED_MESSAGE);
				System.out.println("[1] Yes");
				System.out.println("{2] No");
				System.out.print("Enter choice: ");
				userChoice = scanner.nextLine();
				choiceEquivalent = AddAnimalPageMenuHelper.evaluateContinueMenuChoice(userChoice);
				
				if(choiceEquivalent.equalsIgnoreCase(Constant.CONTINUE_OPTION_EQUIVALENT_VARIABLE)) {
					isOperationCompleted = true;
				}else if(choiceEquivalent.equalsIgnoreCase(Constant.END_OPTION_EQUIVALENT_VARIABLE)) {
					isTerminated = true;
					isOperationCompleted = true;
				}else{
					System.out.println(Constant.INVALID_CHOICE_EQUIVALENT_VARIABLE);
				}

			} while (!isOperationCompleted);
		}
		return isTerminated;
	}

}
