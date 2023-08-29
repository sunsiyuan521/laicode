package BinarySearch;
/*
401. Search In Bitonic Array
Search for a target number in a bitonic array, return the index of the target number if found in the array, or return -1.
A bitonic array is a combination of two sequence: the first sequence is a monotonically increasing one and the second sequence is a monotonically decreasing one.
Assumptions:
The array is not null.
Examples:
array = {1, 4, 7, 11, 6, 2, -3, -8}, target = 2, return 5.

* */
public class SearchInBitonicArray {
    public int search(int[] array, int target) {
        if(array == null || array.length == 0) {
            return -1;
        }
        if (array.length == 1) {
            return array[0] == target ? 0 : -1;
        }
        int peakIndex = findPeak(array);
        int leftResult = binarySearch(array, target, 0, peakIndex);
        if (leftResult != -1) {
            return leftResult;
        }
        if(peakIndex == array.length - 1) {
            return leftResult;
        } else {
            int rightResult = binarySearch(array, target, peakIndex + 1, array.length - 1);
            return rightResult;
        }
    }
    private int binarySearch(int[] array, int target, int left, int right) {
        boolean isIncreasing = array[left] < array[right];
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(array[mid] == target) {
                return mid;
            }
            if(isIncreasing) {
                if(array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(array[mid] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    //第一个出现array[i] > array[i + 1]
    private int findPeak(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while(left < right - 1) {
            int mid = left + (right - left) / 2;
            if(array[mid] < array[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return array[left] <= array[right] ? right : left;
    }
}
