package orderalgorithm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;

class MergeSortTest {
    private static class IntegerComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer i1, Integer i2) {
	    return i1.compareTo(i2);
	}
    }

    @Test
    public void testMergeSortBasic() {
	ArrayList<Integer> arrayTest = new ArrayList<Integer>();
	arrayTest.add(4);
	arrayTest.add(7);
	arrayTest.add(5);
	arrayTest.add(9);
	arrayTest.add(11);
	arrayTest.add(3);
	arrayTest.add(5);
	arrayTest.add(2);
	MergeSort<Integer> a = new MergeSort<Integer>(new IntegerComparator());
	a.msortBasicEcologic(arrayTest);
	ArrayList<Integer> expected = new ArrayList<Integer>();
	expected.add(2);
	expected.add(3);
	expected.add(4);
	expected.add(5);
	expected.add(5);
	expected.add(7);
	expected.add(9);
	expected.add(11);
	assertEquals(arrayTest, expected);

    }

    @Test
    public void testMergeSortOrdered() {
	ArrayList<Integer> arrayTest = new ArrayList<Integer>();
	arrayTest.add(2);
	arrayTest.add(3);
	arrayTest.add(4);
	arrayTest.add(5);
	arrayTest.add(5);
	arrayTest.add(7);
	arrayTest.add(9);
	arrayTest.add(11);
	MergeSort<Integer> a = new MergeSort<Integer>(new IntegerComparator());
	a.msortBasicEcologic(arrayTest);
	ArrayList<Integer> expected = new ArrayList<Integer>();
	expected.add(2);
	expected.add(3);
	expected.add(4);
	expected.add(5);
	expected.add(5);
	expected.add(7);
	expected.add(9);
	expected.add(11);
	assertEquals(arrayTest, expected);

    }

    @Test
    public void testMergeSortEmpty() {
	ArrayList<Integer> arrayTest = new ArrayList<Integer>();
	MergeSort<Integer> a = new MergeSort<Integer>(new IntegerComparator());
	a.msortBasicEcologic(arrayTest);
	ArrayList<Integer> expected = new ArrayList<Integer>();
	assertEquals(arrayTest, expected);

    }

    @Test
    public void testMergeSortBasicOneElement() {
	ArrayList<Integer> arrayTest = new ArrayList<Integer>();
	arrayTest.add(4);
	MergeSort<Integer> a = new MergeSort<Integer>(new IntegerComparator());
	a.msortBasicEcologic(arrayTest);
	ArrayList<Integer> expected = new ArrayList<Integer>();
	expected.add(4);
	assertEquals(arrayTest, expected);

    }

}
