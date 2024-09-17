import java.util.* ;
import java.util.Map;

public class UncommonansfromTwoSentences884 {
/*
 * A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.
 */
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String , Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (String word : s1.split(" ")) 
            map.put(word , map.getOrDefault(word, 0) + 1);
        for (String word : s2.split(" ")) 
            map.put(word, map.getOrDefault(word, 0) + 1) ;

        for (String word : map.keySet()) {
            if (map.get(word) == 1)
                ans.add(word);
        }
        return ans.toArray( new String[ans.size() ] );
    }
}

}
