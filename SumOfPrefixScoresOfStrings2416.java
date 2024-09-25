import java.util.* ;

public class SumOfPrefixScoresOfStrings2416 {


    /*
     * You are given an array words of size n consisting of non-empty strings.

We define the score of a string term as the number of strings words[i] such that term is a prefix of words[i].

For example, if words = ["a", "ab", "abc", "cab"], then the score of "ab" is 2, since "ab" is a prefix of both "ab" and "abc".
Return an array answer of size n where answer[i] is the sum of scores of every non-empty prefix of words[i].

Note that a string is considered as a prefix of itself.
     */
    class TrieNode  {
        TrieNode [] next = new TrieNode [26] ;
        int cnt = 0;
    }
    class Solution {
        TrieNode root = new TrieNode() ;

        void insert(String word) {
            TrieNode node = root ;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
                node.cnt++;
            }
        }

        int count(String s) {
            TrieNode node = root;
            int ans = 0 ;
            for (char c : s.toCharArray()) {
                ans += node.next[c - 'a'].cnt ;
                node = node.next[c - 'a'];
            }
            return ans;
        }

        public int[] sumPrefixScores(String[] words) {
            int n = words.length; 
            for (String word : words) {
                insert(word);
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = count(words[i]);
            }
            return ans;
        }
    }
}
