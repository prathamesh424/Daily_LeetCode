import java.util.*;

public class NodesBetweenCriticalPoints2058 {

    /*
     * A critical point in a linked list is defined as either a local maxima or a local minima.
     * 
     * A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.
     * 
     * A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.
     * 
     * Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
     * 
     * Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] 
     * where minDistance is the minimum distance between any two distinct critical points and maxDistance 
     * is the maximum distance between any two distinct critical points. 
     * If there are fewer than two critical points, return [-1, -1] .
     * 
     */

    public class ListNode {
        int val ;
        ListNode next  ;
        ListNode(){}; 
        ListNode( int val) {this.val= val ;} ;
        ListNode (int val  , ListNode next) {
            this.next = next ;
            this.val = val ;
        }
    }

    class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            int ans [] = {-1 , -1} ;
            ListNode pre = head; 
            int min = Integer.MAX_VALUE ;
            ListNode curr = head.next ;

            int currIdx = 1  ;
            int preIdx = 0 ;
            int initIdx = 0 ;

            while (curr.next != null){

                if ((pre.val < curr.val && curr.next.val < curr.val )||(pre.val > curr.val && curr.next.val > curr.val)){ 
                    if (preIdx == 0 ) {
                        initIdx = currIdx ;
                        preIdx = currIdx ;
                    } 
                    else {
                        min = Math.min(min, currIdx - preIdx) ;
                        preIdx = currIdx ;
                    }
                }

                currIdx++;
                pre = curr ;
                curr = curr.next ;
            }

            if (min != Integer.MAX_VALUE) {
                ans = new int[]{min , preIdx - initIdx} ;
            }
            return ans;
        }
    }
}
