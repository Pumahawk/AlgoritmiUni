package Ordinamento;

public class Sorting {

    /**
     * This method check if an integer array is sorted
     * 
     * @param a
     *            (array)
     * @return true if is sorted else false
     */

    public static boolean isSorted(int[] arr) {
	for (int i = 1; i < arr.length - 1; i++) {
	    if (arr[i] >= arr[i - 1]) {
		continue;
	    } else
		return false;
	}
	return true;
    }

    /**
     * this method check if an generic array is sorted
     * 
     * @param a
     *            : generic array to sort
     * @return true : if is sorted else false
     */

    public static <T extends Comparable<? super T>> boolean isSorted(T[] arr) {
	for (int i = 1; i < arr.length; i++) {
	    if (arr[i].compareTo(arr[i - 1]) == 0 || arr[i].compareTo(arr[i - 1]) == 1) {
		continue;
	    } else
		return false;
	}
	return true;
    }

    /**
     * this void method operate the basic insertion sort to an array
     * 
     * @param a
     *            : array to order
     */

    public static void insertionSort(int[] arr) {
	for (int i = 0; i < arr.length; i++) {
	    int x = arr[i];
	    int j;
	    for (j = i; j > 0; j--) {
		if (x >= arr[j - 1]) {
		    break;
		}
		arr[j] = arr[j - 1];
	    }
	    arr[j] = x;
	}
    }

    /**
     * operate the basic algoritm of merge between to portion of the same array
     * first : a[start.. middle] second: a[middle+1... end]
     * 
     * @param a
     *            : array to sort
     * @param start
     *            : start index
     * @param middle
     *            : middle index
     * @param end
     *            : end index
     */

    public static void mergeSort(int[] a, int start, int end) {
	int middle = (start + end) / 2;
	int length = end - start + 1;
	int i = start;
	int j = middle + 1;
	int k = 0;
	int[] c = new int[length];
	while (i <= middle && j <= end) {
	    if (a[i] <= a[j]) {
		c[k++] = a[i++];
	    } else {
		c[k++] = a[j++];
	    }
	}
	while (i <= middle) {
	    c[k++] = a[i++];
	}
	while (j <= middle) {
	    c[k++] = a[j++];
	}
	for (int h = 0; h < length; h++) {
	    a[start + h] = c[h];
	}
    }

}
