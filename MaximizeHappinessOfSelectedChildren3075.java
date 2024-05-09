import java.util.* ;


public class MaximizeHappinessOfSelectedChildren3075 {
    /*
     * You are given an array happiness of length n, and a positive integer k.
     * 
     * There are n children standing in a queue, where the ith child has happiness value happiness[i].
     *  You want to select k children from these n children in k turns.
     * 
     * In each turn, when you select a child, the happiness value of all the children that have not been selected till now decreases by 1.
     *  Note that the happiness value cannot become negative and gets decremented only if it is positive.
     * 
     * Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children.
     */


    class Solution {
        public long maximumHappinessSum(int[] happiness, int k) {
            int n = happiness.length ;
            Integer [] sorted =  new Integer[n];
            for (int i = 0; i < n; i++) sorted[i] = happiness[i] ;
            
            Arrays.sort(sorted , Collections.reverseOrder());
            long sum = 0 ;
            for (int i = 0 ; i <k;i++) {
                sum += Math.max(sorted[i]-i , 0);
            }
            return sum ;
        }
    }

    class OptimalSolutionSolution {
        public long maximumHappinessSum(int[] h, int k) {
            long sum=0;
            int c=0,curr=0;
            Arrays.sort(h);
            for(int i=h.length-1;i>=h.length-k;i--){
                curr = h[i]-c++;
                if(curr>0) sum += curr ; 
            }
            return sum;
        }
    }



}
