import java.util.ArrayList;

public class PascalTriangle {
  // User function Template for Java
  /*
   * Given a positive integer n, return the nth row of pascal's triangle.
Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.
   */
  class Solution {

      public ArrayList<Integer> nthRowOfPascalTriangle(int n) {
            n -= 1; 
          ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                ans.add(nCr(n, i));
            }
          return ans;
      }

      private int nCr(int n, int r) {
          if (r == 0 || r == n) {
              return 1;
          }
          return nCr(n - 1, r - 1) + nCr(n - 1, r);
      }
      
  }

}
