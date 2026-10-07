/**
Initial thoughts:
Can there be multiple rotten fruits in the beginning?
Is it possible to have no rotten fruits at all?

General approach:
We'd want to start at each rotten fruit and do a BFS from each
have a fruit counter that will decrement per fruit rotten
main fn: count all fresh fruit and store coords of bad fruit in a queue
pass # of fresh fruit, queue of coords, grid

bfs helper
    have a min elapsed var that will increment after every scan of Queue

    typical BFS method per rotten fruit:
        only mark 2 and add to queue if valid boundary + 1
        decrement fruit counter
    increment min elapsed after snapshot of queue passed

    if fruit count> 0; return -1
    else return min elapsed
    
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> coords = new ArrayDeque<>();
        int freshCount = 0;
        for(int i = 0; i<grid.length; i++){
            for(int k = 0; k < grid[i].length; k++){
                if(grid[i][k] == 1) freshCount++;
                if(grid[i][k] == 2) coords.offer(new int[]{i,k});
            }
        }
        return bfs(freshCount, coords, grid);
    }

    public int bfs(int freshCount, Queue<int[]> coords, int[][]grid){
        int minElapsed = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!coords.isEmpty()){
            int coordsSize = coords.size();
            for(int i = 0; i < coordsSize; i++){
                int[] curr = coords.poll();
                int rowNum = curr[0];
                int colNum = curr[1];
                for(int[] choice:directions){
                    if(rowNum+choice[0] != -1 && rowNum+choice[0] != grid.length && colNum+choice[1] !=-1 && colNum+choice[1] != grid[0].length && grid[rowNum+choice[0]][colNum+choice[1]]==1){
                        grid[rowNum+choice[0]][colNum+choice[1]] = 2;
                        freshCount--;
                        coords.offer(new int[]{rowNum+choice[0], colNum+choice[1]});
                    }
                }
            }
            if(!coords.isEmpty()) minElapsed++;
        }
        if (freshCount > 0) return -1;
        else return minElapsed;
    }
}
