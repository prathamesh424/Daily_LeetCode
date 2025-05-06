
import java.util.*;


public class SmallestDistinctWindow {
    /*
     * Given a string str, your task is to find the length of the smallest window that contains all 
     * the characters of the given string at least once.
     */

     class Solution {
         public int findSubString(String str) {
            int n = str.length();

            Set<Character> uniqueChars = new HashSet<>();
            for (char c : str.toCharArray()) {
                uniqueChars.add(c);
            }
            int required = uniqueChars.size();

            Map<Character, Integer> windowFreq = new HashMap<>();
            int minLen = Integer.MAX_VALUE;
            int left = 0, count = 0;

            for (int right = 0; right < n; right++) {
                char c = str.charAt(right);
                windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

                if (windowFreq.get(c) == 1) {
                    count++;
                }
                while (count == required) {
                    minLen = Math.min(minLen, right - left + 1);

                    char leftChar = str.charAt(left);
                    windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                    if (windowFreq.get(leftChar) == 0) {
                        count--;
                    }
                    left++;
                }
            }

            return minLen;
        }
}

}
