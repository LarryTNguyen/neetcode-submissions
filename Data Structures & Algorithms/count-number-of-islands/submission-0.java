class Solution {
    /**
    Intuition: would have to use DFS in this scenario:

    Algorithm: 
    in nums, go through all cells:
        if cell is != 1, skip
        otherwise: call on helper dfs
        total+=1

        return total
    
    helper function dfs(rowNum, colNum, grid)
    in helper:
        base case: 
            if rowNum or colNum out of bounds (either through ==-1 or ==grid.length)
            if grid[rowNum,colNum] != 1; return
        set current coord to 2 
        4x recursive call in each direction
        
    

    */
    public int numIslands(char[][] grid) {
        int total = 0;
        for(int i = 0; i<grid.length; i++){
            for(int k =0; k<grid[i].length; k++){
                if(grid[i][k] == '1'){
                    dfs(i,k,grid);
                    total++;
                }
            }
        }
        return total;
    }

    public void dfs(int rowNum, int colNum, char[][]grid){
        if(rowNum == grid.length || rowNum == -1||colNum == grid[rowNum].length || colNum == -1||      grid[rowNum][colNum] != '1') return;

        grid[rowNum][colNum] = '2';
        dfs(rowNum+1,colNum,grid);
        dfs(rowNum-1,colNum,grid);
        dfs(rowNum,colNum+1,grid);
        dfs(rowNum,colNum-1,grid);
    }
}
