import java.util.HashMap;

public class SubstringsWithSameFirstAndLastCharacters {
    /*
     * Given a string s consisting of lowercase characters, 
             * the task is to find the count of all substrings that start and end with the same character.
     */

    
    class Solution {
        /*
         * Time Complexity: O(n)
        Auxiliary Space: O(1)
         */
        /*
         * Input: s = "abcab"
Output: 7
Explanation: There are 7 substrings where the first and last characters are the same: "a", "abca", "b", "bcab", "c", "a", and "b"
Input: s = "aba"
Output: 4
Explanation: There are 4 substrings where the first and last characters are the same: "a", "aba", "b", "a"
         */
        public int countSubstring(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        for (int freq : freqMap.values()) {
            count += (freq * (freq + 1)) / 2;
        }
        return count;
    }
}
}
