package orderalgorithm;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * classe in grado di ordinare un array con il metodo del quicksort
 * 
 * @author Lorenzo Gandino
 *
 * @param <T>
 */
public class QuickSort<T> {
    private Comparator<T> comparator;

    public QuickSort(Comparator<T> comparator) {
	this.comparator = comparator;
    }

    /**
     * Metodo incaricato di ordinare l'array
     */
    public void sort(ArrayList<T> a) {
	quickSort(a);
    }

    public void quickSort(ArrayList<T> a) {
	partition(a, 0, a.size() - 1);
    }

    /**
     * divide in 2 l'array a composto incluso da start a end e applica
     * l'algoritmo di quicksort
     * 
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
     * Scambia 2 elementi nell' array
     */
    public void scambia(ArrayList<T> a, int i, int j) {
	T temp = a.get(i);
	a.set(i, a.get(j));
	a.set(j, temp);
    }

    /**
     * Controlla se un array è ordinato
     */
    public boolean isSorted(ArrayList<T> a) {
	for (int i = 1; i < a.size(); i++)
	    if (comparator.compare(a.get(i - 1), a.get(i)) > 0)
		return false;
	return true;
    }

}
