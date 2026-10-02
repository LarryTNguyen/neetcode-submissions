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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode dummy = new ListNode(-1,answer);
        int carry = 0;
        while(l1!= null || l2!=null){
            int digit1 = 0;
            if(l1 != null){
                digit1 =l1.val;
                l1 = l1.next;
            } 
            int digit2 = 0;
            if(l2 != null){
                digit2 = l2.val;
                l2 = l2.next;
            }
            answer.val = digit1 + digit2 + carry;
            if(answer.val>=10){
                System.out.println("Carry turned to 1");
                answer.val %= 10;
                carry = 1;
                answer.next = new ListNode();
                answer = answer.next;
            }
            else{
                System.out.println("Carry turned to 0");
                carry = 0;
                if(l1!= null || l2 !=null){
                    answer.next = new ListNode();
                    answer = answer.next;
                } 
            }
        }
        if (carry == 1) answer.val = 1;
        return dummy.next;
    }
}
