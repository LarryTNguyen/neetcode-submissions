class Solution {
    public int countComponents(int n, int[][] edges) {
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
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                dfs(i,adjList, visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(int index, List<List<Integer>> adjList, boolean[] visited){
        visited[index]= true;
        for(int neighbor: adjList.get(index)){
            if(!visited[neighbor]){
                dfs(neighbor, adjList, visited);
            }
        }
    }
}
