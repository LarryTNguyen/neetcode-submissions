class Solution {
    List<String> storage = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(0,0,n,"");
        return storage;
    }

    public void helper(int openNum, int closeNum, int n, String curr){
        if(closeNum == n){
            storage.add(new String(curr));
            return;
        }
        if(openNum < n){
            helper(openNum + 1, closeNum, n ,curr+"(");
        }
        if(openNum > closeNum){
            helper(openNum, closeNum+1, n, curr+")");
        }
    }
}
