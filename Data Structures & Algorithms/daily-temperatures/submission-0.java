class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        HashMap<Integer, Integer> tempStorage = new HashMap<>();
        Stack<Integer> indices = new Stack<>();
        int[] answer = new int[temperatures.length];
        for(int i = 0; i<temperatures.length; i++){
            tempStorage.put(i, temperatures[i]);
            while(!indices.isEmpty() && tempStorage.get(indices.peek()) < temperatures[i]){
                answer[indices.peek()] = i - indices.pop();
            }
            indices.push(i);
        }
        return answer;
    }
}
