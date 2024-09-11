public class MinimumBitFlipsToConvertNumber2220 {

    /*
     * A bit flip of a number x is choosing a bit in the binary representation of x and flipping it from either 0 to 1 or 1 to 0.

For example, for x = 7, the binary representation is 111 and we may choose any bit (including any leading zeros not shown) and flip it. We can flip the first bit from the right to get 110, flip the second bit from the right to get 101, flip the fifth bit from the right (a leading zero) to get 10111, etc.
Given two integers start and goal, return the minimum number of bit flips to convert start to goal.
     */
    class Solution {
        public int minBitFlips(int start, int goal) {
            String s = Integer.toBinaryString(start);
            String g = Integer.toBinaryString(goal);
            int n = Math.max(s.length(), g.length());
            int ans = 0;
            if (n > s.length()) {
                int cnt = n -s.length() ;
                for (int i = 0; i < cnt; i++) s = "0" + s;
            }
            else {
                int cnt = n - g.length() ;
                for (int i = 0; i < cnt; i++) g = "0" + g;
            }

            for (int i = 0; i < n; i++) {
                if (s.charAt(i)!= g.charAt(i)) ans++;
            }
            return ans;
        }
    }
}
