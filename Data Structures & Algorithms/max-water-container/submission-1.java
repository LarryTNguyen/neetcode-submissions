class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length-1;
        while(left!=right){
            int maxHeight = Math.min(heights[left],heights[right]); 
            int currArea = maxHeight * (right - left);
            if(currArea>maxArea) maxArea = currArea;
            if (heights[left] >heights[right]) right--;
            else left++;
        }
        return maxArea;
    }
}
