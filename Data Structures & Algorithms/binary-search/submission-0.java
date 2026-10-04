class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int median = right/2;
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        while(left != median && right!=median){
            if(nums[median] == target) return median;
            if(target>nums[median]){
               left = median; 
            }
            else{
                right = median;
            }
            median = (right + left)/2;
        }
        return -1;
    }
}
