import java.util.* ;
import java.util.ArrayList ;

public class XORQueriesOfASubarray1310 {
    /*
     * You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].

For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).

Return an array answer where answer[i] is the answer to the ith query.

 
     */



     class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int ans[] = new int[queries.length] ;
            for (int i = 0; i < queries.length; i++) {
                int req = 0 ;
               for (int j = queries[i][0] ; j<= queries[i][1] ; j++){
                    req ^= arr[j];
                }
                ans[i] = req;
            }
            return ans;
        }
    }

    //minimize the time by increasing space
    class Solution1 {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int n= arr.length;
            int [] allQueryAns = new  int [n+ 1] ;

            for (int i = 0; i < n; i++) 
                allQueryAns[i+1] = allQueryAns[i] ^ arr[i];

            int [] ans = new int[queries.length] ;
            for (int i = 0; i < queries.length; i++) {
                ans[i] = allQueryAns[queries[i][1]+1] ^ allQueryAns[queries[i][0]];
            }
            return ans;
        }
    }

    ////minimize the time by without increasing space


    class Solution3 {
        public int[] xorQueries(int[] arr, int[][] queries) {
                 List<Integer> result = new ArrayList<>();
                 for (int i = 1; i < arr.length; ++i) 
                 arr[i] ^= arr[i - 1];
     
                 for (int[] q : queries) {
                     if (q[0] > 0)  result.add(arr[q[0] - 1] ^ arr[q[1]]);
                     else result.add(arr[q[1]]);
                 }
                 return result.stream().mapToInt(i -> i).toArray();
             }
     }
}
