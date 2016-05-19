package Ordinamento;

import java.util.ArrayList;
import java.util.Comparator;

class InsertionSort<T> {

    private Comparator<T> comparator;

    public InsertionSort(Comparator<T> comparator) {
	this.comparator = comparator;
    }

    public void sort(ArrayList<T> arr) {
	for (int i = 1; i < arr.size(); i++) {
	    T p = arr.get(i);
	    {
		int j;
		for (j = i - 1; j > -1 && comparator.compare(arr.get(j), p) > 0; j--)
		    arr.set(j + 1, arr.get(j));
		arr.set(j + 1, p);
	    }
	}
    }

    public void print(ArrayList<T> arr) {
	for (int i = 0; i < arr.size(); i++)
	    System.out.println(arr.get(i));

    }

    /*
     * public boolean isSorted(ArrayList<T> a){ for(int i=1;i<a.size();i++){
     * if((int)a.get(i) >= (int)a.get(i-1)){ continue; } else return false; }
     * return true;
     * 
     * }
     */

    public static <T extends Comparable<? super T>> boolean isSorted(ArrayList<T> a) {
	for (int i = 1; i < a.size(); i++) {
	    if (a.get(i).compareTo(a.get(i - 1)) == 0 || a.get(i).compareTo(a.get(i - 1)) == 1) {
		continue;
	    } else
		return false;
	}
	return true;
    }

}