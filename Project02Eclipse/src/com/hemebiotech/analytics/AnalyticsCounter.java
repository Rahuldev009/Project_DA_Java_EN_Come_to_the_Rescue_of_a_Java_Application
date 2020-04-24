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
	 private ArrayList <String> sortedSymptoms;


	 AnalyticsCounter (){
		 symptomsWithOccurrence = new HashMap<>();
		 sortedSymptoms = new ArrayList<>();
	 }

	/***
	 *
	 * @param inputFromFile It contains the input from the file
	 * @throws IOException
	 * The method takes the ArrayList as an input which will have all the contents of file.
	 * The Contents then parsed and sorted according to requirement and again copied
	 * to an ArrayList, to be written to an output file.
	 *
	 */
	void countSymptomsAlphabetically(ArrayList inputFromFile) throws IOException {

		int countOccurrence = 0;

		for (int symptoms = 0; symptoms < inputFromFile.size() ;symptoms++){
			if (symptomsWithOccurrence.containsKey(inputFromFile.get(symptoms).toString())){
				countOccurrence = symptomsWithOccurrence.get(inputFromFile.get(symptoms).toString()) + 1;
				symptomsWithOccurrence.replace(inputFromFile.get(symptoms).toString(),countOccurrence);
			}

			else {
				symptomsWithOccurrence.put(inputFromFile.get(symptoms).toString(),1);
			}

		}

		symptomsWithOccurrence.forEach((k,v)->sortedSymptoms.add(k +" "+ ":" + " "+v));
		Collections.sort(sortedSymptoms);
		writtenOutput();


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

		ArrayList <String> FileAsArrayList;

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(
				"../Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse" +
				"/symptoms.txt");

		FileAsArrayList = (ArrayList<String>) readSymptomDataFromFile.getSymptoms();

		AnalyticsCounter analyticsCounter= new AnalyticsCounter();

		analyticsCounter.countSymptomsAlphabetically(FileAsArrayList);



	}


}

