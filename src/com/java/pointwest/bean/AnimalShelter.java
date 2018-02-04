package com.java.pointwest.bean;

import java.util.List;
import java.util.Map;

public class AnimalShelter {

	private Map<String, List<Animal>> shelter;

	private int totalAnimalCount;
	private int totalDogCount;
	private int totalCatCount;
	private int totalParrotCount;
	private int maxAnimalCount = 15;
	private int maxDogCount = 5;
	private int maxCatCount = 5;
	private int maxParrotCount = 5;

	public int getAnimalCount(String animalType) {
		int animalCount = 0;

		switch (animalType.toUpperCase()) {
		case "DOG":
			animalCount = totalDogCount;
			break;

		case "CAT":
			animalCount = totalCatCount;
			break;

		case "PARROT":
			animalCount = totalParrotCount;
			break;
		}
		return animalCount;
	}

	public int getMaxAnimalCount(String animalType) {
		int maxAnimalCount = 0;
		
		switch (animalType.toUpperCase()) {
		case "DOG":
			maxAnimalCount = maxDogCount;
			break;

		case "CAT":
			maxAnimalCount = maxCatCount;
			break;

		case "PARROT":
			maxAnimalCount = maxParrotCount;
			break;
		}
		return maxAnimalCount;
	}
	
	public Map<String, List<Animal>> getShelter() {
		return shelter;
	}
	
	public void setShelter(Map<String, List<Animal>> shelter) {
		this.shelter = shelter;
	}
	
	public int getTotalAnimalCount() {
		return totalDogCount + totalCatCount + totalParrotCount;
	}

	public void setTotalAnimalCount(int totalAnimalCount) {
		this.totalAnimalCount = totalAnimalCount;
	}
	
	public int getTotalDogCount() {
		return totalDogCount;
	}

	public void setTotalDogCount(int totalDogCount) {
		this.totalDogCount = totalDogCount;
	}

	public int getTotalCatCount() {
		return totalCatCount;
	}

	public void setTotalCatCount(int totalCatCount) {
		this.totalCatCount = totalCatCount;
	}

	public int getTotalParrotCount() {
		return totalParrotCount;
	}
	
	public void setTotalParrotCount(int totalParrotCount) {
		this.totalParrotCount = totalParrotCount;
	}

	public int getMaxAnimalCount() {
		return maxAnimalCount;
	}
	
	public int getMaxDogCount() {
		return maxDogCount;
	}

	public int getMaxCatCount() {
		return maxCatCount;
	}
	
	public int getMaxParrotCount() {
		return maxParrotCount;
	}
	
	
}
