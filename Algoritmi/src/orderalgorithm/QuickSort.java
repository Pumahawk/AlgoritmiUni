package orderalgorithm;

import java.util.ArrayList;
import java.util.Comparator;

public class QuickSort<T> {
    private Comparator<T> comparator;

    /**
     * @param comparator
     */
    public QuickSort(Comparator<T> comparator) {
	this.comparator = comparator;
    }

    /**
     * @param a
     */
    public void sort(ArrayList<T> a) {
	quickSort(a);
    }

    /**
     * @param a
     */
    public void quickSort(ArrayList<T> a) {
	partition(a, 0, a.size() - 1);
    }

    /**
     * @param a
     * @param start
     * @param end
     */
    public void partition(ArrayList<T> a, int start, int end) {
	if (start < end) {
	    int pivot = (start + end) / 2;
	    T x = a.get(pivot);
	    scambia(a, pivot, start);
	    int leftPointer = start, rightPointer = end;
	    while (leftPointer <= rightPointer) {
		while (comparator.compare(a.get(leftPointer), x) < 0)
		    leftPointer++;
		while (comparator.compare(a.get(rightPointer), x) > 0)
		    rightPointer--;
		if (leftPointer <= rightPointer) {
		    scambia(a, leftPointer, rightPointer);
		    leftPointer++;
		    rightPointer--;
		}
	    }
	    partition(a, start, rightPointer);
	    partition(a, leftPointer, end);
	}

    }

    /**
     * @param a
     * @param i
     * @param j
     */
    public void scambia(ArrayList<T> a, int i, int j) {
	T temp = a.get(i);
	a.set(i, a.get(j));
	a.set(j, temp);
    }

    /**
     * @param a
     * @return
     */
    public boolean isSorted(ArrayList<T> a) {
	for (int i = 1; i < a.size(); i++)
	    if (comparator.compare(a.get(i - 1), a.get(i)) > 0)
		return false;
	return true;
    }

}
