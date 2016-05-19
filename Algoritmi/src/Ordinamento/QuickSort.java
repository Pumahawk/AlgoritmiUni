package Ordinamento;

import java.util.ArrayList;
import java.util.Comparator;

public class QuickSort<T> {
    private Comparator<T> comparator;

    public QuickSort(Comparator<T> comparator) {
	this.comparator = comparator;
    }

    public void quickSort(T[] a) {
	partition(a, 0, a.length - 1);
    }

    public void partition(T[] a, int start, int end) {
	if (start < end) {
	    int pivot = (start + end) / 2;
	    T x = a[pivot];
	    scambia(a, pivot, start);
	    int leftPointer = start;
	    int rightPointer = end;
	    while (leftPointer <= rightPointer) {
		while (comparator.compare(a[leftPointer], x) < 0) {
		    leftPointer++;
		}

		while (comparator.compare(a[rightPointer], x) > 0) {
		    rightPointer--;
		}

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

    public void scambia(T[] a, int i, int j) {
	T temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }

    public void print(T[] arr) {
	for (int i = 0; i < arr.length - 1; i++)
	    System.out.println(arr[i]);

    }

    public void print2(ArrayList<T> arr) {
	for (int i = 0; i < arr.size(); i++)
	    System.out.println(arr.get(i));

    }

}
