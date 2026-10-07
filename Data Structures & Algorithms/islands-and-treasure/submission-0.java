/**
Thought process:
It seems like minimum length is important here so we would want to use BFS as it finds the shortest path

General approach:
scan grid
create queue<int[]>
add coord whenever we hit a 0 coord
pass bfs()


bfs helper:
    takes in (grid, Queue<int[]>)
    returns void

    length = 0;
    queue<int[]> coords
    add (row, col) to coords and visited
    while queue isnt empty:
        take a snapshot of queue size
        loop from 0 to snapshot
            curr coord = queue poll
            grid[curr] = length;
            look at 4 cells and only expand if 1) within bounds and 2) equals INF
                add expanded coord into queue
        length++
    this leaves all unexplored coords as INF so those that are unreachable will remain INF 
*/
class Solution {
    int inf =  2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> treasure = new ArrayDeque<>();
        for(int i = 0; i<grid.length; i++){
            for(int k = 0; k<grid[i].length; k++){
                if(grid[i][k] == 0){
                    treasure.offer(new int[]{i,k});
                }
            }
        }
        bfs(grid, treasure);
    }

    public void bfs(int[][]grid, Queue<int[]> treasure){
        int length = 0;
        while(!treasure.isEmpty()){
            int queueSize = treasure.size();
            for(int j = 0; j<queueSize; j++){
                int[]curr = treasure.poll();
                int row = curr[0];
                int col = curr[1];
                if(row +1 != grid.length && grid[row+1][col] == inf){
                    grid[row+1][col] = length+1;
                    treasure.offer(new int[]{row+1, col});
                }
                if(row -1 != -1 && grid[row-1][col] == inf){
                    grid[row-1][col] = length+1;
                    treasure.offer(new int[]{row-1, col});
                }
                if(col +1 != grid[0].length && grid[row][col+1] == inf){
                    grid[row][col+1] = length+1;
                    treasure.offer(new int[]{row, col+1});
                }
                if(col -1 != -1 && grid[row][col-1] == inf){
                    grid[row][col-1] = length+1;
                    treasure.offer(new int[]{row, col-1});
                }
            }
            length++;
        }
    }
}
