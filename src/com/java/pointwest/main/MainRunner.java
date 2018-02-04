package com.java.pointwest.main;

import com.java.pointwest.ui.AddAnimalPage;
import com.java.pointwest.ui.AnimalMenuPage;
import com.java.pointwest.ui.FeedAnimalPage;
import com.java.pointwest.ui.HomePage;
import com.java.pointwest.ui.RemoveAnimalPage;
import com.java.pointwest.ui.ViewAnimalPage;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.text.View;

import com.java.pointwest.bean.Animal;
import com.java.pointwest.bean.AnimalShelter;
import com.java.pointwest.constant.Constant;

public class MainRunner implements Constant {

	// Main runner program

	public static void main(String[] args) {
		boolean isTerminated = false;
		boolean isReturnToMainMenu = false;
		boolean isValidAnimalChoice = false;
		String animalType = null;
		String operation;
		String animalId;

		AnimalShelter animalShelter = new AnimalShelter();
		animalShelter.setShelter(new TreeMap<String, List<Animal>>());

		HomePage homePage = new HomePage();

		// outer loop that will run the program until user decides to terminate it
		do {
			// 1st inner loop that determines if user had selected a valid animal or if the user wants to terminate the program
			do {
				isValidAnimalChoice = false;
				homePage.printMenuHeader(animalType);
				homePage.printMenu(animalShelter, animalType);
				animalType = homePage.getMenuInput(animalShelter, animalType);
				
				switch (animalType) {
				case "DOG":
				case "CAT":
				case "PARROT":
					isValidAnimalChoice = true;
					break;
				case "VIEW":
					ViewAnimalPage viewAnimalPage = new ViewAnimalPage();
					viewAnimalPage.printMenuHeader();
					viewAnimalPage.viewAllAnimals(animalShelter);
					break;
				case "END":
					homePage.printTerminateMessage();
					isValidAnimalChoice = true;
					isTerminated = true;
					break;

				default:
					homePage.printInvalidOption();
					break;
				}
			} while (!isValidAnimalChoice);
			
			// 2nd inner loop that will allow the user to perform certain actions for the selected animal shelter
			while (!isTerminated && !isReturnToMainMenu) {
				AnimalMenuPage animalMenuPage = new AnimalMenuPage();
				animalMenuPage.printMenuHeader(animalType);
				animalMenuPage.printMenu(animalShelter, animalType);
				operation = animalMenuPage.getMenuInput(animalShelter, animalType);

				switch (operation) {

				case "ADD":
					AddAnimalPage addAnimalPage = new AddAnimalPage();
					addAnimalPage.printMenuHeader(animalType);
					addAnimalPage.printMenu(animalShelter, animalType);
					addAnimalPage.getMenuInput(animalShelter, animalType);
					if (addAnimalPage.checkIfShelterIsFull(animalShelter)) {
						homePage.printTerminateMessage();
						isReturnToMainMenu = true;
						isTerminated = true;
					}				
					break;

				case "REMOVE":
					RemoveAnimalPage removeAnimalPage = new RemoveAnimalPage();
					removeAnimalPage.printMenuHeader(animalType);
					removeAnimalPage.printMenu(animalShelter, animalType);
					animalId = removeAnimalPage.getMenuInput(animalShelter, animalType);
					removeAnimalPage.removeAnimalFromList(animalShelter, animalType, animalId);
					break;

				case "VIEW":	
					ViewAnimalPage viewAnimalPage = new ViewAnimalPage();
					viewAnimalPage.printMenuHeader(animalType);
					viewAnimalPage.viewAnimal(animalShelter, animalType);
					break;

				case "FEED":
					FeedAnimalPage feedAnimalPage = new FeedAnimalPage();
					feedAnimalPage.printMenuHeader(animalType);
					feedAnimalPage.printMenu(animalShelter, animalType);
					animalId = feedAnimalPage.getMenuInput(animalShelter, animalType);
					feedAnimalPage.feedAnimal(animalShelter, animalType, animalId);
					break;

				case "END":
					isReturnToMainMenu = true;
					break;

				default:
					homePage.printInvalidOption();
					break;

				}

			}
			isReturnToMainMenu = false;
		} while (!isTerminated);
	}

}
