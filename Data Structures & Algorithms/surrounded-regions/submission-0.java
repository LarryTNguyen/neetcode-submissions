/**
Initial thoughts:
Sameish proess as the pacific/atlantic. Scan the edges until we find an O. From there, we can perform BFS until we covered all adjacent O's. Alongside it, we have a boolean array visited that keeps track of what we have traversed so far. after going through all of the grid, we do another scan of board, replacing all surrounded O's into X's (those will be marked false in the boolean[][] while the ones that aren't surrounded will be set to true) 

*/

class Solution {
    public void solve(char[][] board) {
        boolean[][] found = new boolean[board.length][board[0].length];
        Queue<int[]> outside = new ArrayDeque<>();
        for(int i = 0; i<board[0].length; i++){
            if(board[0][i] == 'O'){
                found[0][i] = true;
                outside.offer(new int[] {0,i});
            } 
        }
        for(int i = 0; i<board[0].length; i++){
            if(board[board.length-1][i] == 'O'){
                found[board.length-1][i] = true;
                outside.offer(new int[] {board.length-1,i});
            } 
        }
        for(int i = 1; i<board.length-1; i++){
            if(board[i][board[0].length-1] == 'O'){
                found[i][board[0].length-1] = true;
                outside.offer(new int[] {i,board[0].length-1});
            } 
        }
        for(int i = 1; i<board.length-1; i++){
            if(board[i][0] == 'O'){
                found[i][0] = true;
                outside.offer(new int[] {i,0});
            } 
        }
        bfs(found, board, outside);
        for(int i = 0; i<board.length; i++){
            for(int k = 0; k<board[i].length; k++){
                if(board[i][k] == 'O' && found[i][k] == false){
                    board[i][k] = 'X';
                }
            }
        }
    }

    public void bfs(boolean[][] found, char[][]board, Queue<int[]> outside){
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(outside.isEmpty() == false){
            int[] curr = outside.poll();
            int rowNum = curr[0];
            int colNum = curr[1];
            for(int[] dir: directions){
                if(rowNum+dir[0]>= 0 && rowNum+dir[0] <board.length){
                    if(colNum+dir[1] >=0 && colNum +dir[1] < board[rowNum].length){
                        if(found[rowNum+dir[0]][colNum+dir[1]] == false && board[rowNum+dir[0]][colNum+dir[1]] == 'O'){
                            outside.offer(new int[]{rowNum+dir[0],colNum+dir[1]});
                            found[rowNum+dir[0]][colNum+dir[1]] = true;
                        }
                    }
                }
            }
        }
    }

}
