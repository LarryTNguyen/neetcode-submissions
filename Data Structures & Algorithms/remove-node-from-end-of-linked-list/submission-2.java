/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while(n>0){
            fast = fast.next;
            n--;
        }
        ListNode slow = new ListNode(-1,head);
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        if(slow.next == head) head = head.next;
        else slow.next= slow.next.next;
        return head;
    }
}
