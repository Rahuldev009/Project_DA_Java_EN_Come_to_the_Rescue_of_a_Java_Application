package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


/**
 * Store each symptom name and its count
 * Alphabetically sort it and write them to an output file
 * Hashmap to store and count symptoms
 * ArrayList to store and sort
 *
 */
public class AnalyticsCounter {


	private HashMap<String,Integer> symptomsWithOccurrence ;
	private ArrayList <String> fileAsArrayList;
	private ArrayList <String> sortedSymptoms;


	 AnalyticsCounter (){
		 symptomsWithOccurrence = new HashMap<>();
		 sortedSymptoms = new ArrayList<>();
		 fileAsArrayList = new ArrayList<>();

	 }


	 /**
	 *
	 * @throws IOException
	 * Read The contents of the Input file and stores the into an Arraylist
	 *
	 */
	void readSymptomsFile() throws IOException {
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(
				"../Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse" +
						"/symptoms.txt");
		fileAsArrayList = (ArrayList<String>) readSymptomDataFromFile.getSymptoms();


	}


	/***
	 *
	 * @throws IOException
	 * The method takes the ArrayList as an input which will have all the contents of file.
	 * The Contents then parsed and stored in an ArrayList.
	 *
	 */
	void countSymptoms() throws IOException {

		int countOccurrence = 0;

		for (int symptoms = 0; symptoms < fileAsArrayList.size() ;symptoms++){
			if (symptomsWithOccurrence.containsKey(fileAsArrayList.get(symptoms).toString())){
				countOccurrence = symptomsWithOccurrence.get(fileAsArrayList.get(symptoms).toString()) + 1;
				symptomsWithOccurrence.replace(fileAsArrayList.get(symptoms).toString(),countOccurrence);
			}

			else {
				symptomsWithOccurrence.put(fileAsArrayList.get(symptoms).toString(),1);
			}

		}
		symptomsWithOccurrence.forEach((k,v)->sortedSymptoms.add(k +" "+ ":" + " "+v));


	}


	/**
	 *
	 * @throws IOException
	 * Sort the contents of the ArrayList in alphabetical order
	 */
	void sortingList() throws IOException {

		Collections.sort(sortedSymptoms);


	}


	/***
	 *
	 *
	 * @throws IOException
	 * The method takes an ArrayList and writes the contents to a file.
	 */
	void writtenOutput() throws IOException {

		FileWriter writer = new FileWriter ("result.out");
		for (int symptoms = 0; symptoms < sortedSymptoms.size() ;symptoms++) {
			writer.write(sortedSymptoms.get(symptoms)+ "\n");
		}
		writer.close();

	}


	/**
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {

		AnalyticsCounter analyticsCounter= new AnalyticsCounter();

		analyticsCounter.readSymptomsFile();
		analyticsCounter.countSymptoms();
		analyticsCounter.sortingList();
		analyticsCounter.writtenOutput();



	}


}

