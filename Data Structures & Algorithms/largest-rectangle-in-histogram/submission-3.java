class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> possibleWidths = new Stack<>();
        for(int i = 0; i<heights.length; i++){
            if(possibleWidths.isEmpty()){
                possibleWidths.push(new int[]{heights[i],i});
            }
            else{
                int newWidth = i;
                while(!possibleWidths.isEmpty() && heights[i] < possibleWidths.peek()[0]){
                    int[] poppedBar = possibleWidths.pop();
                    int currArea = poppedBar[0] * (i-poppedBar[1]);
                    maxArea = Math.max(maxArea, currArea);
                    newWidth = poppedBar[1];
                }
                if(possibleWidths.isEmpty() || possibleWidths.peek()[0] < heights[i]){
                    possibleWidths.push(new int[]{heights[i],newWidth});
                }
            }
        }
        while(!possibleWidths.isEmpty()){
            int[] poppedBar = possibleWidths.pop();
            maxArea = Math.max(maxArea, poppedBar[0]*(heights.length - poppedBar[1]));
        }
        return maxArea;
    }
}
