import java.util.* ;





public class RelativeRanks506 {
    /*
     * You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. 
     * All the scores are guaranteed to be unique.
     * 
     * The athletes are placed based on their scores, where the 1st place athlete has the highest score, 
     * the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
     * 
     * The 1st place athlete's rank is "Gold Medal" .
     * The 2nd place athlete's rank is "Silver Medal".
     * The 3rd place athlete's rank is "Bronze Medal".
     * 
     * For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
     * 
     * Return an array answer of size n where answer[i] is the rank of the ith athlete.
     */

     class Solution {

        // suing HashMap : -

        public String[] findRelativeRanks(int[] score) {
            int n  = score.length;
            String [] ans = new String[n];
            int [] rank =  score ;
            Map<Integer , Integer > map= new HashMap<>() ;
    
            for (int i = 0 ; i< n; i++) {
                map.put(rank[i] , i);
            }
            Arrays.sort(rank);

            for (int i = 0 ; i < n ; i++) {
                if (i==0) ans[map.get(rank[n - i -1])] = "Gold Medal" ;
                else if (i==1) ans[map.get(rank[n - i -1])] = "Silver Medal" ;
                else if (i==2) ans[map.get(rank[n - i -1])] = "Bronze Medal" ;
                else ans[map.get(rank[n - i -1])]= Integer.toString(i+1);
                
             }
             return ans ;
        }
    }
    
    class Solution2 {
        // using Heap : -
        
        public String[] findRelativeRanks(int[] score) {
            int n = score.length ;

            PriorityQueue<Pair<Integer , Integer >> heap = new PriorityQueue<>(
                (a ,b) -> b.getKey() - a.getKey());
            
            for (int i = 0; i < n; i++)
                heap.add(new Pair<>(score[i] , i));

            int idx = 1 ;
            String [] ans = new String[n] ;
            while (!heap.isEmpty()){
                Pair<Integer ,Integer> pair= heap.poll() ;
                int rankIdx = pair.getValue() ;
                if (idx==1) ans[rankIdx] = "Gold Medal" ;
                else if (idx==2) ans[rankIdx] = "Silver Medal" ;
                else if (idx==3) ans[rankIdx] = "Bronze Medal" ;
                else ans[rankIdx]= String.valueOf(idx);    
                idx++;            
            }
            return ans ;


        }
}


class OPptimalSolution {
    public String[] findRelativeRanks(int[] score) {
        int N = score.length;

        int M = score[0];
        for (int s : score)
            if (s > M) 
                M = s;
            
        
        int[] scoreToIndex = new int[M + 1];
        for (int i = 0; i < N; i++) {
            scoreToIndex[score[i]] = i + 1;
        }

        final String[] MEDALS = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] rank = new String[N];
        int place = 1;
        for (int i = M; i >= 0; i--) {
            if (scoreToIndex[i] != 0) {
                int originalIndex = scoreToIndex[i] - 1;
                if (place < 4) {
                    rank[originalIndex] = MEDALS[place - 1];
                } else {
                    rank[originalIndex] = String.valueOf(place);
                }
                place++;
            }
        }
        return rank;
    }
}
    
}
