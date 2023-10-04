package Heap;

public class Heapify {
    public int[] heapify(int[] array) {
        // Write your solution here
        int n = array.length;
        for(int i = n / 2 - 1; i >= 0; i--) {
            percolateDown(array, i, n);
        }
        return array;
    }
    private void percolateDown(int[] array, int index, int n) {
        while(index <= n / 2 - 1) {
            int leftChildrenIndex = index * 2 + 1;
            int rightChildrenIndex = index * 2 + 2;
            int smallest = leftChildrenIndex;
            if(rightChildrenIndex <= n - 1 && array[rightChildrenIndex] <= array[leftChildrenIndex]) {
                smallest = rightChildrenIndex;
            }
            if(array[index] > array[smallest]) {
                swap(array,index, smallest);
            } else {
                break;
            }
            index = smallest;
        }
    }

    private void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }
}
