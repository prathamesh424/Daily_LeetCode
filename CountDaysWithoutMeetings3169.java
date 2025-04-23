import java.util.Arrays;
import java.util.Comparator;

public class CountDaysWithoutMeetings3169 {
    /*
     * You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).
    
    Return the count of days when the employee is available for work but no meetings are scheduled.
    
    Note: The meetings may overlap.
    
    
     */
    
    class Solution {
        public int countDays(int days, int[][] meetings) {
            int count = 0;
            boolean[] isMeeting = new boolean[days + 1];
            for (int i = 0; i < meetings.length; i++) {
                for (int j = meetings[i][0]; j <= meetings[i][1]; j++) {
                    isMeeting[j] = true;
                }
            }
            for (int i = 1; i <= days; i++) {
                if (!isMeeting[i]) {
                    count++;
                }
            }
            return count;
        }
    }

    public int countDays(int days, int[][] meetings) {
        int freeDays = 0, latestEnd = 0;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }
            latestEnd = Math.max(latestEnd, end);
        }
        freeDays += days - latestEnd;

        return freeDays;
    }


}
