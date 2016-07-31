package orderalgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import orderalgorithm.RecordCSV.Type;

public class ReadCSV implements Iterable<RecordCSV>{

    private File fileCSV;
    private Scanner scannerCSV;
    
    public ReadCSV(File fileCSV){
	this.fileCSV = fileCSV;
    }
    public void open() throws FileNotFoundException{
	scannerCSV = new Scanner(fileCSV);
    }
    public void close(){
	scannerCSV.close();
    }
    public RecordCSV fetch(){
	    String[] line = scannerCSV.nextLine().split(",");
	    return new RecordCSV(line[1], Integer.parseInt(line[2]), Float.parseFloat(line[3]));
    }
    public boolean hasNext(){
	return scannerCSV.hasNextLine();
    }
    @Override
    public Iterator<RecordCSV> iterator() {
	ReadCSV reader = this;
	return new Iterator<RecordCSV>(){
	    
	    @Override
	    public boolean hasNext() {
		return reader.hasNext();
	    }

	    @Override
	    public RecordCSV next() {
		return reader.fetch();
	    }
	    
	};
    }

    public static ArrayList<RecordCSV> getTable(File csvFile, int min, int max) throws FileNotFoundException {
	ArrayList<RecordCSV> table = new ArrayList<>();
	ReadCSV reader = new ReadCSV(csvFile);
	reader.open();
	int i = 0;
	for(RecordCSV record : reader){
	    if(i>= min && i<=max)
		table.add(record);
	    else
		if(i>max)
		    break;
	    i++;
	}
	reader.close();
	return table;
    }
    public static ArrayList<RecordCSV> getTable(int min, int max) throws FileNotFoundException {
	return getTable(new File("Data" + File.separator + "records.csv"), min, max);
    }

    public static void main(String args[]) throws FileNotFoundException {
	File csv = new File("Data" + File.separator + "records.csv");
	QuickSort<RecordCSV> ording = new QuickSort<>(RecordCSV.getComparator(Type.STRING));

	System.out.println("Inizio ordinamento");
	ArrayList<RecordCSV> arr = ReadCSV.getTable(csv, 0, 1000000 - 1);
	ording.quickSort(arr);

	System.out.println("Fine ordinamento: " + ording.isSorted(arr));
    }

}