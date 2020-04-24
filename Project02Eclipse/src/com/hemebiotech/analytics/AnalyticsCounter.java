package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


/**
 * Store each symptom name and its count
 * Alphabetically sort it and write them to an output file
 * Contains
 *
 */
public class AnalyticsCounter {

	 private HashMap<String,Integer> symptomsWithOccurrence ;

	 AnalyticsCounter (){
		 symptomsWithOccurrence = new HashMap<>();
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

		ArrayList <String> sortedSymptoms = new ArrayList<>();



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
		writtenOutput(sortedSymptoms);

	}

	/***
	 *
	 * @param list contain the sorted symptoms in Arraylist
	 * @throws IOException
	 * The method takes an ArrayList and writes the contents to a file.
	 */
	void writtenOutput(ArrayList list) throws IOException {

		FileWriter writer = new FileWriter ("result.out");
		for (int symptoms = 0; symptoms < list.size() ;symptoms++) {
			writer.write(list.get(symptoms)+ "\n");
		}
		writer.close();

	}

	/**
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {

		ArrayList <String> outputList;

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(
				"../Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse" +
				"/symptoms.txt");

		outputList = (ArrayList<String>) readSymptomDataFromFile.getSymptoms();

		AnalyticsCounter analyticsCounter= new AnalyticsCounter();

		analyticsCounter.countSymptomsAlphabetically(outputList);



	}


}

