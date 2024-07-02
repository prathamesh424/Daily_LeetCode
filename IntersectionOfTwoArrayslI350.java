import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrayslI350 {
    /*
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     *  Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
     */

    class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>() ;
        int l2 = nums2.length ;
        
        Arrays.sort(nums2) ;
        Arrays.sort(nums1) ;

        int j = 0 ;
        for (int i : nums1){ 
            while(j < l2 && nums2[j] <= i){
                if (i == nums2[j]){ 
                    ans.add(i);
                    j++;
                    break;
                }
                j++; 
            }
        }
        int [] arr =  new int[ans.size()] ;
        j = 0;
        for (int k : ans) arr[j++] = k ;
    
        return arr ;
    }
}
}
