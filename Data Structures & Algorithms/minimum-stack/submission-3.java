class MinStack {
    Stack<Integer> reg;
    Stack<Integer> min;
    public MinStack() {
        reg = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        reg.push(val);
        if(min.isEmpty()){
            min.push(val);
            min.push(val);
        }
        else if(val< min.peek()){
            min.push(min.peek());
            min.push(val);
        }
        else{
            int temp = min.peek();
            min.push(val);
            min.push(temp);
        }
    }
    
    public void pop() {
        reg.pop();
        min.pop();
        min.pop();
    }
    
    public int top() {
        return reg.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
