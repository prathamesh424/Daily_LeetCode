import java.util.*;

public class KthSmallestPrimeFraction786 {
    /*
     * You are given a sorted integer array arr containing 1 and prime numbers, 
     * where all the integers of arr are unique. You are also given an integer k.
     * 
     * For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].
     * 
     * Return the kth smallest fraction considered. Return your answer as an array of integers of size 2,
     *  where answer[0] == arr[i] and answer[1] == arr[j].
     */




    // by Binary Search : - 

    class Solution {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            int n = arr.length ;
            
            double l = 0 , r  = 1.0 ;

            while(l < r) {
                double mid = (l +r) /2 ;

                double maxFrac = 0.0 ;
                int j =1;
                int total = 0 , numIdx = 0 , denoIdx = 0;

                for (int i = 0; i < n; i++) {
                    while (j < n && arr[i] >= mid * arr[j]) j++ ;
                    total += (n-j) ;
                    if(j ==n) break ;

                    double frac = (double ) arr[i] / arr[j] ;
                    if (frac > maxFrac){
                        numIdx = i ;
                        denoIdx = j ;
                        maxFrac = frac ;
                    }
                    if (total == k ) return new int []{arr[numIdx] , arr[denoIdx] };
                    else if (total > k) r = mid ;
                    else l = mid ;
            }
        }
            return new int[]{};               
        }
    }
    
}
