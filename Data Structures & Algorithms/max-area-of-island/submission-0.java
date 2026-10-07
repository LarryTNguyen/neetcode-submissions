class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i<grid.length; i++){
            for(int k = 0; k < grid[i].length; k++){
                if(grid[i][k] == 1){
                    int area = dfs(i,k,grid);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    public int dfs(int rowNum, int colNum, int[][]grid){
        if(rowNum <0||rowNum == grid.length || colNum<0 || colNum == grid[rowNum].length || grid[rowNum][colNum] != 1) return 0;
        int count = 0;
        grid[rowNum][colNum] = 2;

        count+=dfs(rowNum+1, colNum, grid);
        count+=dfs(rowNum-1, colNum, grid);
        count+=dfs(rowNum, colNum+1, grid);
        count+=dfs(rowNum, colNum-1, grid);

        return count+1;
    }
}
