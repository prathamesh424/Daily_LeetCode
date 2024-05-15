import java.util.* ;


public class FindTheSafestPathInAGrid2812 {
    /*
     * You are given a 0-indexed 2D matrix grid of size n x n, where (r, c) represents:
     * 
     * A cell containing a thief if grid[r][c] = 1
     * An empty cell if grid[r][c] = 0
     * 
     * You are initially positioned at cell (0, 0). In one move, you can move to any adjacent cell in the grid, 
     * including cells containing thieves.
     * 
     * The safeness factor of a path on the grid is defined as the minimum manhattan distance from any cell in the path to any thief in the grid.
     * 
     * Return the maximum safeness factor of all paths leading to cell (n - 1, n - 1).
     * 
     * An adjacent cell of cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) and (r - 1, c) if it exists.
     * 
     * The Manhattan distance between two cells (a, b) and (x, y) is equal to |a - x| + |b - y|,
     *  where |val| denotes the absolute value of val.
     * 
     */

     class Solution {

        final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
   
       public int maximumSafenessFactor(List<List<Integer>> grid) {
           int n = grid.size();
           int[][] mat = new int[n][n];
           Queue<int[]> multiSourceQueue = new LinkedList<>();
   
           
            for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                   if (grid.get(i).get(j) == 1) {
                        multiSourceQueue.add(new int[]{i, j});
                        mat[i][j] = 0;
                   } else {
                        mat[i][j] = -1;
                   }
               }
           }
   
            while (!multiSourceQueue.isEmpty()) {
               int size = multiSourceQueue.size();
               while (size-- > 0) {
                   int[] curr = multiSourceQueue.poll();
                    for (int[] d : dir) {
                       int di = curr[0] + d[0];
                       int dj = curr[1] + d[1];
                       int val = mat[curr[0]][curr[1]];
                        if (isValidCell(mat, di, dj) && mat[di][dj] == -1) {
                            mat[di][dj] = val + 1;
                           multiSourceQueue.add(new int[]{di, dj});
                       }
                   }
               }
           }
   
           int start = 0;
           int end = 0;
           int res = -1;
           for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                    end = Math.max(end, mat[i][j]);
               }
           }
   
           while (start <= end) {
               int mid = start + (end - start) / 2;
               if (isValidSafeness(mat, mid)) {
                    res = mid; 
                   start = mid + 1;
               } else {
                   end = mid - 1;
               }
           }
           return res;
       }
   
       private boolean isValidSafeness(int[][] grid, int minSafeness) {
           int n = grid.length;
   
            if (grid[0][0] < minSafeness || grid[n - 1][n - 1] < minSafeness) {
               return false;
           }
   
           Queue<int[]> traversalQueue = new LinkedList<>();
           traversalQueue.add(new int[]{0, 0});
           boolean[][] visited = new boolean[n][n];
           visited[0][0] = true;
   
            while (!traversalQueue.isEmpty()) {
               int[] curr = traversalQueue.poll();
               if (curr[0] == n - 1 && curr[1] == n - 1) {
                   return true; 
               }
                for (int[] d : dir) {
                   int di = curr[0] + d[0];
                   int dj = curr[1] + d[1];
                    if (isValidCell(grid, di, dj) && !visited[di][dj] && grid[di][dj] >= minSafeness) {
                       visited[di][dj] = true;
                       traversalQueue.add(new int[]{di, dj});
                   }
               }
           }
           return false;  
       }
       private boolean isValidCell(int[][] mat, int i, int j) {
           int n = mat.length;
           return i >= 0 && j >= 0 && i < n && j < n;
       }
   }
    
} 