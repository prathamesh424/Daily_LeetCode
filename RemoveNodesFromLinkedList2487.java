public class RemoveNodesFromLinkedList2487 {

    /*
     * You are given the head of a linked list.
     * 
     * Remove every node which has a node with a greater value anywhere to the right side of it.
     * 
     * Return the head of the modified linked list.
     */

  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode removeNodes(ListNode head) {
        head = revList(head);

        int max = 0 ;
        ListNode prev = null ;
        ListNode curr = head ;

        while (curr != null) {
            max = Math.max(max , curr.val);

            if (curr.val < max){
                prev.next = curr.next ;
                ListNode del = curr ;
                curr = curr.next   ;
                del.next = null ;
            }
            else {
                prev = curr ;
                curr = curr.next;
            }
        }
        return revList(head);
    }

    private ListNode revList (ListNode head){
        ListNode prev = null ;
        ListNode curr = head  ;
        ListNode nxt = null ;
        
        while (curr != null) {
            nxt = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = nxt ;
        }
        return prev ;
    }
}
}
