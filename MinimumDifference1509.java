import java.util.*;

public class MinimumDifference1509 {
    class Solution {
        public int minDifference (int [] nums) {
            int len = nums.length;
            if (len <= 4) return 0 ;
            if (len == 5) return 1 ;
            Arrays.sort(nums) ;
            int min= Integer.MAX_VALUE ;

            for (int i = 0 , j = len -4 ; i < 4 ; i++ , j++) 
                min = Math.min(min, nums[i] - nums[j]);

            return min;
        }
    }
}
