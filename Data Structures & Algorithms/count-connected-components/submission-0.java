/**
Initial thoughts: we could do something similar to what we have done before where we would want to get all of the edges then iterate through them. Through the dfs, we could "remove" some of the edges as we go along and then + 1 at the end?
Maybe we would have to take into account cycles as well but i think in our approach of removing edges from the actual list, it gets rid of them
*/

class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adjList.add(i, new ArrayList<>());
        }
        for(int[] e: edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];

        for(int k = 0; k<n; k++){
            if(!visited[k]){
                dfs(k, adjList, visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(int node, List<List<Integer>> adjList, boolean[] visited){
        visited[node] = true;

        for(int neighbor : adjList.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, adjList, visited);
            }
        }
    }
}
