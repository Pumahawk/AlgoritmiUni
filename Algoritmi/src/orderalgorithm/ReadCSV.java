package orderalgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import orderalgorithm.RecordCSV.Type;

/**
 * classe che permette di estrarre i dati dal file CSV
 */
public class ReadCSV implements Iterable<RecordCSV> {

    private File fileCSV;
    private Scanner scannerCSV;

    public ReadCSV(File fileCSV) {
	this.fileCSV = fileCSV;
    }

    /**
     * Apre il file
     * 
     * @throws FileNotFoundException
     */
    public void open() throws FileNotFoundException {
	scannerCSV = new Scanner(fileCSV);
    }

    /**
     * chiude il file
     */
    public void close() {
	scannerCSV.close();
    }

    /**
     * Legge una riga del file csv
     * 
     * @return la riga del file in formato RecordCSV
     */
    public RecordCSV fetch() {
	String[] line = scannerCSV.nextLine().split(",");
	return new RecordCSV(line[1], Integer.parseInt(line[2]), Float.parseFloat(line[3]));
    }

    /**
     * Controlla se c'è ancora una riga da leggere
     * 
     */
    public boolean hasNext() {
	return scannerCSV.hasNextLine();
    }

    @Override
    public Iterator<RecordCSV> iterator() {
	ReadCSV reader = this;
	return new Iterator<RecordCSV>() {

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

    /**
     * Restituisce un array contente i record del file csvFile che vanno dal min
     * al max
     * 
     * @param csvFile
     * @param min
     * @param max
     * @return ArrayList di record
     * @throws FileNotFoundException
     */
    public static ArrayList<RecordCSV> getTable(File csvFile, int min, int max) throws FileNotFoundException {
	ArrayList<RecordCSV> table = new ArrayList<>();
	ReadCSV reader = new ReadCSV(csvFile);
	reader.open();
	int i = 0;
	for (RecordCSV record : reader) {
	    if (i >= min && i <= max)
		table.add(record);
	    else if (i > max)
		break;
	    i++;
	}
	reader.close();
	return table;
    }

    public static ArrayList<RecordCSV> getTable(int min, int max) throws FileNotFoundException {
	return getTable(new File("Data" + File.separator + "records.csv"), min, max);
    }

    /*
     * Piccolo test della classe nel main
     */
    public static void main(String args[]) throws FileNotFoundException {
	File csv = new File("Data" + File.separator + "records.csv");
	QuickSort<RecordCSV> ording = new QuickSort<>(RecordCSV.getComparator(Type.STRING));

	System.out.println("Inizio ordinamento");
	ArrayList<RecordCSV> arr = ReadCSV.getTable(csv, 0, 1000000 - 1);
	ording.quickSort(arr);

	System.out.println("Fine ordinamento: " + ording.isSorted(arr));
    }

}