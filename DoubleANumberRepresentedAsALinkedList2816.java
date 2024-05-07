import java.util.Stack;

public class DoubleANumberRepresentedAsALinkedList2816 {
    /*
     * You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
     * Return the head of the linked list after doubling it.
     */
    

 //* Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

class Solution {

    // using stack :- 21ms

    public ListNode doubleIt(ListNode head) {
        Stack<Integer> st = new Stack<>() ;

        while (head != null) {
            st.push(head.val) ;
            head = head.next ;
        }
        int num = 0 ;
        ListNode nList = null;

        while (!st.isEmpty() || num != 0) {
            nList = new ListNode(0 , nList) ;
            if(!st.isEmpty()){
                num  += st.pop() *2; 
            }

            nList.val = num % 10;
            num /= 10;
        }

        return nList ;
    }


    // using pointer method : - 2ms 
    
    public ListNode OptimaldoubleIt(ListNode head) {
        if (head.val > 4) head = new ListNode(0 , head) ;
        for (ListNode node = head ; node != null ; node = node.next){
            node.val = (node.val *2) % 10 ;
            if (node.next != null && node.next.val > 4) {
                node.val++;
            } 
        }
        return head; 
    }
}
    
}
