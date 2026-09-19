class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rowCount = new HashMap<>();
        HashMap<Integer, HashSet<Character>> colCount = new HashMap<>();
        HashMap<Integer, HashSet<Character>> gridCount = new HashMap<>();
        for(int i =0; i<board.length; i++){
            rowCount.putIfAbsent(i, new HashSet<Character>());
            for(int k = 0; k < board[i].length; k++){
                if(board[i][k]!='.'){
                    int gridRow = i / 3;
                    int gridCol = k / 3;
                    int gridNum = gridRow * 3 + gridCol;
                    colCount.putIfAbsent(k, new HashSet<Character>());
                    gridCount.putIfAbsent(gridNum, new HashSet<Character>());
                    if(!rowCount.get(i).add(board[i][k])){
                        return false;
                    }
                    if(!colCount.get(k).add(board[i][k])){
                        return false;
                    }
                    if(!gridCount.get(gridNum).add(board[i][k])){
                        return false;
                    }
                }    
            }
        }
        return true;
    }
}
