package Ordinamento;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapSortTest {

    public static void main(String[] args) {
	class IntegerComparator implements Comparator<Integer> {

	    @Override
	    public int compare(Integer arg0, Integer arg1) {
		return arg0.compareTo(arg1);
	    }
	}

	HeapSort<Integer> sort = new HeapSort<>(new IntegerComparator());
	ArrayList<Integer> arr = new ArrayList<Integer>();
	arr.add(19);
	arr.add(3);
	arr.add(25);
	arr.add(36);
	arr.add(100);
	arr.add(17);
	arr.add(2);
	arr.add(7);
	arr.add(1);
	sort.printArr(arr);
	sort.sort(arr);
	System.out.println("--------------");
	sort.printArr(arr);

    }

}
