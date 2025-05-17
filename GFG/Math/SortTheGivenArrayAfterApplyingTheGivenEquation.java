import java.util.ArrayList;

public class SortTheGivenArrayAfterApplyingTheGivenEquation {
    /*
     * Given an integer array arr[] sorted in ascending order,
             *  along with three integers: A, B, and C. 
             * The task is to transform each element x in the array using the quadratic function A*(x2) + B*x + C.
             *  After applying this transformation to every element, 
                     * return the modified array in sorted order.
     */

    
class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(A * arr[i] * arr[i] + B * arr[i] + C);
        } 
        ans.sort(null);
        return ans;       
    }
}
}
