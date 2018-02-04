package com.java.pointwest.ui;

import java.util.Scanner;

import com.java.pointwest.bean.AnimalShelter;
import com.java.pointwest.bean.Menu;
import com.java.pointwest.constant.Constant;
import com.java.pointwest.helper.HomePageMenuHelper;

public class HomePage implements Constant, Menu {
	
	// function that will print the menu header for home page
	@Override
	public void printMenuHeader(String animalType) {
		System.out.println("-------------------------------------");
		System.out.println(" Welcome to Kenneth's Animal Shelters ");
		System.out.println("-------------------------------------");
	}
	
	// function that prints the menu for the home page
	@Override
	public void printMenu(AnimalShelter animalShelter, String animalType) {
		System.out.println("What shelter would you like to visit? Please select an option: ");
		System.out.println("[1] Dog Shelter");
		System.out.println("[2] Cat Shelter");
		System.out.println("{3] Parrot Shelter");
		System.out.println("{4] View all Animals");
		System.out.println("{5] Exit");
		System.out.print("Enter choice: ");
	}
	
	// function that will get the menu input of the user forr the home page
	@Override
	public String getMenuInput(AnimalShelter animalShelter, String animalType) {
		Scanner scanner = new Scanner(System.in);
		String userChoice;
		String choiceEquivalent = "#";

		userChoice = scanner.nextLine();
		choiceEquivalent = HomePageMenuHelper.getChoiceEquivalent(animalShelter, userChoice);
		return choiceEquivalent;
	}
	public void printReturnToHomePageMessage() {
		System.out.println(Constant.RETURN_TO_HOME_PAGE_MESSAGE);
	}
	
	public void printTerminateMessage() {
		System.out.println(Constant.TERMINATE_MESSAGE);
	}
	
	public void printInvalidOption() {
		System.out.println(Constant.INVALID_CHOICE_ERROR_MESSAGE);
	}

}
