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
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode normal = head;
        while(fast!=null && fast.next !=null){
            fast = fast.next.next;
            normal = normal.next;
            if(fast == normal) return true;
        }
        return false;
    }
}
