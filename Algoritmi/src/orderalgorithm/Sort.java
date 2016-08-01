package orderalgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Classe contenente tutti i metodi di ordinamento
 *
 */
public class Sort {
    /**
     * Controlla se una struttura iterabile è ordinata
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
     * Applica l'algoritmo di insertion sort
     */
    public static <T> void sortInsertionSort(ArrayList<T> arr, Comparator<T> comp) {
	new InsertionSort<T>(comp).sort(arr);
    }

    /**
     * Applica l'algoritmo di HeapSort
     */
    public static <T> void sortHeapSort(ArrayList<T> arr, Comparator<T> comp) {
	new HeapSort<T>(comp).sort(arr);
    }

    /**
     * applica l'algoritmo di quickSort
     */
    public static <T> void sortQuickSort(ArrayList<T> arr, Comparator<T> comp) {
	new QuickSort<T>(comp).sort(arr);
    }

    /**
     * applica l'algoritmo di mergeSort
     */
    public static <T> void sortMergeSort(ArrayList<T> arr, Comparator<T> comp) {
	new MergeSort<T>(comp).sort(arr);
    }
}
