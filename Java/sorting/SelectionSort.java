package sorting;

import java.util.Comparator;
import java.util.ArrayList;

public class SelectionSort<T> {
  private Comparator<T> comparator;

  public SelectionSort(Comparator<T> comparator) {
    this.comparator = comparator;
  }

  int select(ArrayList<T> array, int pos) {
    return 0;
  }

  void swap(ArrayList<T> array, int p1, int p2) {
    T tmp = array.get(p1);
    array.set(p1, array.get(p2));
    array.set(p2, tmp);
  }

  public void sort(ArrayList<T> array) {
    for(int i=0; i<array.size(); ++i) {
      int minIndex = select(array, i);
      swap(array, i, minIndex);
    }
  }
}
