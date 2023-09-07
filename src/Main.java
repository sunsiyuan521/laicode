import BinarySearch.SearchInBitonicArray;
import BinarySearch.SearchInShiftedSortedArrayI;
import Sort.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        System.out.println(Arrays.toString(q.quickSort(new int[]{15,1,3,6,10})));
    }
}