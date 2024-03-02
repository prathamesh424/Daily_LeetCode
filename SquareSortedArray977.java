import java.util.Arrays;

public class SquareSortedArray977 {
    /*Given an integer array nums sorted in non-decreasing order,
     return an array of the squares of each number sorted in non-decreasing order. */
     public static void main(String[] args) {
         
     }
}

class Solution {
    // Approach no 1 by brute force : -
    public int[] sortedSquares(int[] nums) {
        for (int i = 0 ; i< nums.length ; i++) {
            nums[i] =  Math.abs(nums[i]*nums[i]) ;
        }
        Arrays.sort(nums) ;
        
        return nums  ;
    }


    // Approach no 2 by Binary Search :
    public int[] sortedSquares2(int[] nums) {
        int res [] =new int [nums.length] ;
        int l =0 , r =nums.length , i = nums.length  , sq = 0 ;

        while (l <= r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) sq = nums[l++] ; // if left side value is big 
            else sq = nums[r--]; // if right side value is big 
            res[i--]= sq*sq; // storing the value of square in result 
        }
        return res ; // return result array 
    }
    
}
