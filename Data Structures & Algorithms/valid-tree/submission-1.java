class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int node1 = e[0];
            int node2 = e[1];
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
        if(!dfs(0, adjList, visited, -1)) return false;

        for(boolean valid:visited){
            if(!valid) return false;
        }
        return true;
    }

    public boolean dfs(int index, List<List<Integer>> adjList, boolean[] visited, int parent){
        visited[index] = true;
        for(int neigh: adjList.get(index)){
            if(neigh == parent) continue;
            if(visited[neigh]) return false;
            if(!dfs(neigh, adjList, visited, index)) return false;
        }
        return true;
    }
}
