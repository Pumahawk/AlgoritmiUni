package esercizio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio3 {

    public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	ArrayList<Node> nodeList = new ArrayList<Node>();
	String csvLine = ""; // the string will contain a line of csv file
	String csvFile = "C://Users/UMIT AHMED/workspace/Esercizio3/src/italian_dist_graph.csv";

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

		int place_1 = -1, place_2 = -1, index_1, index_2;

		for (index_1 = 0; index_1 < nodeList.size(); index_1++) {
		    if (field[0].compareTo(nodeList.get(index_1).getCity()) == 0) {
			place_1 = index_1;
			// System.out.println(where_1 + " <--- where_1 ");
			// System.out.println(index_1 + " <--- index_1 ");
			break;
		    }
		}

		for (index_2 = 0; index_2 < nodeList.size(); index_2++) {
		    if (field[1].compareTo(nodeList.get(index_2).getCity()) == 0) {
			place_2 = index_2;
			// System.out.println(where_2 + " <--- where_2 ");
			// System.out.println(index_2 + " <--- index_2 ");
			break;
		    }
		}

		if (place_2 == -1) {
		    Node node_2 = new Node(field[1]);
		    nodeList.add(node_2);
		    place_2 = nodeList.size() - 1;
		}

		if (place_1 == -1) {
		    Node node_1 = new Node(field[0]);
		    nodeList.add(node_1);
		    place_1 = nodeList.size() - 1;
		}

		Edge edge1 = new Edge(nodeList.get(place_2), convertInDouble(field[2]));
		nodeList.get(place_1).getAdjacents().add(edge1);

		Edge edge2 = new Edge(nodeList.get(place_1), convertInDouble(field[2]));
		nodeList.get(place_2).getAdjacents().add(edge2);
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

	while (true) {
	    System.out.println("Inserire citta' di origine e destinazione");
	    String origin = sc.next();
	    String destination = sc.next();
	    int indexDest = -1, indexOrigin = -1;
	    for (int i = 0; i < nodeList.size(); i++) {
		if (destination.compareTo(nodeList.get(i).getCity()) == 0) {
		    indexDest = i;
		}
	    }

	    for (int i = 0; i < nodeList.size(); i++) {
		if (origin.compareTo(nodeList.get(i).getCity()) == 0) {
		    indexOrigin = i;
		}
	    }

	    if (indexOrigin == -1 || indexDest == -1) {
		System.out.println("Origine e/o destinazione inesistenti");
	    } else {

		ArrayList<Node> arr = new ArrayList<Node>();
		arr = Graph.getShortestPathTo(nodeList, nodeList.get(indexOrigin), nodeList.get(indexDest));
		double distance = 0f;
		System.out.print("Percorso: ");
		for (int i = 0; i < arr.size(); i++) {
		    System.out.print(arr.get(i) + "     ");
		    for (int j = 0; j < arr.get(i).getAdjacents().size() && i < arr.size() - 1; j++) {
			if (arr.get(i).getAdjacents().get(j).getLinkedTo().compareTo(arr.get(i + 1)) == 0) {
			    distance += arr.get(i).getAdjacents().get(j).getEdgeValue();
			    break;
			}
		    }
		}
		System.out.println("");
		System.out.println("la distanza tra i due posti è di " + distance / 1000 + " km");
	    }

	}

    }// end main

    // Function to convert from string to float
    public static double convertInDouble(String s) {
	return Double.valueOf(s.trim()).doubleValue();
    }

}// end class
