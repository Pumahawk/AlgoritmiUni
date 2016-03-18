package sorting;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSortTest {
  private class IntegerComparator implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
      return i1.compareTo(i2);
    }
  }

  ArrayList<Integer> array;
  IntegerComparator comparator;
  SelectionSort<Integer> sorter;

  @Before
  public void setUp() {
    array = new ArrayList<Integer>();
    array.add(10);
    array.add(1);
    array.add(8);
    array.add(21);
    array.add(7);

    comparator = new IntegerComparator();
    sorter = new SelectionSort<Integer>(comparator);
  }

  @Test
  public void testSwapOnDifferentElements() {
    sorter.swap(array, 1, 3);
    assertEquals( 21, (int)array.get(1) );
    assertEquals( 1, (int)array.get(3) );
  }

  @Test
  public void testSwapOnSameElement() {
    ArrayList<Integer> arrayCopy = new ArrayList<Integer>(array);

    sorter.swap(array, 1, 1);
    assertEquals( arrayCopy, array );
  }

  @Test
  public void testSelect() {
    assertEquals(1, sorter.select(array, 0));
  }

  @Test
  public void testSelectAtEndArray() {
    assertEquals(4, sorter.select(array, 4));
  }

  @Test
  public void testSelectionSort() {
    ArrayList<Integer> expected = new ArrayList<Integer>();
    expected.add(1);
    expected.add(7);
    expected.add(8);
    expected.add(10);
    expected.add(21);

    sorter.sort(array);
    assertEquals(expected,array);
  }

}
