package Ordinamento;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Sort {
    public static <T> boolean isSorted(Iterator<T> it, Comparator<T> comp) {
	T c1, c2;
	if (it.hasNext()) {
	    c1 = it.next();
	    for (; it.hasNext(); c1 = c2) {
		c2 = it.next();
		if (comp.compare(c1, c2) > 0)
		    return false;
	    }
	}

	return true;
    }

    public static <T> void sortInsertionSort(ArrayList<T> arr, Comparator<T> comp) {
	new InsertionSort<T>(comp).sort(arr);
    }

    public static <T> void sortHeapSort(ArrayList<T> arr, Comparator<T> comp) {
	new HeapSort<T>(comp).sort(arr);
    }

    public static <T> void sortQuickSort(ArrayList<T> arr, Comparator<T> comp) {
	new QuickSort<T>(comp).sort(arr);
    }

    public static <T> void sortMergeSort(ArrayList<T> arr, Comparator<T> comp) {
	new MergeSort<T>(comp).sort(arr);
    }
}
