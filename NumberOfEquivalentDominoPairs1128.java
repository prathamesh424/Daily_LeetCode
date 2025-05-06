import java.util.*;

public class NumberOfEquivalentDominoPairs1128 {
    /*
     * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] 
     * if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.
     * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
     */
    
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            int count = 0;
            for (int i = 0; i < dominoes.length; i++) {
                for (int j = i + 1; j < dominoes.length; j++) {
                    if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) ||
                            (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])) {
                        count++;
                    }
                }
            }
            return count;
        }
        
        public int numEquivDominoPairsOptimised(int[][] dominoes) {
             HashMap<String, Integer> map = new HashMap<>();
            for (int[] domino : dominoes) {
                 String key = Math.min(domino[0], domino[1]) + "," + Math.max(domino[0], domino[1]);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int count = 0;
            for (int freq : map.values()) {
                count += (freq * (freq - 1)) / 2; // nC2 = n! / (2!(n-2)!)
            }
            return count;
        }
    }


}
