package sorting;

import java.util.Comparator;
import java.util.ArrayList;

/**
 * Implements the Selection Sort algorithm.
 */
public class SelectionSort<T> {
  /**
   * Object used to compare two T objects.
   */
  private Comparator<T> comparator;

  /**
   * @param  comparator    the object to be used to compare two elements of
   *                       the array.
   */
  public SelectionSort(Comparator<T> comparator) {
    this.comparator = comparator;
  }

  /**
   * Finds the index of the minimum element in the array. The search is
   * performed only in the index range [pos, array.size()). Comparisons are
   * made using the comparator object.
   * @param array   The array to be scanned
   * @param pos     the index where the array scan should start
   * @return        the index of the minimum element in the array.
   */
  int select(ArrayList<T> array, int pos) {
    int minIndex = pos;
    for(int i=pos+1; i<array.size(); ++i) {
      if(comparator.compare(array.get(i), array.get(minIndex)) < 0) {
        minIndex = i;
      }
    }

    return minIndex;
  }

  /**
   * Swaps the element at index p1 with the element at index p2
   * @param array the array containing the elements
   * @param p1    position of the first element
   * @param p2    position of the second element
   */
  void swap(ArrayList<T> array, int p1, int p2) {
    T tmp = array.get(p1);
    array.set(p1, array.get(p2));
    array.set(p2, tmp);
  }

  /**
   * Sorts the given array using the criterion implemented by the
   * comparator given to the SelectionSort constructor.
   * @param  array The array to be sorted.
   */
  public void sort(ArrayList<T> array) {
    for(int i=0; i<array.size(); ++i) {
      int minIndex = select(array, i);
      swap(array, i, minIndex);
    }
  }
}
