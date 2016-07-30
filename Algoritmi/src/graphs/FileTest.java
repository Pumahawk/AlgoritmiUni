package graphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class FileTest {
    public static Graph<String> getGraph(String pathFileCSV) {

	Graph<String> citta = new Graph<>();
	HashMap<Integer, String> arr = new HashMap<>();

	String csvLine = ""; // the string will contain a line of csv file
	String csvFile = pathFileCSV;

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

		String c1, c2;
		c1 = arr.get(field[0].hashCode());
		c2 = arr.get(field[1].hashCode());

		if (c1 == null) {
		    c1 = field[0];
		    citta.addVertex(c1);
		    arr.put(c1.hashCode(), c1);
		}
		if (c2 == null) {
		    c2 = field[1];
		    citta.addVertex(c2);
		    arr.put(c2.hashCode(), c2);
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
	}
	return citta;
    }

    public static String retCitta(ArrayList<String> arr, String st) {
	for (String c : arr)
	    if (c.compareTo(st) == 0)
		return c;
	return null;
    }
}
