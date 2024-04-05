import java.util.*;

public class MakeStrGreat1544 {

    /*
     * Given a string s of lower and upper case English letters.
        A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:0 <= i <= s.length - 2
        s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
        To make the string good, you can choose two adjacent characters that make the string bad and remove them. 
        You can keep doing this until the string becomes good.
        Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
        Notice that an empty string is also good.
     */
    class Solution {
        public String makeGood(String s) {
            if(s.length() <= 1) return s ;
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            for (int i = 1 ;i <sb.length();i++){
                char curr = sb.charAt(i-1) ;
                char nxt = sb.charAt(i);
                 // using Ascii value a = 97 and A= 65  => difference = 32....

                if ((curr + 32 == nxt)||(curr == nxt + 32)){
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i-1); 
                    //go back so not miss any bad elements..
                    i = 0;
                }
            }
            return sb.toString() ;
        }
    }
    
}