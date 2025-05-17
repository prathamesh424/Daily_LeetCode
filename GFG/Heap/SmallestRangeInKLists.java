import  java.util.*;


public class SmallestRangeInKLists {
    /*
     * Given a 2d integer array arr[][] of size k*n, where each row is sorted in ascending order.
     *  Your task is to find the smallest range [l, r] that includes at least one element from each of the k lists.
     *  If more than one such ranges are found, return the first one.
     */
    /*
     * Time Complexity: O(n * k * log k)
        Auxiliary Space: O(k)

     */
     class Solution {
         public ArrayList<Integer> findSmallestRange(int[][] arr) {
                int n = arr.length;
                int k = arr[0].length;
                ArrayList<Integer> ans = new ArrayList<>();
                PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
                int max = Integer.MIN_VALUE;
    
                for (int i = 0; i < n; i++) {
                    pq.add(new int[]{arr[i][0], i, 0});
                    max = Math.max(max, arr[i][0]);
                }
    
                int rangeStart = pq.peek()[0];
                int rangeEnd = max;
    
                while (pq.size() == n) {
                    int[] minElement = pq.poll();
                    int minValue = minElement[0];
                    int rowIndex = minElement[1];
                    int colIndex = minElement[2];
    
                    if (rangeEnd - rangeStart > max - minValue) {
                        rangeStart = minValue;
                        rangeEnd = max;
                    }
    
                    if (colIndex + 1 < k) {
                        pq.add(new int[]{arr[rowIndex][colIndex + 1], rowIndex, colIndex + 1});
                        max = Math.max(max, arr[rowIndex][colIndex + 1]);
                    }
                }
    
                ans.add(rangeStart);
                ans.add(rangeEnd);
                return ans;
        }
    }
}
