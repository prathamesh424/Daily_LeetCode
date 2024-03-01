
public class maxOdd_2664 {
    /*You are given a binary string s that contains at least one '1'.

You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.

Return a string representing the maximum odd binary number that can be created from the given combination.

Note that the resulting string can have leading zeros. */



public static void main(String[] args) {
    Solution2664 obj = new Solution2664() ;
    String s = obj.maximumOddBinaryNumber("00110100");
    System.out.println(s);
} 


}


class Solution2664 {
    public String maximumOddBinaryNumber(String s) {
        int count1 = 0 ;
        int count0 = 0 ;

        // counting  1 and 0
        for (char c : s.toCharArray()) {
            if(c=='1') count1++;
            else count0++;
        }
        StringBuilder sb = new StringBuilder() ;

        // adding .....char '1' to StringBuilder  (count1 -1) times
        for (int i = 1 ; i < s.length() ; i++) {
            if (count1-- > 1) sb.append('1') ;
            // if '1' count over in string then add '0' (count0) times.
            else sb.append('0');
        }

        // number should be odd so add '1' at last to make it odd

        sb.append('1') ;

        return sb.toString() ;
    }
}