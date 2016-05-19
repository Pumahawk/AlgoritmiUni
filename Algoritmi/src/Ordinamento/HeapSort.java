package Ordinamento;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapSort<T> {
    private Comparator<T> comparator;

    public HeapSort(Comparator<T> comparator) {
	this.comparator = comparator;
    }

    private void makeHeap(ArrayList<T> array, int p) {
	if (isFoglia(array, p))
	    return;
	scambia(array, getMax(array, p), p);
	makeHeap(array, p * 2 + 1);
	if (p * 2 + 2 < array.size())
	    makeHeap(array, p * 2 + 2);

    }

    private int getMax(ArrayList<T> arr, int pos) {
	if (isFoglia(arr, pos))
	    return pos;
	else {
	    int nodoSx = pos * 2 + 1;
	    int nodoDx = nodoSx + 1;
	    if (nodoDx >= arr.size()) {
		int maxSott = getMax(arr, nodoSx);
		return (comparator.compare(arr.get(maxSott), arr.get(pos)) > 0) ? maxSott : pos;
	    } else {
		int maxSx = getMax(arr, nodoSx);
		int maxDx = getMax(arr, nodoDx);
		int max = (comparator.compare(arr.get(maxSx), arr.get(maxDx)) > 0) ? maxSx : maxDx;
		return (comparator.compare(arr.get(max), arr.get(pos)) > 0) ? max : pos;
	    }

	}
    }

    private boolean isFoglia(ArrayList<T> arr, int pos) {
	int lungArr = arr.size();
	if (pos * 2 + 1 >= lungArr)
	    return true;
	else
	    return false;
    }

    public void scambia(ArrayList<T> array, int pos1, int pos2) {
	T p = array.get(pos1);
	array.set(pos1, array.get(pos2));
	array.set(pos2, p);
    }

    private void sortHeap(ArrayList<T> arr) {
	int p, max;
	for (int i = arr.size() - 1; i > 0; i--) {
	    p = 0;
	    scambia(arr, 0, i);
	    while (p * 2 + 1 < i) {
		if (p * 2 + 2 < i)
		    max = (comparator.compare(arr.get(p * 2 + 1), arr.get(p * 2 + 2)) > 0) ? p * 2 + 1 : p * 2 + 2;
		else
		    max = p * 2 + 1;
		if (comparator.compare(arr.get(p), arr.get(max)) <= 0) {
		    scambia(arr, p, max);
		    p = max;
		} else
		    break;
	    }
	}
    }

    public void sort(ArrayList<T> arr) {
	makeHeap(arr);
	sortHeap(arr);
    }

    private void makeHeap(ArrayList<T> arr) {
	makeHeap(arr, 0);

    }

    public static void printArr(ArrayList<Integer> arr) {
	for (int i = 0; i < arr.size(); i++)
	    System.out.println(arr.get(i));
    }
}