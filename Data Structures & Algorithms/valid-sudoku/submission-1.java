class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, List<Character>> rowCount = new HashMap<>();
        HashMap<Integer, List<Character>> colCount = new HashMap<>();
        HashMap<Integer, List<Character>> gridCount = new HashMap<>();
        for(int i = 0; i < board.length; i++){
            rowCount.put(i, new ArrayList<Character>());
            for(int k = 0; k < board[i].length; k++){
                int gridNum = i/3 * 3 + k/3;
                char selected = board[i][k];
                if(selected == '.') continue;
                System.out.println("Row #: " + i + " Col #: " + k + " Grid #: " + gridNum);
                colCount.putIfAbsent(k, new ArrayList<Character>());
                gridCount.putIfAbsent(gridNum, new ArrayList<Character>());
                if(!rowCount.get(i).contains(selected) && !colCount.get(k).contains(selected) && !gridCount.get(gridNum).contains(selected)){
                    rowCount.get(i).add(selected);
                    colCount.get(k).add(selected);
                    gridCount.get(gridNum).add(selected);
                }
                else{return false;}
            }
        }
        return true;
    }
}
