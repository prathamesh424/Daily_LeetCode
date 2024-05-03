import java.util.Arrays;

public class LargestPositiveIntThatExistsWithItsNegative2441 {

    /*
     Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.
     
     Return the positive integer k. If there is no such integer, return -1.
     */

    class Solution {

        // Approach 2-pointer using Binary search...
    public int findMaxK(int[] nums) {
        Arrays.sort(nums) ;
        int i = 0 , j = nums.length - 1;
        while (i < j) {
            if (-(nums[i]) == nums[j])return nums[j] ;
            else if (-(nums[i]) < nums[j]) j--;
            else i++;
        }
        return -1;
    }
}
}