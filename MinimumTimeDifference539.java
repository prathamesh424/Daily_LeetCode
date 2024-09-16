import java.util.*;

public class MinimumTimeDifference539 {
    /*
     * Given a list of 24-hour clock time points in "HH:MM" format,
     *  return the minimum minutes difference between any two time-points in the list.
     */

     class Solution {
        public int findMinDifference(List<String> timePoints) {
            int[] min = new int[timePoints.size()];
            for (int i = 0; i < timePoints.size(); i++) {
                String time = timePoints.get(i);
                int h = Integer.parseInt(time.substring(0, 2));
                int m = Integer.parseInt(time.substring(3));
                min[i] = h * 60 + m;
            }
            Arrays.sort(min);
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < min.length - 1; i++) {
                ans = Math.min(ans, min[i + 1] - min[i]);
            }
            return Math.min(ans,24 * 60 - min[min.length - 1] + min[0]
            );
        }
    }
}
