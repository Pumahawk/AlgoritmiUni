package Ordinamento;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Ordinamento.RecordCSV.Type;

// TODO da testare
public class ReadCVS {

    private ArrayList<RecordCSV> table;

    public ReadCVS(File fileCVS, int min, int max) throws FileNotFoundException {
	/*
	 * if (max - min > 0) table = new ArrayList<>(max - min); else table =
	 * new ArrayList<>(20000000);
	 */
	table = new ArrayList<>();
	Scanner sc = new Scanner(fileCVS);
	for (int i = 0; i < min && sc.hasNextLine(); i++)
	    sc.nextLine();
	for (int i = min; sc.hasNextLine() && i != max + 1; i++) {
	    String[] line = sc.nextLine().split(",");
	    table.add(new RecordCSV(line[1], Integer.parseInt(line[2]), Float.parseFloat(line[3])));
	}
	sc.close();
    }

    public ArrayList<RecordCSV> getTable() {
	return table;
    }

    public static void main(String args[]) throws FileNotFoundException {
	File cvs = new File("Data" + File.separator + "records.csv");
	ReadCVS table = new ReadCVS(cvs, 0, 1000000 - 1);
	QuickSort<RecordCSV> ording = new QuickSort<>(RecordCSV.getComparator(Type.STRING));

	System.out.println("Inizio ordinamento");

	ording.quickSort(table.getTable());
	// for (RecordCSV rec : table.getTable())
	// System.out.println(rec.s);
	System.out.println("Fine ordinamento: " + ording.isSorted(table.getTable()));
    }

}