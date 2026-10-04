class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> indices = new Stack<>();
        for(int i = 0; i <temperatures.length; i++){
            if(indices.isEmpty() || temperatures[i] < temperatures[indices.peek()]){
                indices.push(i);
            }
            else{
                while(!indices.isEmpty() && temperatures[i] > temperatures[indices.peek()]){
                    int index = indices.pop();
                    answer[index] = i - index;
                }
                indices.push(i);
            }
        }
        while(!indices.isEmpty()){
            answer[indices.pop()] = 0;
        }
        return answer;
    }
}
