package Ordinamento;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort<T> {
    private Comparator<T> comparator;

    public MergeSort(Comparator<T> comparator) {
	this.comparator = comparator;
    }

    void msortBasicEcologic(ArrayList<T> a) {
	ArrayList<T> old = (ArrayList<T>) a.clone();
	msortBasic(a, 0, a.size() - 1, old);
    }

    void msortBasic(ArrayList<T> a, int start, int end, ArrayList<T> old) {
	if (start >= end)
	    return;
	int middle = (start + end) / 2;
	msortBasic(a, start, middle, old);
	msortBasic(a, middle + 1, end, old);
	mergeEcologic(a, start, middle, end, old);
    }

    public void mergeEcologic(ArrayList<T> array, int first, int mid, int last, ArrayList<T> c) {
	int i = first, j = mid + 1, k = first;
	while (i <= mid && j <= last) {
	    if (comparator.compare(array.get(i), array.get(j)) <= 0) {
		c.set(k, (array.get(i)));
		i++;
	    } else {
		c.set(k, (array.get(j)));
		j++;
	    }
	    k++;
	}
	int h = mid, l = last;
	while (h >= i) {
	    array.set(l, array.get(h));
	    l--;
	    h--;
	}
	for (int r = first; r < k; r++)
	    array.set(r, c.get(r));

    }

    public void print(ArrayList<T> arr) {
	for (int i = 0; i < arr.size(); i++)
	    System.out.println(arr.get(i));

    }
}
