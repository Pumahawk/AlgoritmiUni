package orderalgorithm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapSortTest {

    class IntegerComparator implements Comparator<Integer> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Integer arg0, Integer arg1) {
	    return arg0.compareTo(arg1);
	}
    }

    public void testHeapSortBasic() {
	ArrayList<Integer> arrayTest = new ArrayList<Integer>();
	arrayTest.add(4);
	arrayTest.add(7);
	arrayTest.add(5);
	arrayTest.add(9);
	arrayTest.add(11);
	arrayTest.add(3);
	arrayTest.add(5);
	arrayTest.add(2);
	HeapSort<Integer> a = new HeapSort<Integer>(new IntegerComparator());
	a.sort(arrayTest);
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

    public void testHeapSortOrdered() {
	ArrayList<Integer> arrayTest = new ArrayList<Integer>();
	arrayTest.add(2);
	arrayTest.add(3);
	arrayTest.add(4);
	arrayTest.add(5);
	arrayTest.add(5);
	arrayTest.add(7);
	arrayTest.add(9);
	arrayTest.add(11);
	HeapSort<Integer> a = new HeapSort<Integer>(new IntegerComparator());
	a.sort(arrayTest);
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

    public void testHeapSortEmpty() {
	ArrayList<Integer> arrayTest = new ArrayList<Integer>();
	HeapSort<Integer> a = new HeapSort<Integer>(new IntegerComparator());
	a.sort(arrayTest);
	ArrayList<Integer> expected = new ArrayList<Integer>();
	assertEquals(arrayTest, expected);

    }

    public void testHeapSortOneElement() {
	ArrayList<Integer> arrayTest = new ArrayList<Integer>();
	arrayTest.add(7);
	HeapSort<Integer> a = new HeapSort<Integer>(new IntegerComparator());
	a.sort(arrayTest);
	ArrayList<Integer> expected = new ArrayList<Integer>();
	expected.add(7);
	assertEquals(arrayTest, expected);

    }

}
