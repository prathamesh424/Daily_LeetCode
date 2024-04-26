public class MinimumFallingPathSumII1279 {
    /*
     * Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.
     * A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that 
     * no two elements chosen in adjacent rows are in the same column.
     */
    class Solution {

        // time - O(n^3) 
        // space - O(n^2)
        public int minFallingPathSum(int[][] grid) {
            int n = grid.length; 
            int [][] dp = new int[n][n];

            // base case
            for (int i = 0; i < n; i++) 
                dp[n-1][i] = grid[n-1][i];
            

            // finding all paths and selecting min Path 
            for (int r = n -2 ; r>= 0 ; r--){
                for (int c = 0 ; c < n ;c++){
                    int nxtMin = Integer.MAX_VALUE ;
                    for (int nxt = 0; nxt < n; nxt++) {
                        if (c != nxt){
                            // select min Path 
                            nxtMin = Math.max(nxtMin,dp[r+1][nxt]) ;
                        }
                        
                    }// update dp 
                    dp[r][c] = grid[r][c] + nxtMin;
                }
            }
            // finding min path along with all path at top :-
            int ans = Integer.MAX_VALUE ;
            for (int i = 0; i <n; i++) {
                ans=Math.min(ans, dp[0][i]);
            }

            return ans ;
        }
    }
}
