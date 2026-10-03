class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length-1] = 1;
        for(int i = 1; i<nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
            suffix[nums.length-1-i] = suffix[nums.length-i] * nums[nums.length-i];
        }
        int[] answer = new int[nums.length];
        for(int i = 0; i<answer.length; i++){
            answer[i] = prefix[i] * suffix[i];
        }
        return answer;
    }
}  
