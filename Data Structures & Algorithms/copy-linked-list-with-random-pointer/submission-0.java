/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> count = new HashMap<>();
        Node curr = head;
        while(curr != null) {
            count.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while(curr!=null){
            Node copy = count.get(curr);
            copy.next = count.get(curr.next);
            copy.random = count.get(curr.random);
            curr = curr.next;
        }
        return count.get(head);
    }
}
