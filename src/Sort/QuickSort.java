package Sort;

import java.util.Random;

/*
* 10. Quick Sort
Given an array of integers, sort the elements in the array in ascending order. The quick sort algorithm should be used to solve this problem.
Examples
{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
Corner Cases
What if the given array is null? In this case, we do not need to do anything.
What if the given array is of length zero? In this case, we do not need to do anything.
* */
public class QuickSort {
    private Random random = new Random();
    public int[] quickSort(int[] array) {
        // corner case
        if(array == null || array.length <= 1) {
            return array;
        }
        return quickSort(array, 0, array.length - 1);
    }
    private int[] quickSort(int[] array, int left, int right) {
        //base case
        if (left >= right) {
            return array;
        }
        //Step1:choose pivot,把pivot index放在整个呆排序区域的末尾
        int pivotIndex = left + random.nextInt(right - left + 1);
        //int pivotIndex = left + (int)Math.random()* (right - left + 1);
        swap(array, pivotIndex, right);
        //Step2:Partition[left, right - 1]
        // 先尝试移动i,如果input[i] < pivot,i++
        // 如果i移不动，再尝试移动j,如果input[j] >= pivot,j--
        // 如果都移不动，说明错位了，交换input[j]和input[i].直到两指针相遇/错位，循环结束。
        // 最后把pivot放在中间，swap(i, pivotIndex)
        int i = left;
        int j = right - 1;
        while(i <= j) {
            if(array[i] < array[right]){
                i++;
            } else { //(array[i] >= array[right])
                swap(array, i, j);
                j--;
            }
        }
        swap(array, i, right);
        //recursion
        quickSort(array, left, i - 1); //比pivot小的区域是[0,i),not including i
        quickSort(array, i + 1, right);//比pivot大的区域是[i + 1, right],because input[i] is the pivot
        return array;
    }
    private void swap (int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
