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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode secondHalf = slow.next;
        slow.next = null;
        while(secondHalf!=null){
            ListNode temp = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = temp;
        }
        ListNode curr = head;
        while(prev!=null){
            ListNode temp = prev.next;
            ListNode placeHolder = curr.next;
            curr.next = prev;
            curr.next.next = placeHolder;
            prev = temp;
            curr = curr.next.next;
        }
    }
}
