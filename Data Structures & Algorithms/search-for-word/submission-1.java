class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i < board.length; i++){
            for(int k = 0; k< board[i].length; k++){
                if(dfs(i,k,0,board,word, new HashSet<>())) return true;
            }
        }
        return false;
    }

    public boolean dfs(int row, int col, int index, char[][] board, String word, Set<Pair<Integer, Integer>> visited){
        if(!validCoord(row, col, board)) return false;
        if(board[row][col] == word.charAt(index)){
            if(visited.add(new Pair<>(row,col))){
                if(index == word.length()-1) return true;
                boolean found = dfs(row+1, col, index+1, board, word, visited) ||
                    dfs(row-1, col, index+1, board, word, visited) ||
                    dfs(row, col+1, index+1, board, word, visited) ||
                    dfs(row, col-1, index+1, board, word, visited);
                visited.remove(new Pair<>(row,col));
                return found;
            }
            return false;
        }
        return false;
    }

    public boolean validCoord(int row, int col, char[][] board){
        if(row >=0 && row<board.length){
            if(col >= 0 && col<board[row].length){
                return true;
            }
        }
        return false;
    }
}
