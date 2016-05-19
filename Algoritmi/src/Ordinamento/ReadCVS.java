package Ordinamento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class ReadCVS {

    private String s;
    private int i;
    private float f;

    private static class IntegerComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer i1, Integer i2) {
	    return i1.compareTo(i2);
	}
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

	ReadCVS obj = new ReadCVS();
	obj.run();

    }

    public void run() throws NumberFormatException, IOException {

	String csvFile = "C://Users/UMIT AHMED/workspace/Algoritmi/src/Ordinamento/records.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	int i = 0;
	ArrayList<String> field1 = new ArrayList<String>();
	ArrayList<Integer> field2 = new ArrayList<Integer>();
	ArrayList<Float> field3 = new ArrayList<Float>();
	ArrayList<ReadCVS> field = new ArrayList<ReadCVS>();
	try {

	    br = new BufferedReader(new FileReader(csvFile));
	    while ((line = br.readLine()) != null) {

		// use comma as separator
		String[] rec = line.split(cvsSplitBy);
		ReadCVS e = new ReadCVS();
		e.s = rec[1];
		e.i = Integer.parseInt(rec[2]);
		e.f = Float.parseFloat(rec[3]);
		System.out.println(e.i);
		field.add(e);

		field1.add(e.s);
		field2.add(e.i);
		field3.add(e.f);

		i++;

	    }

	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}

	System.out.println("Numero degli elementi da ordinare" + i + "\n");
	QuickSort<Integer> a = new QuickSort<Integer>(new IntegerComparator());
	a.print2(field2);
	System.out.println("QuickSort \n");
	// a.sort(field2);
	// a.print(field2);

    }

}