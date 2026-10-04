class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for(String s:tokens){
            if("+-*/".contains(s)){
                int num1 = numbers.pop();
                int num2 = numbers.pop();
                switch(s){
                    case "+":
                        numbers.push(num2+num1);
                        break;
                    case "-":
                        numbers.push(num2-num1);
                        break;
                    case "*":
                        numbers.push(num2*num1);
                        break;
                    default:
                        numbers.push(num2/num1);
                        break;
                }
            }
            else numbers.push(Integer.parseInt(s));
        }
        return numbers.pop();
    }
}
