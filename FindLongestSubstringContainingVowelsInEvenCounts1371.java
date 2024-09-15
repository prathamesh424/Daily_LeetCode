public class FindLongestSubstringContainingVowelsInEvenCounts1371 {
    /*
     * Given the string s, return the size of the longest substring containing each vowel an even number of times.
     *  That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.
     */

     // Using Bitmasking and XOR for parity checking .
    class Solution {
        public int findTheLongestSubstring(String s) {
            int prefixXOR = 0 ; 
            int [] charMap = new int[26] ;
            charMap['a' - 'a'] = 1 ;
            charMap['e' - 'a'] = 2 ;
            charMap['i' - 'a'] = 4 ;
            charMap['o' - 'a'] = 8 ;
            charMap['u' - 'a'] = 16 ;
            int [] mp  = new int[32] ;
            for (int i = 0 ; i < 32 ; i++)  mp[i] = -1 ;
            int ans = 0 ;
            for (int i = 0 ; i < s.length() ; i++) {
                prefixXOR ^= charMap[(s.charAt(i) - 'a')] ;
                if (mp[prefixXOR] == -1  && prefixXOR != 0) mp[prefixXOR] = i ;
                ans =Math.max(ans, i - mp[prefixXOR]);
            }
            return ans ;
        }
    }
}
