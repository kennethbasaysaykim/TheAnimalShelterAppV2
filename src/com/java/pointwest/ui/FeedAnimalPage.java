package com.java.pointwest.ui;

import java.util.Scanner;

import com.java.pointwest.bean.AnimalShelter;
import com.java.pointwest.bean.Menu;
import com.java.pointwest.manager.AnimalShelterManager;

public class FeedAnimalPage implements Menu {
	
	// function that will print the menu header for feed animal option
	@Override
	public void printMenuHeader(String animalType) {
		System.out.println("-------------------------------------");
		System.out.println("       Feed an Animal yum yum!       ");
		System.out.println("-------------------------------------");
	}
	
	// function that prints the menu for feed animal option
	@Override
	public void printMenu(AnimalShelter animalShelter, String animalType) {
		System.out.println(">> Please enter the animal ID of the animal to be fed: ");
	}
	
	// function that will get the menu input of the user for the feed animal page
	@Override
	public String getMenuInput(AnimalShelter animalShelter, String animalType) {
		Scanner scanner = new Scanner(System.in);
		String animalId;
		System.out.print("Enter animal ID: ");
		animalId = scanner.nextLine();
		return animalId;
	}
	
	public String feedAnimal(AnimalShelter animalShelter, String animalType, String animalId) {
		AnimalShelterManager animalShelterManager = new AnimalShelterManager();
		String feedAnimalStatus;
		
		feedAnimalStatus = animalShelterManager.feedAnimal(animalShelter, animalType, animalId);
		System.out.println(feedAnimalStatus);
		return null;
	}
}
