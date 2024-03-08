public class middleOfLinkedList876 {

 /*     Day 148 : - 
        Using Simple Logic ....
        Date :-   7/3/2024 
    
  */

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

    public ListNode middleNode(ListNode head) {
        ListNode f = head ;
        ListNode s = head ;
        if (head == null && head.next == null ) return  head ;
        while (s != null  && s.next != null  ){
            f = f.next ;
            s =  s.next.next ;
        } 
        return f;
    }
}
