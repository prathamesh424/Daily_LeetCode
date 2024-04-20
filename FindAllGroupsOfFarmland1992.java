import java.util.*;

public class FindAllGroupsOfFarmland1992 {
    /*
     * You are given a 0-indexed m x n binary matrix land where a 0 represents a hectare of forested land
     *  and a 1 represents a hectare of farmland.

    To keep the land organized, there are designated rectangular areas of hectares 
    that consist entirely of farmland. These rectangular areas are called groups.
    No two groups are adjacent, meaning farmland in one group is not four-directionally adjacent to another farmland in a different group.
    
    land can be represented by a coordinate system where the top left corner of land is (0, 0)
     and the bottom right corner of land is (m-1, n-1). Find the coordinates of the top left 
     and bottom right corner of each group of farmland. A group of farmland with a top left corner at (r1, c1) 
     and a bottom right corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].
    
     Return a 2D array containing the 4-length arrays described above for each group of farmland in land. 
     If there are no groups of farmland, return an empty array. You may return the answer in any order.
     */



    // this can valid only "42" test conditions to try new approach  ........   /* INVALID */ :-


    class Solution {
        public int[][] findFarmland(int[][] land) {
            int m = land.length ;
            int n = land[0].length  ;
            ArrayList<int []> ans = new ArrayList<>();

            for(int i =0 ; i < m ;i++){
                for(int j = 0 ; j < n ;j++){
                    if (land[i][j] == 1){
                        int arr[] = {i , j , 0 , 0};
                        dfs(land, i, j, arr);
                        ans.add(arr);
                    }
                }
            }
         
            return ans.stream().toArray(int[][] :: new);
        }
    
        private void dfs(int [][] land , int i , int j , int ans[]){
            if(i > land.length || i < 0 || j > land[0].length || j < 0 || land[i][j] < 1){
                return ;
            }
    
            if(ans[0] > i) ans[0] = i ;
            if(ans[0] > j) ans[1] = j ;
            if(ans[0] < i) ans[2] = i ;
            if(ans[0] < i) ans[3] = j ;
    
            land[i][j] = -1 ;
    
            dfs(land , i+1 , j , ans );
            dfs(land , i-1 , j , ans );
            dfs(land , i , j+1 , ans );
            dfs(land , i , j-1 , ans );
     
        }
    }


                // Accepted ... but not optimal .
    class Solution2 {
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int r2, c2;
        
        private boolean isWithinFarm(int x, int y, int N, int M) {
            return x >= 0 && x < N && y >= 0 && y < M;
        }
        
        private void DFS(int[][] land, boolean[][] visited, int x, int y) {
            visited[x][y] = true;
            r2 = Math.max(r2, x); c2 = Math.max(c2, y);
            
            for (int[] dir : dirs) {
                int newX = x + dir[0], newY = y + dir[1];
                if (isWithinFarm(newX, newY, land.length, land[0].length) && !visited[newX][newY]
                        && land[newX][newY] == 1) {
                    DFS(land, visited, newX, newY);
                }
            }
        }
        
        public int[][] findFarmland(int[][] land) {
            boolean[][] visited = new boolean[land.length][land[0].length];
            List<int[]> ans = new ArrayList<>();
    
            for (int row1 = 0; row1 < land.length; row1++) {
                for (int col1 = 0; col1 < land[0].length; col1++) {
                    if (land[row1][col1] == 1 && !visited[row1][col1]) {
                         r2 = 0; c2 = 0;
    
                        DFS(land, visited, row1, col1);
                        
                        int[] arr = new int[] {row1, col1, r2, c2};
                        ans.add(arr);
                    }
                }
            }
            
            return ans.stream().toArray(int[][] :: new);
        }
    }





    // After optimization : -

class optimalSolution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> req = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[] ans = find(land, i, j);
                    req.add(ans);
                }
            }
        }
        return req.toArray(new int[req.size()][]);
    }
    
    private int[] find(int[][] land, int row, int col) {
        int[] ans = new int[4];
        ans[0] = row;
        ans[1] = col;
        
        int m = land.length;
        int n = land[0].length;
        
        int r = row;
        int c = col;

        while (r < m && land[r][col] == 1) r++;
        while (c < n && land[row][c] == 1) c++;
        ans[2] = r - 1;
        ans[3] = c - 1;
    
        for (int i = row; i < r; i++) {
            for (int j = col; j < c; j++) {
                land[i][j] = 0;
            }
        }
        
        return ans;
    }
}


}


