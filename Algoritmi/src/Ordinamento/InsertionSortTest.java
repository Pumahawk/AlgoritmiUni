package Ordinamento;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;

public class InsertionSortTest {

    private class IntegerComparator implements Comparator<String> {
	@Override
	public int compare(String i1, String i2) {
	    return i1.compareTo(i2);
	}
    }

    @Test
    public void testIsSortedIntArraySuccess() {
	ArrayList<String> arrlist = new ArrayList<String>();
	arrlist.add("z");
	arrlist.add("a");
	arrlist.add("b");
	arrlist.add("c");
	InsertionSort<String> a = new InsertionSort<String>(new IntegerComparator());
	a.print(arrlist);
	a.sort(arrlist);
	a.print(arrlist);
	assertTrue(InsertionSort.isSorted(arrlist));
    }

    /*
     * @Test public void testIsSortedIntArrayFailure() { int [] array =
     * {0,1,2,3,4,5,6,7,8,10,40,32,32};
     * assertFalse(InsertionSort.isSorted(array)); }
     * 
     * @Test public void testIsSortedIntArrayAllValueEquals() { int [] array =
     * {32,32,32,32,32}; assertTrue(InsertionSort.isSorted(array)); }
     * 
     * @Test public void testSsort() { int [] array =
     * {0,3,2,1,4,2,6,9,8,44,10,40,32,32}; Sorting.ssort(array);
     * assertTrue(InsertionSort.isSorted(array)); }
     * 
     * @Test public void testIsort() { int [] array =
     * {0,3,2,1,4,2,6,9,8,44,10,40,32,32}; Sorting.isort(array);
     * assertTrue(InsertionSort.isSorted(array)); }
     * 
     * /* @Test public void testIsortBin() { int [] array =
     * {0,3,2,1,4,2,6,9,8,44,10,40,32,32}; InsertionSort.isortBin(array);
     * assertTrue(InsertionSort.isSorted(array)); }
     * 
     * @Test public void testQsortHoareTArray() { Character [] array =
     * {'c','d','f','r','a','n','h','m','j','w','e','r','g','b'};
     * InsertionSort.qsortHoare(array); Character [] expected =
     * {'a','b','c','d','e','f','g','h','j','m','n','r','r','w'};
     * assertArrayEquals(array,expected); }
     * 
     * @Test public void testParallelQuickSortHoareTArrayIntIntInt() { Character
     * [] array = {'c','d','f','r','a','n','h','m','j','w','e','r','g','b'};
     * InsertionSort.parallelQuickSortHoare(array); Character [] expected =
     * {'a','b','c','d','e','f','g','h','j','m','n','r','r','w'};
     * assertArrayEquals(array,expected); }
     * 
     * @Test public void testParallelMSortIntArray() { int [] arrayTest =
     * {0,9,8,7,6,5,4,4,3,2,1}; Sorting.parallelMSort(arrayTest); int []
     * expected = {0,1,2,3,4,4,5,6,7,8,9};
     * assertArrayEquals(expected,arrayTest); }
     * 
     * @Test public void testMergeSortBasic(){ int [] arrayTest =
     * {0,9,8,7,6,5,4,4,3,2,1}; Sorting.msortBasicEcologic(arrayTest); int []
     * expected = {0,1,2,3,4,4,5,6,7,8,9};
     * assertArrayEquals(arrayTest,expected); }
     * 
     * @Test public void heapSortTest(){ int [] arrayTest =
     * {0,9,8,7,6,5,4,4,3,2,1}; Sorting.heapsort(arrayTest); int [] expected =
     * {0,1,2,3,4,4,5,6,7,8,9}; assertArrayEquals(arrayTest,expected); }
     * 
     * @Test public void heapSortTestEmpty(){ int [] arrayTest = {};
     * Sorting.heapsort(arrayTest); int [] expected = {};
     * assertArrayEquals(arrayTest,expected); }
     */
}
