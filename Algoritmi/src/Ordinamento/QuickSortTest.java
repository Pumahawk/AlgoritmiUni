package Ordinamento;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

public class QuickSortTest {
    public static class IntegerComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer i1, Integer i2) {
	    return i1.compareTo(i2);
	}
    }

    @Test
    public void heapSortTest() {
	Integer[] arrayTest = { 4, 7, 9, 2, 3, 1, 66, 33, 22, 63, 2 };
	QuickSort<Integer> a = new QuickSort<Integer>(new IntegerComparator());
	a.quickSort(arrayTest);
	Integer[] expected = { 1, 2, 2, 3, 4, 7, 9, 22, 33, 63, 66 };
	assertEquals(expected, arrayTest);
    }

    @Test
    public void heapSortTestEmpty() {
	Integer[] arrayTest = {};
	QuickSort<Integer> a = new QuickSort<Integer>(new IntegerComparator());
	a.quickSort(arrayTest);
	Integer[] expected = {};
	assertEquals(expected, arrayTest);
    }

    @Test
    public void heapSortTestOneElement() {
	Integer[] arrayTest = { 5 };
	QuickSort<Integer> a = new QuickSort<Integer>(new IntegerComparator());
	a.quickSort(arrayTest);
	Integer[] expected = { 5 };
	assertEquals(expected, arrayTest);
    }

    @Test
    public void heapSortTestTwoElement() {
	Integer[] arrayTest = { 5, 0 };
	QuickSort<Integer> a = new QuickSort<Integer>(new IntegerComparator());
	a.quickSort(arrayTest);
	Integer[] expected = { 0, 5 };
	assertEquals(expected, arrayTest);
    }

    /*
     * public static void main(String[] args) { Integer[] integ = { 4, 7, 9, 2,
     * 3, 1, 66, 33, 22, 63, 2 };
     * 
     * QuickSort<Integer> a = new QuickSort<Integer>(new IntegerComparator());
     * a.print(integ); a.sort(integ); a.print(integ);
     * 
     * }
     */

}
