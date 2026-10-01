class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length -1;
        int max = Math.min(heights[left],heights[right]) * right;
        while (left < right){
            if(heights[left] < heights[right]){
                int leftPtr = left + 1;
                while(leftPtr<right && heights[left] >= heights[leftPtr]){
                    leftPtr++;
                }
                left = leftPtr;
                max = Math.max(max, Math.min(heights[left],heights[right]) * (right-                left));
            }
            else{
                int rightPtr = right -1;
                while(left<rightPtr && heights[right] >= heights[rightPtr]){
                    rightPtr--;
                }
                right = rightPtr;
                max = Math.max(max, Math.min(heights[left],heights[right]) * (right-                left));
            }
        }
        return max;
    }
}
