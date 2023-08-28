package BinarySearch;
/*
*161. Square Root I
Given an integer number n, find its integer square root.
Assumption:
n is guaranteed to be >= 0.
Example:
Input: 18, Return: 4
Input: 4, Return: 2

*
* */
public class SquareRootI {
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
