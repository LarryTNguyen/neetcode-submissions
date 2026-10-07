/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
/**
Solution thought process:
We could do a similar approach to a the copy random pointer question, but this time,
we implement an adjacent list and use BFS to iterate through the graph 

Queue<Node> to perform BFS
HashMap<Node, Node> visited to keep track of what we have already visited && make a copy
Start at the parameter node
add node to queue and visited
while queue isnt empty
        node curr = queue poll(index)
        for each neighbor in curr neighbors
            if visited does not have them:
                visited.put( neighbor, neighbor copy)
                queue . add neighbor
            visited.get(curr).neighbors.add(visited.get(neighbor))
return visited.get(node)            

*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Queue<Node> queue = new ArrayDeque<>();
        HashMap<Node, Node> visited = new HashMap<>();
        queue.offer(node);
        visited.put(node, new Node(node.val));
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for(Node neighbor : curr.neighbors){
                if(visited.get(neighbor) == null){
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}