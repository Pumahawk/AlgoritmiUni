package orderalgorithm;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import orderalgorithm.RecordCSV.Type;

public class SortTest {
    public static ReadCSV cvs;
    public static ArrayList<RecordCSV> cvsInsertionSort;
    public static ArrayList<RecordCSV> cvsHeapSort;
    public static ArrayList<RecordCSV> cvsQuickSort;
    public static ArrayList<RecordCSV> cvsMergeSort;

    @BeforeClass
    public static void loadCVS() throws FileNotFoundException {
	System.out.println("Caricamento file:");
	cvs = new ReadCSV(0, 20000);
	System.out.println("Copia dati per InsertionSort.");
	cvsInsertionSort = (ArrayList<RecordCSV>) cvs.getTable().clone();
	System.out.println("Copia dati per HeapSort.");
	cvsHeapSort = (ArrayList<RecordCSV>) cvs.getTable().clone();
	System.out.println("Copia dati per QuickSort.");
	cvsQuickSort = (ArrayList<RecordCSV>) cvs.getTable().clone();
	System.out.println("Copia dati per MergeSort.");
	cvsMergeSort = (ArrayList<RecordCSV>) cvs.getTable().clone();
	System.out.println("File caricato.");
    }

    @Test(timeout = 30000)
    public void testInsertionSortString() {
	Sort.sortInsertionSort(cvsInsertionSort, RecordCSV.getComparator(Type.STRING));
	assertTrue(Sort.isSorted(cvsInsertionSort.iterator(), RecordCSV.getComparator(Type.STRING)));
    }

    @Test(timeout = 30000)
    public void testInsertionSortInteger() {
	Sort.sortInsertionSort(cvsInsertionSort, RecordCSV.getComparator(Type.INTEGER));
	assertTrue(Sort.isSorted(cvsInsertionSort.iterator(), RecordCSV.getComparator(Type.INTEGER)));
    }

    @Test(timeout = 30000)
    public void testInsertionSortFloat() {
	Sort.sortInsertionSort(cvsInsertionSort, RecordCSV.getComparator(Type.FLOAT));
	assertTrue(Sort.isSorted(cvsInsertionSort.iterator(), RecordCSV.getComparator(Type.FLOAT)));
    }

    @Test(timeout = 30000)
    public void testQuickSortString() {
	Sort.sortQuickSort(cvsQuickSort, RecordCSV.getComparator(Type.STRING));
	assertTrue(Sort.isSorted(cvsQuickSort.iterator(), RecordCSV.getComparator(Type.STRING)));
    }

    @Test(timeout = 30000)
    public void testQuickSortInteger() {
	Sort.sortQuickSort(cvsQuickSort, RecordCSV.getComparator(Type.INTEGER));
	assertTrue(Sort.isSorted(cvsQuickSort.iterator(), RecordCSV.getComparator(Type.INTEGER)));
    }

    @Test(timeout = 30000)
    public void testQuickSortFloat() {
	Sort.sortQuickSort(cvsQuickSort, RecordCSV.getComparator(Type.FLOAT));
	assertTrue(Sort.isSorted(cvsQuickSort.iterator(), RecordCSV.getComparator(Type.FLOAT)));
    }

    @Test(timeout = 30000)
    public void testHeapSortString() {
	Sort.sortHeapSort(cvsHeapSort, RecordCSV.getComparator(Type.STRING));
	assertTrue(Sort.isSorted(cvsHeapSort.iterator(), RecordCSV.getComparator(Type.STRING)));
    }

    @Test(timeout = 30000)
    public void testHeapSortInteger() {
	Sort.sortHeapSort(cvsHeapSort, RecordCSV.getComparator(Type.INTEGER));
	assertTrue(Sort.isSorted(cvsHeapSort.iterator(), RecordCSV.getComparator(Type.INTEGER)));
    }

    @Test(timeout = 30000)
    public void testHeapSortFloat() {
	Sort.sortHeapSort(cvsHeapSort, RecordCSV.getComparator(Type.FLOAT));
	assertTrue(Sort.isSorted(cvsHeapSort.iterator(), RecordCSV.getComparator(Type.FLOAT)));
    }

    @Test(timeout = 30000)
    public void testMergeSortString() {
	Sort.sortMergeSort(cvsMergeSort, RecordCSV.getComparator(Type.STRING));
	assertTrue(Sort.isSorted(cvsMergeSort.iterator(), RecordCSV.getComparator(Type.STRING)));
    }

    @Test(timeout = 30000)
    public void testMergeSortInteger() {
	Sort.sortMergeSort(cvsMergeSort, RecordCSV.getComparator(Type.INTEGER));
	assertTrue(Sort.isSorted(cvsMergeSort.iterator(), RecordCSV.getComparator(Type.INTEGER)));
    }

    @Test(timeout = 30000)
    public void testMergeSortFloat() {
	Sort.sortMergeSort(cvsMergeSort, RecordCSV.getComparator(Type.FLOAT));
	assertTrue(Sort.isSorted(cvsMergeSort.iterator(), RecordCSV.getComparator(Type.FLOAT)));
    }
}
