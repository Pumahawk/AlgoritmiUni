package sorting;

import java.util.Comparator;
import java.util.ArrayList;

class InsertionSort<T>{
	
    private Comparator<T> comparator;

    public InsertionSort(Comparator<T> comparator){
        this.comparator = comparator;
    }

    public void sort(ArrayList<T> arr){
        for(int i = 1; i < arr.size(); i++){
            T p = arr.get(i);
            {
                int j;
                for(j = i - 1; j>-1 && comparator.compare(arr.get(j), p) >; j--)
                    arr.set(j+1, arr.get(j);
                arr.set(j+1, p);
            }
        }
    }
}