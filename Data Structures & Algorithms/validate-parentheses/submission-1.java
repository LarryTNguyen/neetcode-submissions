class Solution {
    public boolean isValid(String s) {
        Stack<Character> storage = new Stack<>();
        for(char c:s.toCharArray()){
            switch(c){
                case ')':
                    if(storage.isEmpty()||storage.pop() != '(') return false;
                    break;
                case '}':
                    if(storage.isEmpty() || storage.pop() != '{') return false;
                    break;
                case ']':
                    if(storage.isEmpty()||storage.pop() != '[') return false;
                    break;
                default:
                    storage.push(c);
            }
        }
        return storage.isEmpty();
    }
}
