import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MaximalRectangle85 {
    /*
     * Given a rows x cols binary matrix filled with 0's and 1's, 
     * find the largest rectangle containing only 1's and return its area.
     */




    class Solution {
        public int maximalRectangle(char[][] matrix) {

            int n = matrix.length , m = matrix[0].length ;
            if (matrix == null || n == 0 || m == 0) return 0 ; // invalid conditions return 0 
            int maxArea = 0 ;
            int height [] = new int[m+ 1] ; // to store current row area unit 

            for (char[] row : matrix) {
                for (int i = 0; i < m; i++) height[i] = (row[i] == '1') ? height[i]+1 : 0; // update the height array 

                Stack<Integer> st = new Stack<>() ; 
                for (int i = 0; i < height.length; i++) {  // check in height array 
                    while (!st.isEmpty() && height[i] < height[st.peek()]) {  // if array is not empty and current element height[i] < height[stack.top] ;
                        int h = height[st.pop()] ;  // current height
                        int w = st.isEmpty() ? i : i - st.peek() - 1 ; // current width 
                        maxArea = Math.max(maxArea, h *w); // update the MaxArea 
                    }
                    st.push(i) ; // push in stack current location ..
                }  
            }
            return maxArea ;
        }
    }



    // optimized approach  
    class Solution2 {
        public int maximalRectangle(char[][] matrix) {
            
            if (matrix.length == 0) return 0 ; // invalid conditions return 0 
            int maxArea = 0 ;
            int height [] = new int[matrix[0].length] ; // to store current row area unit 

            for (char[] row : matrix) {
                for (int i = 0; i < row.length; ++i) height[i] = (row[i] == '1') ? height[i]+1 : 0; // update the height array 
                maxArea = Math.max(maxArea, largestRect(height)) ;
            }
            return maxArea ;
        }

        private int largestRect (int [] height){
            int area = 0 ;

            Deque<Integer> st = new ArrayDeque<>(); 

                for (int i = 0; i <= height.length; ++i) {  // check in height array 
                    while (!st.isEmpty() && ( i == height.length || height[i] < height[st.peek()])) {  // if array is not empty and current element height[i] < height[stack.top] ;
                        final int h = height[st.pop()] ;  // current height
                        final int w = st.isEmpty() ? i : i - st.peek() - 1 ; // current width 
                        area = Math.max(area,h *w) ; // update the MaxArea 
                    }
                st.push(i) ; 
                }

                return area ;
    }
    
}

}
