class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        
        /*
         * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

Given a row x col grid of integers, how many 3 x 3 contiguous magic square subgrids are there?

Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.
         */

        int ans = 0 ;
        for (int i = 0  ; i + 2 < grid.length ; i++){
            for (int j = 0 ; j +2 < grid[0].length ; j++){
                if (isMagicMatrix(grid , i , j)) ans++;
            }
        }
        return ans ; 
    }
    
    private boolean isMagicMatrix(int [][] grid , int r , int c){
        boolean [] visited = new boolean[10];
        for (int i = 0 ; i<3 ;i++){
            for(int j = 0 ; j < 3 ; j++){
                int num = grid[r+i][c+j];
                if(num < 1 || num > 9) return false ;
                if(visited[num]) return false ;
                visited[num] = true ;
            }
        }
         int d1 = grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2];
        int d2 =grid[r + 2][c] + grid[r + 1][c + 1] + grid[r][c + 2];
        if (d1 != d2) return false;
        int r1 = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];
        int r2 =grid[r + 1][c] +grid[r + 1][c + 1] +grid[r + 1][c + 2];
        int r3 =grid[r + 2][c] +grid[r + 2][c + 1] +grid[r + 2][c + 2];

        if (!(r1 == d1 && r2 == d1 && r3 == d1)) {
            return false;
        }
        int c1 = grid[r][c] + grid[r + 1][c] + grid[r + 2][c];
        int c2 =grid[r][c + 1] +grid[r + 1][c + 1] +grid[r + 2][c + 1];
        int c3 =grid[r][c + 2] + grid[r + 1][c + 2] +grid[r + 2][c + 2];
        if (!(c1 == d1 && c2 == d1 && c3 == d2)) {
            return false;
        }
        return true;
    }
}