public class SearchInAnAlmostSortedArray {
    /*
     * Given a sorted integer array arr[] consisting of distinct elements, 
             * where some elements of the array are moved to either of the adjacent positions,
                     *  i.e. arr[i] may be present at arr[i-1] or arr[i+1].
        Given an integer target.  You have to return the index ( 0-based ) of the target in the array. 
        If target is not present return -1.
     */
    class Solution {
        public int findTarget(int arr[], int target) {
            int s = 0;
            int e = arr.length - 1;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (mid > s && arr[mid - 1] == target) {
                    return mid - 1;
                } else if (mid < e && arr[mid + 1] == target) {
                    return mid + 1;
                } else if (arr[mid] < target) {
                    s = mid + 2;
                } else {
                    e = mid - 2;
                }
            }
            return -1;    
    }
}
}
