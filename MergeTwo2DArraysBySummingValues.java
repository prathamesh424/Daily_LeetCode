
import java.util.ArrayList;
import java.util.List;

/* 
 * You are given two 2D integer arrays nums1 and nums2.

nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
Each array contains unique ids and is sorted in ascending order by id.

Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

Only ids that appear in at least one of the two arrays should be included in the resulting array.
Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
Return the resulting array. The returned array must be sorted in ascending order by id.
 */


public class MergeTwo2DArraysBySummingValues {
    class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < n && j < m) {
            if (nums1[i][0] == nums2[j][0]) {
                list.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                list.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            } else {
                list.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            }
        }
        while (i < n) {
            list.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }
        while (j < m) {
            list.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }
        int[][] res = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
}
