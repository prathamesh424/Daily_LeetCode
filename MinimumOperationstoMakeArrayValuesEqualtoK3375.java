import java.util.HashSet;



class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> table = new HashSet<>() ;
        for (int  num : nums) {
            if (num < k)  return -1 ;
            else if (num > k ) table.add(num);
        } 
        return table.size();
    } 
}