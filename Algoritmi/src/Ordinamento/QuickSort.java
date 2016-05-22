package Ordinamento;

import java.util.ArrayList;
import java.util.Comparator;

public class QuickSort<T> {
    private Comparator<T> comparator;

    public QuickSort(Comparator<T> comparator) {
	this.comparator = comparator;
    }

    public void quickSort(ArrayList<T> a) {
	partition(a, 0, a.size() - 1);
    }

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

    public void scambia(ArrayList<T> a, int i, int j) {
	T temp = a.get(i);
	a.set(i, a.get(j));
	a.set(j, temp);
    }

    public boolean isSorted(ArrayList<T> a) {
	for (int i = 1; i < a.size(); i++)
	    if (comparator.compare(a.get(i - 1), a.get(i)) > 0)
		return false;
	return true;
    }

    public static void main(String args[]) {
	ArrayList<Integer> arr = new ArrayList<Integer>();
	for (int i = 0; i < arr.size(); i++)
	    arr.set(i, (int) (Math.random() * 100000 - 1000));
	QuickSort<Integer> qs = new QuickSort<Integer>((Integer a, Integer b) -> (a < b) ? -1 : (a == b) ? 0 : 1);
	qs.partition(arr, 0, arr.size() - 1);
	return;
    }
}
