

public class BuildArrayFromPermutation1920 {
    /*
     * Given a zero-based permutation nums (0-indexed), build an array ans of the same length,
             *  where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
            A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
     */

     //solve it without using an extra space 

     class Solution {
         public int[] buildArray(int[] nums) {
             int n = nums.length;

             for (int i = 0; i < n; i++) {
                 nums[i] = nums[i] + (nums[nums[i]] % n) * n;
                 System.out.print(nums[i] + " ");
             }
                 System.out.println("");

             for (int i = 0; i < n; i++) {
                 nums[i] = nums[i] / n;
                 System.out.print(nums[i] + " ");
             }
                 System.out.println("");

             return nums;
         }
     }
        public static void main(String[] args) {
            Solution solution = new BuildArrayFromPermutation1920().new Solution();
            int[] nums = {0, 2, 1, 5, 3, 4};
            int[] result = solution.buildArray(nums);
            for (int num : result) {
                System.out.print(num + " ");
            }
        }

}
