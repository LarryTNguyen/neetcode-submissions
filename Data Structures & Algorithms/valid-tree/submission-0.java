/**
Initial thoughts: 
what makes up a valid tree? No cycles AND every child node has a parent node. 
something to note, edges are undirected so it is fine if they kinda just point back and forth with each other

I could do what i have been doing earlier which was checking for cycles with dfs
how would i check for lone nodes?
*/


class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adjList.add(i, new ArrayList<>());
        }
        for(int[] e: edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];

        if(!dfs(0, adjList, visited, -1)) return false;
        
        for(boolean val:visited){
            if(!val) return false;
        }
        return true;
    }

    public boolean dfs(int node, List<List<Integer>> adjList, boolean [] visited, int parent){
        visited[node] = true;
        for(int neigh:adjList.get(node)){
            if(neigh == parent) continue;
            if(visited[neigh]) return false;
            if(!dfs(neigh, adjList, visited, node)) return false;
        }
        return true;
    }
}
