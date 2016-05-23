package Ordinamento;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.Comparator;

import org.junit.BeforeClass;
import org.junit.Test;

import Ordinamento.RecordCSV.Type;

public class QuickSortTest {
    public static class IntegerComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer i1, Integer i2) {
	    return i1.compareTo(i2);
	}
    }

    public static ReadCVS cvs;

    @BeforeClass
    public static void loadCVS() throws FileNotFoundException {
	cvs = new ReadCVS(0, 4000000);
    }

    @Test
    public void heapSortTest() throws FileNotFoundException {
	QuickSort<RecordCSV> a = new QuickSort<RecordCSV>(RecordCSV.getComparator(Type.STRING));
	a.quickSort(cvs.getTable());
	assertTrue(Sort.isSorted(cvs.getTable().iterator(), RecordCSV.getComparator(Type.STRING)));
    }

}
