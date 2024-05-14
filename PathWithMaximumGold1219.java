import java.util.* ;

public class PathWithMaximumGold1219 {
     /*
    * In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
      
      Return the maximum amount of gold you can collect under the conditions:
    * Every time you are located in a cell you will collect all the gold in that cell.
    * From your position, you can walk one step to the left, right, up, or down.
    * You can't visit the same cell more than once.
    * Never visit a cell with 0 gold.
    * You can start and stop collecting gold from any position in the grid that has some gold.
      */

    class Solution {
        private final int [] dirction = new int[] {0 , 1 , 0 , -1 , 0 };
        public int getMaximumGold(int[][] grid){
            int n = grid.length ;
            int m = grid[0].length; 
            int maxGold = 0 ;

            for (int i = 0; i < n; i++) 
                for (int j = 0; j < m; j++) 
                    maxGold = Math.max(maxGold , dfs(grid, n, m, i, j)) ;

            return maxGold;
        }

        public int dfs (int [][] grid , int n , int m , int i , int j) {
            if ( i < 0 || j < 0 || i > n || j > m || grid[i][j] == 0) return  0 ;
            int maxGold = 0 ;

            int val = grid[i][j] ;
            grid[i][j] = 0 ;

            for (int k = 0; k < 4; k++) 
                maxGold = Math.max(maxGold, dfs(grid, n, maxGold, i + dirction[k], j + dirction[k+1]));
            
            grid[i][j] = val ;
            
            return maxGold + val ;
        }
    }
}
