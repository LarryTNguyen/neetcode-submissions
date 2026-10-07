/**
Initial thoughts:
Brute force would be going through each value and seeing if there is a way where each coord gets to the other side 
perhaps we can just take a look at only the edges
keep a hashset of visited to remember where we have gone
top right and bottom left are an auto guarantee

bfs per edge?

Initial solution:
in main fn: go around each ocean border of the grid, performing bfs on each cell.
Grab all pacific cells --> perform bfs on each
Grab all atlantic cells --> perform bfs on each 
have a boolean[][] visited
should i pass what side the cell is trying to get to?
pass: heights, visited, queue?

bfs(heights, visited, queue){
    while queue isnt empty
        curr = queue poll
        row num = curr[0]
        col num = curr[1]
        for each neighbor if 1) in bounds, 2) not visited in the bool[][] and 3) neighbor height >= curr height
            add into visited
            add neighbor to queue
}
*/
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean [][] pVisited = new boolean[heights.length][heights[0].length];
        Queue<int[]> pCoords = new ArrayDeque<>();
        boolean [][] aVisited = new boolean[heights.length][heights[0].length];
        Queue<int[]> aCoords = new ArrayDeque<>();
        List<List<Integer>> answer = new ArrayList<>();
        //Pacific border
        for(int i = 0; i< heights.length; i++){
            pCoords.offer(new int[]{i,0});
            pVisited[i][0] = true;
        }
        for(int k = 1; k <heights[0].length; k++){
            pCoords.offer(new int []{0,k});
            pVisited[0][k] = true;
        }
        bfs(heights, pVisited, pCoords);

        //Atlantic Border
        for(int i = 0; i<heights.length; i++){
            aCoords.offer(new int[]{i, heights[0].length-1});
            aVisited[i][heights[0].length-1] = true;
        }
        for(int k = 0; k <heights[0].length-1; k++){
            aCoords.offer(new int []{heights.length-1,k});
            aVisited[heights.length-1][k] = true;
        }
        bfs(heights, aVisited, aCoords);
        for(int i = 0; i<heights.length; i++){
            for(int k = 0; k<heights[i].length; k++){
                if(pVisited[i][k] && aVisited[i][k]){
                    answer.add(Arrays.asList(i,k));
                }
            }
        }
        return answer;
    }

    public void bfs(int [][]heights, boolean[][] visited, Queue<int[]> coords){
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!coords.isEmpty()){
            int[] curr = coords.poll();
            int rowNum = curr[0];
            int colNum = curr[1];
            for(int[] dir: directions){
                if(rowNum + dir[0] >=0 && rowNum+dir[0] < heights.length){
                    if(colNum + dir[1] >=0 && colNum+dir[1] < heights[0].length){
                        if(visited[rowNum+dir[0]][colNum+dir[1]] == false && heights[rowNum+dir[0]][colNum+dir[1]] >= heights[rowNum][colNum]){
                            coords.offer(new int[]{rowNum+dir[0],colNum+dir[1]});
                            visited[rowNum+dir[0]][colNum+dir[1]] = true;
                        }
                    }
                }
            }
        }
    }
}
