package Ordinamento;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// TODO da testare
public class ReadCVS {

    private class Record {
	public String s;
	public Integer i;
	public Float f;

	public Record(String string, Integer integer, Float fl) {
	    this.s = string;
	    this.f = fl;
	    this.i = integer;
	}
    }

    private ArrayList<Record> table;

    public ReadCVS(File fileCVS, int min, int max) throws FileNotFoundException {
	table = new ArrayList<>(max - min);
	Scanner sc = new Scanner(fileCVS);
	for (int i = 0; i <= min; i++)
	    sc.skip("\n");
	for (int i = min; sc.hasNextLine() && i <= max; i++) {
	    String[] line = sc.nextLine().split(",");
	    table.add(new Record(line[1], Integer.parseInt(line[2]), Float.parseFloat(line[3])));
	}
	sc.close();
    }
}