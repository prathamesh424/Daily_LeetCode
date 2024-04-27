import java.util.*;
import java.util.Map;


public class FreedomTrail514 {


            /*
             * In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the
             *  "Freedom Trail Ring" and use the dial to spell a specific keyword to open the door.
             * 
             * Given a string ring that represents the code engraved on the outer ring and another
             *  string key that represents the keyword that needs to be spelled, return the minimum number of steps to
             *  spell all the characters in the keyword.
             * 
             * Initially, the first character of the ring is aligned at the "12:00" direction. 
             * You should spell all the characters in key one by one by rotating ring clockwise or anticlockwise to 
             * make each character of the string key aligned at the "12:00" direction and then by pressing the center button.
             
             * At the stage of rotating the ring to spell the key character key[i]:
             
             * 1. You can rotate the ring clockwise or anticlockwise by one place, which counts as one step. 
                The final purpose of the rotation is to align one of ring's characters at the "12:00" direction, 
                where this character must equal key[i].
             * 
             *2 .If the character key[i] has been aligned at the "12:00" direction, press the center button to spell,
                which also counts as one step. After the pressing, you could begin to spell the next character in the key (next stage).
                Otherwise, you have finished all the spelling.
             */


    class Solution {
        private final int MIN = Integer.MAX_VALUE;
        public int findRotateSteps(String ring, String key) {

            //using dynamic programming :- 
        // ----- History store 
            Map<Pair<Integer , Integer > , Integer > memo = new HashMap<>();
            return combinataion( 0 , 0 , ring , key , MIN , memo) ;
        }

        private int combinataion (int ringCurr , int keyCurr , String ring , String key , int minCnt ,
        Map<Pair<Integer , Integer > , Integer > memo){
            // memo contain info return 
            if (memo.containsKey(new Pair<>(ringCurr , keyCurr))){
                return memo.get(new Pair<>(ringCurr , keyCurr));
            }

            // key already found
            if (keyCurr == key.length()) return 0 ;

            // find in ring key characters  : - 

            for (int i = 0; i < ring.length(); i++) {
                // match
                if (ring.charAt(i) == key.charAt(keyCurr)){
                    // +1 - for button or activation of ring 
                    int curr = count(ringCurr, i, ring.length()) + 1+
                        combinataion(ringCurr, keyCurr+1, ring, key, MIN, memo);
                    
                    // select min 
                    minCnt = Math.min(minCnt, curr);
                    // add current to memo 
                    memo.put(new Pair<>(ringCurr , keyCurr) , minCnt);
                }
            }
            return minCnt ;
        }

        private int count (int curr  , int nxt , int len){
            //clockwise
            int rotate = Math.abs(curr - nxt);
            //anticlockwise 
            int anti = len - rotate ;
            //return min 
            return Math.min(rotate, anti) ;
        }
    }
}
