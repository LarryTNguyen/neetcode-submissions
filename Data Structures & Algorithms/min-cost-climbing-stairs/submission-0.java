class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2) return Math.min(cost[0],cost[1]);
        int[] answer = new int[cost.length];
        answer[0] = cost[0];
        answer[1] = cost[1];
        for(int i = 2; i<answer.length; i++){
            answer[i] = cost[i] + Math.min(answer[i-1], answer[i-2]);
        }
        return Math.min(answer[answer.length-1], answer[answer.length-2]);
    }
}
