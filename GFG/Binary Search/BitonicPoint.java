
public class BitonicPoint {
    /*
     * Given an array of integers arr[] that is first strictly increasing and then maybe strictly decreasing, 
             * find the bitonic point, that is the maximum element in the array.
    Bitonic Point is a point before which elements are strictly increasing and after
     which elements are strictly decreasing.
    
    Note: It is guaranteed that the array contains exactly one bitonic point.
     */

     class Solution {
    public int findMaximum(int[] arr) {
        int left = 0, right = arr.length;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return arr[mid];
                } else if (arr[mid] < arr[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (mid == 0) {
                return Math.max(arr[0], arr[1]);
            } else if (mid == arr.length - 1) {
                return Math.max(arr[arr.length - 1], arr[arr.length - 2]);
            }
            else if (arr[mid] > arr[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr[left]  ;
    }
}
}
