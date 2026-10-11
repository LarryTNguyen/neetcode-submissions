class Solution {
    List<List<String>> all = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(0, 1, s, new ArrayList<>());
        return all;
    }

    public void helper(int start, int end, String s, List<String> curr){
        if(start == s.length()){
            all.add(new ArrayList<>(curr));
            return;
        }
        if(end>s.length()) return;
        if(isPalindrome(start, end-1, s)){
            curr.add(s.substring(start, end));
            helper(end, end+1, s, curr);
            curr.removeLast();
            helper(start, end+1, s, curr);
        }
        else helper(start, end+1, s, curr);
    }

    public boolean isPalindrome(int start, int end, String s){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}
