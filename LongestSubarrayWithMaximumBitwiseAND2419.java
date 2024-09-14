public class LongestSubarrayWithMaximumBitwiseAND2419 {
    /*
     * You are given an integer array nums of size n.

Consider a non-empty subarray from nums that has the maximum possible bitwise AND.

In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
Return the length of the longest such subarray.

The bitwise AND of an array is the bitwise AND of all the numbers in it.

A subarray is a contiguous sequence of elements within an array.
     */

     class Solution {

        public int longestSubarray(int[] nums) {
            int maxVal = 0, ans = 0, currentStreak = 0;
            for (int num : nums) {
                if (maxVal < num) {
                    maxVal = num;
                    ans = currentStreak = 0;
                }
                if (maxVal == num) currentStreak++;
                else currentStreak = 0;
                ans = Math.max(ans, currentStreak);
            }
            return ans;
        }
    }
}
