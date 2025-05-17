
public class LookAndSayPattern {
    /*
     * Given an integer n. Return the nth row of the following look-and-say pattern.
    1
    11
    21
    1211
    111221
    Look-and-Say Pattern:
    
    To generate a member of the sequence from the previous member, read off the digits of the previous member, counting the number of digits in groups of the same digit. For example:
    
    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.
    1211 is read off as "one 1, one 2, then two 1s" or 111221.
    111221 is read off as "three 1s, two 2s, then one 1" or 312211.
     */
    
    class Solution {
        public String countAndSay(int n) {
            if (n == 1) {
                return "1";
            }
            String prev = countAndSay(n - 1);
            StringBuilder result = new StringBuilder();
            int count = 1;
            for (int i = 1; i < prev.length(); i++) {
                if (prev.charAt(i) == prev.charAt(i - 1)) {
                    count++;
                } else {
                    result.append(count).append(prev.charAt(i - 1));
                    count = 1;
                }
            }
            result.append(count).append(prev.charAt(prev.length() - 1));
            return result.toString();
        }
    }
    
}
