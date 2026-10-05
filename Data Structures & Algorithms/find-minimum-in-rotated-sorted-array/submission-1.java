class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int med = (right+left)/2;
                if(nums[med] > nums[right]) left = med+1;
                else right = med;
        }
        return nums[left];
    }
}
