class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for(String token:tokens){
            if(isNumeric(token)){
                nums.push(Integer.parseInt(token));
            }
            else if(token.equals("+")){
                int temp = nums.pop() + nums.pop();
                nums.push(temp);
            }
            else if(token.equals("*")){
                int temp = nums.pop() * nums.pop();
                nums.push(temp);
            }
            else if(token.equals("-")){
                int secondNum = nums.pop();
                int temp = nums.pop() - secondNum;
                nums.push(temp);
            }
            else{
                int secondNum = nums.pop();
                int temp = nums.pop() / secondNum;
                nums.push(temp);
            }
        }
        return nums.pop();
    }
    public static boolean isNumeric(String str) {
    try {
        Integer.parseInt(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}   
}
