package treelibrary;


import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import orderalgorithm.ReadCSV;
import orderalgorithm.RecordCSV;

public class DictionaryTestCSV {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Test(timeout = 30000)
    public void test1000ElementsKIntegerVStringDNTree() throws FileNotFoundException {
	ReadCSV csv = new ReadCSV(0, 1000);
	DNTree<Integer, String> dNT= new DNTree<Integer, String>((Integer a, Integer b) -> a.compareTo(b));
	
	for(RecordCSV record : csv.getTable())
	    dNT.put(record.i, record.s);
	    
    }
    @Test(timeout = 30000)
    public void test1000000ElementsKIntegerVStringDNTree() throws FileNotFoundException {
	ReadCSV csv = new ReadCSV(0, 1000000);
	DNTree<Integer, String> dNT= new DNTree<Integer, String>((Integer a, Integer b) -> a.compareTo(b));
	
	for(RecordCSV record : csv.getTable())
	    dNT.put(record.i, record.s);
    }
    @Test(timeout = 300000)
    public void test10000000ElementsKIntegerVStringDNTree() throws FileNotFoundException {
	ReadCSV csv = new ReadCSV(0, 10000000);
	DNTree<Integer, String> dNT= new DNTree<Integer, String>((Integer a, Integer b) -> a.compareTo(b));
	
	for(RecordCSV record : csv.getTable())
	    dNT.put(record.i, record.s);
    }
    @Test(timeout = 300000)
    public void test10000000ElementsKIntegerVStringDRBTree() throws FileNotFoundException {
	ReadCSV csv = new ReadCSV(0, 10000000);
	DRBTree<Integer, String> dNT= new DRBTree<Integer, String>((Integer a, Integer b) -> a.compareTo(b));
	
	for(RecordCSV record : csv.getTable())
	    dNT.put(record.i, record.s);
    }
    @Test(timeout = 30000)
    public void test1000000ElementsKIntegerVStringDRBTree() throws FileNotFoundException {
	ReadCSV csv = new ReadCSV(0, 1000000);
	DRBTree<Integer, String> dRBT = new DRBTree<Integer, String>((Integer a, Integer b) -> a.compareTo(b));
	
	for(RecordCSV record : csv.getTable())
	    dRBT.put(record.i, record.s);
    }
    @Test(timeout = 30000)
    public void test1000000ElementsKFloatVStringDNTree() throws FileNotFoundException {
	ReadCSV csv = new ReadCSV(0, 1000000);
	DNTree<Float, String> dNT= new DNTree<Float, String>((Float a, Float b) -> a.compareTo(b));
	
	for(RecordCSV record : csv.getTable())
	    dNT.put(record.f, record.s);
    }
}
