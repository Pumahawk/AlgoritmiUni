package orderalgorithm;

import java.util.ArrayList;
import java.util.Comparator;

public class InsertionSort<T> {

    private Comparator<T> comparator;

    /**
     * @param comparator
     */
    public InsertionSort(Comparator<T> comparator) {
	this.comparator = comparator;
    }

    /**
     * @param arr
     */
    public void sort(ArrayList<T> arr) {
	for (int i = 1; i < arr.size(); i++) {
	    T p = arr.get(i);
	    int j;
	    for (j = i - 1; j >= 0 && comparator.compare(arr.get(j), p) > 0; j--)
		arr.set(j + 1, arr.get(j));
	    arr.set(j + 1, p);
	}
    }

    /**
     * @param arr
     */
    public void print(ArrayList<T> arr) {
	for (int i = 0; i < arr.size(); i++)
	    System.out.println(arr.get(i));

    }

    /**
     * @param a
     * @return true if the parameter a is sorte, else false
     */
    public static <T extends Comparable<? super T>> boolean isSorted(ArrayList<T> a) {
	for (int i = 1; i < a.size(); i++) {
	    if (a.get(i).compareTo(a.get(i - 1)) >= 0) {
		continue;
	    } else
		return false;
	}
	return true;
    }

}