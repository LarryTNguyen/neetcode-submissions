class Solution {
    List<String> all = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper("",0,0,n);
        return all;
    }

    public void helper(String current, int openCount, int closeCount, int n){
        if(closeCount == n && openCount == n){
            all.add(current);
            return;
        }
        
        if(openCount < n){
            helper(current+"(", openCount + 1, closeCount, n);
        }
        if(closeCount < openCount){
            helper(current+")", openCount, closeCount + 1, n);
        }
    }


}
