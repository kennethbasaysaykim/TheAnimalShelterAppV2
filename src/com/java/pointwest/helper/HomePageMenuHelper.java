package com.java.pointwest.helper;

import com.java.pointwest.bean.AnimalShelter;

public class HomePageMenuHelper {

	public static String getChoiceEquivalent(AnimalShelter animalShelter, String userChoice) {
		String selectedOption = "#";

			switch (userChoice) {
			case "1":
				selectedOption = "DOG";
				break;
			case "2":
				selectedOption = "CAT";
				break;
			case "3":
				selectedOption = "PARROT";
				break;
			case "4":
				selectedOption = "VIEW";
				break;
			case "5":
				selectedOption = "END";
				break;
			default:
				selectedOption = "ERROR";
				break;
			}
			return selectedOption;
	}
}
