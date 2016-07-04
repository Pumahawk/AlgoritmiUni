package Ordinamento;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Sort {
    /**
     * @param iter
     * @param comp
     * @return true if the elements is sorted, else false
     */
    public static <T> boolean isSorted(Iterator<T> iter, Comparator<T> comp) {
	T c1, c2;
	if (iter.hasNext()) {
	    c1 = iter.next();
	    for (; iter.hasNext(); c1 = c2) {
		c2 = iter.next();
		if (comp.compare(c1, c2) > 0)
		    return false;
	    }
	}

	return true;
    }

    /**
     * @param arr
     * @param comp
     */
    public static <T> void sortInsertionSort(ArrayList<T> arr, Comparator<T> comp) {
	new InsertionSort<T>(comp).sort(arr);
    }

    /**
     * @param arr
     * @param comp
     */
    public static <T> void sortHeapSort(ArrayList<T> arr, Comparator<T> comp) {
	new HeapSort<T>(comp).sort(arr);
    }

    /**
     * @param arr
     * @param comp
     */
    public static <T> void sortQuickSort(ArrayList<T> arr, Comparator<T> comp) {
	new QuickSort<T>(comp).sort(arr);
    }

    /**
     * @param arr
     * @param comp
     */
    public static <T> void sortMergeSort(ArrayList<T> arr, Comparator<T> comp) {
	new MergeSort<T>(comp).sort(arr);
    }
}
