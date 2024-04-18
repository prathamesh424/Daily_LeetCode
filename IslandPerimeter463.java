public class IslandPerimeter463 {
    /*
    You are given row x col grid representing a map where grid[i][j] = 1 
    represents land and grid[i][j] = 0 represents water.
    
    Grid cells are connected horizontally/vertically (not diagonally). 
    The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

    The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. 
    One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
     */




                // By dfs Approach :- 

     class Solution {
        public int islandPerimeter(int[][] grid) {
            int perimeter = 0 ;
            for (int i = 0 ; i < grid.length ; i++){
                for (int j =0 ; j <grid[0].length ; j++) {
                    if (grid[i][j] == 1) {
                        perimeter += dfs(grid , i , j);
                    }
                }
            }
            return perimeter ;
        }
    
        private int dfs(int[][] grid, int i , int j) {
            if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0 ) return 1 ;
            if (grid[i][j] == -1) return 0 ;
            grid[i][j] = -1 ;
            return (dfs(grid  , i+1 , j) + dfs(grid  , i-1 , j)+
                    dfs(grid  , i , j+1)+ dfs(grid
                     , i , j-1)) ;
            
        }
    }


    // optimal Approach : - 

    class Solution2 {
        public int islandPerimeter(int[][] grid) {
            int peri = 0 ;
            int n = grid.length  ;
            int m = grid[0].length ;
            
            for (int i = 0 ; i < n ; i++){
                for (int j =0 ; j < m ; j++) {
                    if (grid[i][j] == 1) {
                        peri += 4 ;
                        if (i > 0 && grid[i-1][j] == 1) peri -= 2 ;
                        if (j > 0 && grid[i][j-1] == 1) peri -= 2 ;
                    }
                }
            }
            return peri ;
        }

    }


}
