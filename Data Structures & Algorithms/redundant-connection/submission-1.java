/**
test case
[[1,2],[1,3],[3,4],[2,4]]
[2,4]


Pseudocode
make empty adjList
from 0 to edge length
for each edge in edges
    perform dfs(start, target, new boolean visited);
    if dfs --> return the edge
    if not dfs,
    adj[i].add j
    adj[j].add i 

*/
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<=edges.length; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] e: edges){
            if(dfs(e[0], e[1], adjList, new boolean[edges.length+1])) return new int[]{e[0],e[1]};
            else{
                adjList.get(e[0]).add(e[1]);
                adjList.get(e[1]).add(e[0]);
            }
        }
        return new int[] {0,0};
    }

    public boolean dfs(int start, int end,List<List<Integer>>adjList, boolean[] visited){
        if(start == end) return true;
        visited[start]= true;
        for(int neighbor: adjList.get(start)){
            if(!visited[neighbor]){
                if(dfs(neighbor, end, adjList, visited)) return true;
            }
        }
        return false;
    }
}
