package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;



public class AnalyticsCounter {


	/***
	 *
	 * @param result It contains the input from the file
	 * @return list of sorted symptoms with their count
	 * @throws IOException
	 */
	ArrayList countSymptomsAlphabetically(ArrayList result) throws IOException {

		int countOccurrence = 0;

		ArrayList <String> sortedSymptoms = new ArrayList<>();

		HashMap<String,Integer> symptomsWithOccurrence = new HashMap<>();

		for (int i=0;i<result.size();i++){
			if (symptomsWithOccurrence.containsKey(result.get(i).toString())){
				countOccurrence = symptomsWithOccurrence.get(result.get(i).toString())+1;
				symptomsWithOccurrence.replace(result.get(i).toString(),countOccurrence);
			}

			else {
				symptomsWithOccurrence.put(result.get(i).toString(),1);
			}

		}

		symptomsWithOccurrence.forEach((k,v)->sortedSymptoms.add(k +" "+ ":" + " "+v));
		Collections.sort(sortedSymptoms);
		return sortedSymptoms;

	}

	/***
	 *
	 * @param list contain the sorted symptoms in Arraylist
	 * @throws IOException
	 */
	void writtenOutput(ArrayList list) throws IOException {

		FileWriter writer = new FileWriter ("result.out");
		for (int i = 0; i <list.size() ; i++) {
			writer.write(list.get(i)+ "\n");
		}
		writer.close();

	}


	public static void main(String args[]) throws IOException {

		ArrayList <String> outputList;

		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("/Users/rahuljajoria/" +
				"Desktop/GitProjects/"
				+ "GitHub/deliverable1/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse" +
				"/symptoms.txt");

		outputList = (ArrayList<String>) readSymptomDataFromFile.getSymptoms();

		AnalyticsCounter analyticsCounter= new AnalyticsCounter();

		outputList = analyticsCounter.countSymptomsAlphabetically(outputList);

		analyticsCounter.writtenOutput(outputList);


	}


}

