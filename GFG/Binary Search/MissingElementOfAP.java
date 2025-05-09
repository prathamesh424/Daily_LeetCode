


public class MissingElementOfAP {
    /*
     * Given a sorted array arr[] that represents an Arithmetic Progression (AP) with exactly one missing element,
             *  find the missing number.
    
        Note: An element will always exist that, upon inserting into a sequence forms Arithmetic progression. 
        If the given sequence already forms a valid complete AP, return the (n+1)-th element that would come next in the sequence.
     */

    class Solution {
        /*
         * Time Complexity: O(log n)
           Auxiliary Space: O(1)
         */
        public int findMissing(int[] arr) {
               
        int n = arr.length;
        if (n < 2) return -1;

        int d = Integer.MAX_VALUE;
        if (arr[0] < arr[1]){
            for (int i = 1; i < n; ++i) {
                d = Math.min(d, arr[i] - arr[i - 1]);
            }
        }
        else {
            d = Integer.MIN_VALUE ;
            for (int i = 1; i < n; ++i) {
                d = Math.max(d, arr[i] - arr[i - 1]);
            }
        }

        for (int i = 1; i < n; ++i) {
            if (arr[i] - arr[i - 1] != d) {
                return arr[i - 1] + d;
            }
        }

        return arr[n - 1] + d;

    }
}
}
