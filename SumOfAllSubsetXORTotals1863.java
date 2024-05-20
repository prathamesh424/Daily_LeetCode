import java.util.* ;

public class SumOfAllSubsetXORTotals1863 {
        /*
         * The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.
         * 
         * For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
         * Given an array nums, return the sum of all XOR totals for every subset of nums. 
         * 
         * Note: Subsets with the same elements should be counted multiple times.
         * 
         * An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
        */
        class SolutionBit {
            public int subsetXORSum(int[] nums) {
                int req = 0; 
                for (int num : nums) req |= num ;

                return req << (nums.length -1) ;
            }
        }

        class Solution {
            public int subsetXORSum(int[] nums) {
                return sum (nums , 0 , 0 );
            }
            private int sum (int [] nums , int idx ,int curr) {
                int with , without ;
                if (idx == nums.length -1) return curr ;

                with = sum(nums, idx + 1 , curr ^ nums[idx]);
                without = sum(nums, idx + 1 , curr );

                return with+ without; 
            }
        }

}
