package Graphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FIleTest {
    public static void main(String args[]){
	

	Graph<String> citta = new Graph<>();
	ArrayList<String> arr = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	String csvLine = ""; // the string will contain a line of csv file
	String csvFile = "C:\\Users\\Lorenzo Gandino\\Desktop\\italian_dist_graph.csv";

	BufferedReader br = null;
	System.out.println("Attendere estrazione dati");
	int c = 0;

	try {
	    br = new BufferedReader(new FileReader(csvFile));
	    while ((csvLine = br.readLine()) != null) {
		c++; // count the lines witch have my csvFile
		if (c % 1000 == 0) {
		    System.out.println(c);
		}
		String[] field = csvLine.split(",");
		
		String c1,c2;
		c1 = retCitta(arr, field[0]);
		c2 = retCitta(arr, field[1]);
		
		if(c1 == null){
		    c1 = field[0];
		    citta.addVertex(c1);
		    arr.add(c1);
		}
		if(c2 == null){
		    c2 = field[1];
		    citta.addVertex(c2);
		    arr.add(c2);
		}
		citta.link(c1, c2, Float.parseFloat(field[2]));
		citta.link(c2, c1, Float.parseFloat(field[2]));
	    } // end while
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (br != null) {
		try {
		    br.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	} // end finally
	citta.stampaPercorso("torino", "catania");
    }// end main

    // Function to convert from string to float
    public static double convertInDouble(String s) {
	return Double.valueOf(s.trim()).doubleValue();
    }

    public static String retCitta(ArrayList<String> arr, String st){
	for(String c : arr)
	    if(c.compareTo(st) == 0)
		return c;
	return null;
    }
}
