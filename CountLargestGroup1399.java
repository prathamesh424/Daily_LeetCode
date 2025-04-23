import  java.util.HashMap;

public class CountLargestGroup1399 {

    /*
     * You are given an integer n.

Each number from 1 to n is grouped according to the sum of its digits.

Return the number of groups that have the largest size.
     */
    class Solution {
        // Using Array
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        public int countLargestGroup(int n) {
            int[] sums = new int[37];
            for (int i = 1; i <= n; i++)
                sums[digsum(i)]++;
            int maxi = 0, count = 0;
            for (int i : sums) {
                if (i > maxi) {
                    maxi = i;
                    count = 1;
                } else if (i == maxi) {
                    count++;
                }
            }
            return count;
        }

        // Using HashMap
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        public int countLargestGroupUsingHashMap(int n) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int maxi = 0, count = 0;

        for (int i = 1; i <= n; i++) {
            int x = digsum(i);
            mpp.put(x, mpp.getOrDefault(x, 0) + 1);
            maxi = Math.max(maxi, mpp.get(x));
        }

        for (int val : mpp.values()) if (val == maxi) count++;
        return count;
    }

        private int digsum(int n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }


    }
    

}
