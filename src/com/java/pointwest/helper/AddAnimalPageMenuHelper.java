package com.java.pointwest.helper;

public class AddAnimalPageMenuHelper {
	public static String evaluateAnimalTypeChoice(String userChoice) {
		String selectedOption;
		
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
			selectedOption = "END";
			break;
			
		default:
			selectedOption = "ERROR";
			break;
		}
		return selectedOption;
	}
	
	public static String evaluateContinueMenuChoice(String userChoice) {
		String selectedOption = "#";
			
		switch (userChoice) {
		case "1":
			selectedOption = "CONTINUE";
			break;
		case "2":
			selectedOption = "END";
			break;
		default:
			selectedOption = "ERROR";
			break;
		}
		
		return selectedOption;
	}
}
