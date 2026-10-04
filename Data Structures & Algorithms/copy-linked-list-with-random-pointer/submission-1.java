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
        HashMap<Node, Node> copy = new HashMap<>();
        Node dummy = head;
        while(dummy!=null){
            copy.put(dummy, new Node(dummy.val));
            dummy = dummy.next;
        }
        dummy = head;
        while(dummy!=null){
            Node dupe = copy.get(dummy);
            dupe.next = copy.get(dummy.next);
            dupe.random = copy.get(dummy.random);
            dummy = dummy.next;
        }
        return copy.get(head);
    }
}
