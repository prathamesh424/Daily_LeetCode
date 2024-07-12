import java.util.*;

public class MaximumScoreFromRemovingSubstrings1717 {
    /*You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.

  */

  class Solution {
    public int maximumGain(String s, int x, int y) {
        int score = 0 ; 
        String high= x>y ? "ab" : "ba" ;
        String low = high.equals("ba") ? "ab" : "ba" ;
        String first = removeSub(s, high); 
        int cnt =  (s.length() - first.length()) /2;
        score += cnt * Math.max(x, y);
        String second = removeSub(first, low); 
        cnt = (first.length() - second.length()) /2;
        score += cnt * Math.min(x, y);
        return score ;
    }

    private String removeSub(String s , String target){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if ( curr == (target.charAt(1))  && !stack.isEmpty() && stack.peek()==(target.charAt(0))){
                stack.pop() ;
            }
            else stack.push(curr);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }  
}

//optimal solution: -
class optimalSolution {

    public int maximumGain(String s, int x, int y) {
         if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            s = new StringBuilder(s).reverse().toString();
        }

        int aCount = 0, bCount = 0, totalPoints = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == 'a') {
                aCount++;
            } else if (currentChar == 'b') {
                if (aCount > 0) {
                     aCount--;
                    totalPoints += x;
                } else {
                     bCount++;
                }
            } else {
                 totalPoints += Math.min(bCount, aCount) * y;
                 aCount = bCount = 0;
            }
        }
        totalPoints += Math.min(bCount, aCount) * y;
        return totalPoints;
    }
}
}
