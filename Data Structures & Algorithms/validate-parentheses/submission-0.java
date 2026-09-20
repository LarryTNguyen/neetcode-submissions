class Solution {
    public boolean isValid(String s) {
        Stack<Character> count = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                count.push(s.charAt(i));
            }
            else{
                if(count.size() == 0) return false;
                char top = count.pop();
                char current = s.charAt(i);
                if(current == ')'){
                    if(top != '(') return false;
                }
                else if(current == ']'){
                    if(top != '[') return false;
                }
                else{
                    if(top != '{') return false;
                }
            }
        }
        if(count.size() != 0) return false;
        return true;
    }
}
