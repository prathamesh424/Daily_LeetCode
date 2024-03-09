public class minCommonVal2540 {

    /* Question : -
        Given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
        return the minimum integer common to both arrays.
        If there is no common integer amongst nums1 and nums2, return -1.

        *** Note that an integer is said to be common to nums1 and nums2 if both arrays
         have at least one occurrence of that integer.
     
     */

     // using while loop (better )
    public int getCommon(int[] nums1, int[] nums2) {
        int len1 = nums1.length ;
        int len2 = nums2.length  ;
        // last element is greater then other array first element then they never equal , so return
        if (nums1[0] > nums2[len2-1] || nums2[0] > nums1[len1-1] ) return -1;
        int i =0 , j = 0 ;

        // checking equality
        while (i < len1 && j < len2){
            if (nums1[i] == nums2[j]) return nums1[i] ;
            else if (nums1[i] < nums2[j]) i++ ;
            else j++;
        }
        return -1 ;
    }



    // using for loop have high computation then  above 
    public int getCommon2(int[] nums1, int[] nums2) {
        int len= Math.max(nums1.length , nums2.length);
        for (int j =0 ,i =0 ;i < len && i <nums1.length && j < nums2.length ; i++){
            if (nums1[i] == nums2[j]) return nums1[i] ;
            else if (nums1[i] < nums2[j]) continue ;
            else if (nums1[i] > nums2[j]) {
                j++;
                i--;
            }
        }
        return -1 ;
    }
}
