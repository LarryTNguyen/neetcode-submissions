class Solution {
    public int trap(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length-1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        while(left<=right){
            if(leftHeight > rightHeight){
                if(height[right] <= rightHeight){
                    maxWater += rightHeight - height[right];
                }
                else{
                    rightHeight = height[right];
                }
                right--;
            }
            else{
                if(height[left] <= leftHeight){
                    maxWater += leftHeight - height[left];
                }
                else{
                    leftHeight = height[left];
                }
                left++;
            }
        }
        return maxWater;
    }
}
