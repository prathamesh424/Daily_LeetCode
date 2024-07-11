import java.util.*;

public class ReverseSubstringsBetweenEachPairOfParentheses1190 {
        /*
         * You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.
         */


        class Solution {
            public String reverseParentheses(String s) {
                Stack<Integer> stack = new Stack<>() ;
                StringBuilder sb  = new StringBuilder();
                int i = 0 ;
                for (char c : s.toCharArray()) {
                    if (c == '(') stack.push(sb.length());
                    else if (c == ')') {
                        int start = stack.pop();
                        reverse(sb, start, sb.length()-1);
                    }
                    else sb.append(c);
                }
                return sb.toString();
            }

            public void reverse(StringBuilder s , int start , int end) {
                while (start < end) {
                    char temp = s.charAt(start);
                    s.setCharAt(start++, s.charAt(end));
                    s.setCharAt(end--, temp);
                }
            }
            
        }
}