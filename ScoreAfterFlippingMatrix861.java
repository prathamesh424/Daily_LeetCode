
import java.util.*;


public class ScoreAfterFlippingMatrix861 {
    /*
     * You are given an m x n binary matrix grid.
     * 
     * A move consists of choosing any row or column and toggling each value in that row or column 
     * (i.e., changing all 0's to 1's, and all 1's to 0's).
     * 
     * Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
     * 
     * Return the highest possible score after making any number of moves (including zero moves).
     */

    class Solution {
        public int matrixScore(int[][] grid) {
            int n = grid.length ;
            int m = grid[0].length ;

            int score = (1 <<(m-1)) * n ;

            for (int i = 1; i < m; i++) {
                int count = 0 ;
                for (int j = 1; j < n; j++) {
                    if (grid[j][i] == grid[j][0]) count++;
                }
                count = Math.max(count,n -count);
                int colScore = (1 << (n - i - 1)) ;
                score += colScore;
            }
            return score ;   
        }
    }
    
}
