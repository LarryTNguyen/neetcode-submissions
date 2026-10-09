/**
could try to reason it as "at i, are there any partitions that make the subsets equal to each other"
what would a particular index being true would mean though?
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum+= num;
        }
        if(sum%2 == 1) return false;
        int target = sum/2;
        boolean [] sumList = new boolean[target+1];
        sumList[0] = true;
        for(int i = nums.length-1; i>=0; i--){
            for(int j = target; j >= nums[i]; j--){
                if(sumList[j - nums[i]]){
                    sumList[j] = true;
                }
            }
        }
        return sumList[target];
    }
}
