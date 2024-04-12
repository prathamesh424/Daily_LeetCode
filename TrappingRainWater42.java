 
 public class TrappingRainWater42 {
    /*
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     *  compute how much water it can trap after raining.
     */

     
    class Solution {
        public int trap(int[] ht){
            // initial condition checking length ...
            int n = ht.length ;
            if (n == 0) return 0 ;
                // pointing to left_max and Right_max values and  i,j for current left , and right position resp.
            int i = 0 , left = ht[0] , sum=0  ;
            int j = n-1 , right = ht[j] ;
            
            while (i<j){ // passing middle terminate the loop
                if (left <= right){ // if max value at right is greater or equal
                    // update the sum  and left_max and increment 'i' 
                    sum += (left - ht[i]);
                    i++;
                    left = Math.max(left , ht[i]);
                }
                else {
                    // update the sum and right_max and decrement 'j' 
                    sum += (right - ht[j]);
                    j--;
                    right = Math.max(right , ht[j]);
                }
            }
            // return the answer...
            return sum ;
        }
    }
    
 }