import java.util.*;

public class MergeNodesInBetweenZeros2181 {
    public class ListNode {
        int val  ;
        ListNode next ;
        ListNode(){}
        ListNode(int val ) {this.val = val ;}
        ListNode (int val , ListNode next ){
            this.val = val ;
            this.next = next ;
        }
    }

    class Solution {
        public ListNode mergeNodes (ListNode head) {
            ListNode temp = head.next ;
            ListNode nhead = temp ;
            
            while (nhead != null){
                int sum = 0 ;
                while (nhead.val != 0) {
                    sum += nhead.val ;
                    nhead =nhead.next ;
                }

                temp.val = sum ;
                nhead = nhead.next ;

                temp.next = nhead ;
                temp = temp.next ;
            }
            return head.next ;
        }
    }


    // recurssion 
    class RecurSolution {
        public ListNode mergeNodes (ListNode head) {
            head = head.next ;
            if (head == null) return head; 
            ListNode nhead = head ;
            int sum =0 ;
            while(nhead.val != 0) {
                sum += nhead.val ;
                nhead = nhead.next; 
            }
            head.val = sum; 
            head.next  = mergeNodes(nhead);
            return head; 
        } 
    }
}
