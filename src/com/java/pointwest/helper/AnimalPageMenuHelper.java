package com.java.pointwest.helper;

import com.java.pointwest.bean.AnimalShelter;

public class AnimalPageMenuHelper {

	public static String getChoiceEquivalent(AnimalShelter animalShelter, String userChoice, String animalType, int animalTypeCount) {
		int maxAnimalTypeCount;
		String selectedOption;
		
		maxAnimalTypeCount = animalShelter.getMaxAnimalCount(animalType);
		
		if (animalTypeCount == 0) {
			switch (userChoice) {
			case "1":
				selectedOption = "ADD";
				break;
			case "2":
				selectedOption = "END";
				break;
			default:
				selectedOption = "ERROR";
				break;
			}
		} else if (animalTypeCount == maxAnimalTypeCount) {
			switch (userChoice) {
			case "1":
				selectedOption = "REMOVE";
				break;
			case "2":
				selectedOption = "VIEW";
				break;
			case "3":
				selectedOption = "FEED";
				break;
			case "4":
				selectedOption = "END";
				break;
			default:
				selectedOption = "ERROR";
				break;
			}
		} else {
			switch (userChoice) {
			case "1":
				selectedOption = "ADD";
				break;
			case "2":
				selectedOption = "REMOVE";
				break;
			case "3":
				selectedOption = "VIEW";
				break;
			case "4":
				selectedOption = "FEED";
				break;
			case "5":
				selectedOption = "END";
				break;
			default:
				selectedOption = "ERROR";
				break;
			}
		}

		return selectedOption;
	}

}
