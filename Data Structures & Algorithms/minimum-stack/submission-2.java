class MinStack {
    ArrayList<Integer> regStack;
    ArrayList<Integer> minStack;
    int min;
    
    public MinStack() {
        regStack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        if(regStack.isEmpty()){
            min = val;
        }
        regStack.add(0,val);
        if(min>val){
            minStack.add(0,min);
            minStack.add(0,val);
            min = val;
        }
        else{
            minStack.add(0,val);
            minStack.add(0,min);
        }
    }
    
    public void pop() {
        int temp = regStack.remove(0);
        minStack.remove(0);
        minStack.remove(0);
        if(temp == min && !minStack.isEmpty()){
            min = minStack.get(0);
        }
    }
    
    public int top() {
        return regStack.get(0);
    }
    
    public int getMin() {
        return minStack.get(0);
    }
}
