class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = 0;
        for(int num: nums){
            currSum = Math.max(currSum, 0);
            currSum += num;
            max = Math.max(currSum, max);
        }
        return max;
    }
}
