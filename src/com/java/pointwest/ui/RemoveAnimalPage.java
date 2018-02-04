package com.java.pointwest.ui;

import java.util.List;
import java.util.Scanner;

import com.java.pointwest.bean.Animal;
import com.java.pointwest.bean.AnimalShelter;
import com.java.pointwest.bean.Menu;
import com.java.pointwest.constant.Constant;
import com.java.pointwest.manager.AnimalShelterManager;

public class RemoveAnimalPage implements Menu {
	
	// function that will print the menu header for remove animal option
	@Override
	public void printMenuHeader(String animalType) {
		System.out.println("-------------------------------------");
		System.out.println(" Remove a " + animalType + " from shelter");
		System.out.println("-------------------------------------");
	}
	
	// function that prints the menu for the remove animal option
	@Override
	public void printMenu(AnimalShelter animalShelter, String animalType) {
		System.out.println(">> Please enter the reference ID of the animal to be removed");
	}
	
	// function that gets the user input for the remove animal option
	@Override
	public String getMenuInput(AnimalShelter animalShelter, String animalType) {
		Scanner scanner = new Scanner(System.in);
		String animalId;
		
		System.out.print("Enter animal ID: ");		
		animalId = scanner.nextLine();
		return animalId;
	}
	
	// view function that prints that will initialize an animal manager to remove an animal and prints the status of the remove operation
	public void removeAnimalFromList(AnimalShelter animalShelter, String animalType, String animalId) {
		AnimalShelterManager animalShelterManager = new AnimalShelterManager();
		String removeAnimalStatus;
		
		removeAnimalStatus = animalShelterManager.removeAnimal(animalShelter, animalType, animalId);		
		System.out.println(removeAnimalStatus);
		
	}
	
}
