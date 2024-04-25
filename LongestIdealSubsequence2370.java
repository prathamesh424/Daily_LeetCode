import java.util.* ;
import java.util.Map;


public class LongestIdealSubsequence2370 {
    /*
     * You are given a string s consisting of lowercase letters and an integer k.
     * We call a string t ideal if the following conditions are satisfied:
      
     *  t is a subsequence of the string s.
        The absolute difference in the alphabet order of every two adjacent letters in t is less than or equal to k.
        Return the length of the longest ideal string.
        
        A subsequence is a string that can be derived from another string by deleting some or no characters 
        without changing the order of the remaining characters.
        
        Note that the alphabet order is not cyclic.
        For example, the absolute difference in the alphabet order of 'a' and 'z' is 25, not 1
     */

     class Solution {
        public int longestIdealString(String s, int k) {
            int dp[]= new int [26] ;
            int n = s.length() ;
            int ans = 0 ;
            for (int i = 0; i < n; i++) {
                int curr = s.charAt(i)-'a';
                int nxt =0;
                for (int j = 0; j < 26; j++) 
                    if (Math.abs(j - curr) <= k)
                        nxt= Math.max(ans, j);
                
                dp[curr] = Math.max(dp[curr] , nxt+1);
                ans = Math.max(dp[curr], ans) ;
            }
            return ans ;
        }
    }
    
}