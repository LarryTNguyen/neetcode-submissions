class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> heightStorage = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            if(heightStorage.isEmpty() || heights[i] > heightStorage.peek()[0]){
                heightStorage.push(new int[]{heights[i], i});
            }
            else{
                int lastWidth = i;
                while(!heightStorage.isEmpty() && heightStorage.peek()[0] >= heights[i]){
                    int[] heightWidth = heightStorage.pop();
                    int currArea = heightWidth[0] * (i-heightWidth[1]);
                    maxArea = Math.max(maxArea, currArea);
                    lastWidth = heightWidth[1];
                }
                heightStorage.push(new int[]{heights[i], lastWidth});
            }
        }
        while(!heightStorage.isEmpty()){
            int[] heightWidth = heightStorage.pop();
            int currArea = heightWidth[0] * (heights.length-heightWidth[1]);
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}
