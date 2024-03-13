
public class findPivotint2485 {
    /*
     * Given a positive integer n, find the pivot integer x such that:
            The sum of all elements between 1 and x inclusively equals the 
            sum of all elements between x and n inclusively.
        Return the pivot integer x. If no such integer exists, return -1. 
            It is guaranteed that there will be at most one pivot index for the given input.
     */

 
     // First thinking to solve Question  :-
    public int pivotInteger(int n) {
        if (n ==1 ) return 1;
        int e = n ;
        int eSum = n ;
        while (e > 1){
            int sSum = 0;
            for (int i = 1 ; i <= e; i++)sSum += i ;
            if (sSum == eSum) return e ;
            else if (sSum < eSum) return -1 ;
            eSum += e-1 ;
            e-- ;
        }
        return -1;
    }

        // using Math Knowledge 
    public int pivotInteger2(int n) {
        int e = n*(n+1)/2;
        int s = (int) Math.sqrt(e);
        if(s*s == e) return s;
        else return -1;
    }

    //if We use binary Search Approach then it will give "Time Extended Error" ;



    
}