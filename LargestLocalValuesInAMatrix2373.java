import java.util.*;


public class LargestLocalValuesInAMatrix2373 {
    /*
     * You are given an n x n integer matrix grid.
     * 
     * Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
     * 
     * maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
     * 
     * In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
     * 
     * Return the generated matrix.
     */

    
    class Solution {
        public int[][] largestLocal(int[][] grid) {
            int n = grid.length ;
            int [][] maxLocal = new int[n-2][n-2] ;

            for (int r = 0; r <  n-2; r++) {
                for (int c = 0; c <  n-2; c++) {
                    int max = 0;

                    for (int i = r; i < r + 3; i++) {
                        for (int j = c; j < c+3; j++) 
                            max = Math.max(max, grid[i][j]);

                    maxLocal[r][c] = max; 
                }
            }   
        }
        return maxLocal ;
        }
    }
}
