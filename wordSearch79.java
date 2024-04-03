public class wordSearch79 {
    class Solution {

        /*
         * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
         * The word can be constructed from letters of sequentially adjacent cells, 
         * where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
         */
        public boolean exist(char[][] board, String word) {
            int m = board.length ;
            int n = board[0].length ;
            boolean[][] vis = new boolean[m][n] ;
            boolean ans = false ; 

                // search first character match : 

                for (int r = 0 ; r < m ; r++) {
                    for (int c = 0 ; c < n ; c++) {
                        if (board[r][c] == word.charAt(0)){
                            ans = backtrack(board , word , vis , r , c , 0) ;
                            if (ans) return true ;
                        }
                    }
                }
                return false;
        }


        private boolean backtrack(char[][] board , String word , boolean [][] vis 
        , int r , int c , int curr)
        {
            if(curr == word.length()) return true ; // last char

            if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
             || vis[r][c] || board[r][c] != word.charAt(curr)) return false ;  // invalid path .....


            vis[r][c] = true ; // visite curr location
    
                                                    // try all possible ways to find  "word"
            if (backtrack(board , word , vis , r+1 , c , curr+1) ||
                backtrack(board , word , vis , r-1, c , curr+1)  ||
                backtrack(board , word , vis , r , c+1 , curr+1) ||
                backtrack(board , word , vis , r , c-1 , curr+1) ) return true ;
    
            vis[r][c] = false ; // unviste the location ....
            return false ; 
        }
    }
}
