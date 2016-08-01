package treelibrary;

/**
 * Test sul funzionamento della classe DRBTree sul file CSV fornito dal profettore
 * @throws Exception
 */
import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import orderalgorithm.ReadCSV;
import orderalgorithm.RecordCSV;

public class DictionaryTestCSV {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * Test sull'inserimento di 1000 elementi all'interno dell'albero
     * 
     * @throws FileNotFoundException
     */
    @Test(timeout = 30000)
    public void test1000ElementsKIntegerVStringDNTree() throws FileNotFoundException {
	DNTree<Integer, String> dNT = new DNTree<Integer, String>((Integer a, Integer b) -> a.compareTo(b));

	for (RecordCSV record : ReadCSV.getTable(0, 1000))
	    dNT.put(record.i, record.s);

    }

    /**
     * Test sull'inserimento di 1000000 elementi all'interno dell'albero
     * 
     * @throws FileNotFoundException
     */
    @Test(timeout = 30000)
    public void test1000000ElementsKIntegerVStringDNTree() throws FileNotFoundException {
	DNTree<Integer, String> dNT = new DNTree<Integer, String>((Integer a, Integer b) -> a.compareTo(b));

	for (RecordCSV record : ReadCSV.getTable(0, 1000000))
	    dNT.put(record.i, record.s);
    }

    /**
     * Test sull'inserimento di 10000000 elementi all'interno dell'albero
     * 
     * @throws FileNotFoundException
     */
    @Test(timeout = 300000)
    public void test10000000ElementsKIntegerVStringDNTree() throws FileNotFoundException {
	DNTree<Integer, String> dNT = new DNTree<Integer, String>((Integer a, Integer b) -> a.compareTo(b));

	for (RecordCSV record : ReadCSV.getTable(0, 10000000))
	    dNT.put(record.i, record.s);
    }

    /**
     * Test sull'inserimento di 10000000 elementi all'interno dell'albero
     * 
     * @throws FileNotFoundException
     */
    @Test(timeout = 300000)
    public void test10000000ElementsKIntegerVStringDRBTree() throws FileNotFoundException {
	DRBTree<Integer, String> dNT = new DRBTree<Integer, String>((Integer a, Integer b) -> a.compareTo(b));

	for (RecordCSV record : ReadCSV.getTable(0, 10000000))
	    dNT.put(record.i, record.s);
    }

    /**
     * Test sull'inserimento di 1000000 elementi all'interno dell'albero
     * 
     * @throws FileNotFoundException
     */
    @Test(timeout = 30000)
    public void test1000000ElementsKIntegerVStringDRBTree() throws FileNotFoundException {
	DRBTree<Integer, String> dRBT = new DRBTree<Integer, String>((Integer a, Integer b) -> a.compareTo(b));

	for (RecordCSV record : ReadCSV.getTable(0, 1000000))
	    dRBT.put(record.i, record.s);
    }

    /**
     * Test sull'inserimento di 1000000 elementi all'interno dell'albero
     * 
     * @throws FileNotFoundException
     */
    @Test(timeout = 30000)
    public void test1000000ElementsKFloatVStringDNTree() throws FileNotFoundException {
	DNTree<Float, String> dNT = new DNTree<Float, String>((Float a, Float b) -> a.compareTo(b));

	for (RecordCSV record : ReadCSV.getTable(0, 1000000))
	    dNT.put(record.f, record.s);
    }
}
