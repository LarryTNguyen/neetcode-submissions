class Solution {
    int rowMax, colMax;
    public boolean exist(char[][] board, String word) {
        rowMax = board.length-1;
        colMax = board[0].length-1;
        for(int i = 0; i<board.length; i++){
            for(int k = 0; k<board[i].length; k++){
                if(dfs(0, i, k, word, board, new HashSet<Pair<Integer,Integer>>())) return true;
            }
        }
        return false;
    }

    public boolean dfs(int index, int rowNum, int colNum, String word, char[][]board, Set<Pair<Integer,Integer>> visited){
        if(rowNum > rowMax || colNum > colMax || rowNum <=-1 || colNum <=-1) return false;
        if(board[rowNum][colNum] == word.charAt(index)){
            if(visited.add(new Pair<>(rowNum,colNum))){
                if(index == word.length() -1) return true;
                boolean found= dfs(index+1, rowNum+1, colNum, word, board, visited)||
                dfs(index+1, rowNum-1, colNum, word, board, visited)||
                dfs(index+1, rowNum, colNum+1, word, board, visited)||
                dfs(index+1, rowNum, colNum-1, word, board, visited);
                visited.remove(new Pair<>(rowNum, colNum));
                return found;
            }
            return false;
        }
        return false;
    }
}
