package GFG.DP;

public class nCr {
    /*
     * Given two integer values n and r, the task is to find the value of Binomial Coefficient nCr
    
    A binomial coefficient nCr can be defined as the coefficient of xr in the expansion of (1 + x)n that gives the number of ways to choose r objects from a set of n objects without considering the order.
    The binomial coefficient nCr is calculated as : C(n,r) = n! / r! * (n-r) !
    Note: If r is greater than n, return 0.
    It is guaranteed that the value of nCr will fit within a 32-bit integer.
    
     */
    /*
     * Time Complexity: O(n)
        Auxiliary Space: O(1)
        using the Dynamic Programming approach.
     */
     class Solution {
        public int nCr(int n, int r) {
                if (r > n) {
                    return 0;
                }
                if (r == 0 || r == n) {
                    return 1;
                }
                int[] dp = new int[r + 1];
                dp[0] = 1;
                for (int i = 1; i <= n; i++) {
                    for (int j = Math.min(i, r); j > 0; j--) {
                        dp[j] += dp[j - 1];
                    }
                }
                return dp[r];
        }
    }
}
