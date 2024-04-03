import java.util.*;


public class IsomorphicStrings205 {

    /*
     * Given two strings s and t, determine if they are isomorphic.
        Two strings s and t are isomorphic if the characters in s can be replaced to get t.
        All occurrences of a character must be replaced with another character while preserving the 
        order of characters. No two characters may map to the same character, but a character may map to itself.
     */
    class Solution {
        public boolean isIsomorphic1(String s, String t) {
            int [] idxS = new int[200] ;
            int [] idxT = new int[200] ;
            int len = s.length() ;
            if (len != t.length()) return false ;
            for (int i = 0 ; i < len ;i++) {
                if (idxS[s.charAt(i)] != idxT[t.charAt(i)]) return false ;
                idxS[s.charAt(i)] = i+1; 
                idxT[t.charAt(i)] = i+1; 
            }        
            return true ;
        }



        // not passes all test cases....
        public boolean isIsomorphic(String s, String t) {
            if (s.equals(t))return true ;
            if (s.length() != t.length()) return false ; 
            HashMap<Character,Integer> map = new HashMap<>() ;
            for (char c : s.toCharArray()) {
                map.put(c , map.getOrDefault(c, 0) +1);
            }
            int arr1 [] = new int[s.length()];
            for (int n : map.values()){
                arr1[n]++;
            }
            map.clear();
            for (char c : s.toCharArray()) {
                map.put(c , map.getOrDefault(c, 0) +1);
            }
            int arr2 [] = new int[t.length()];
            for (int n : map.values()){
                arr1[n]++;
            }
            for (int i =0 ; i < s.length() ;i++) {
                if (arr1[i] != arr2[i]) return false ;
            } 
            return true ;
        }
    }
}
