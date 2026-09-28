class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> heightIndex = new Stack<>();
        int area = 0;
        heightIndex.push(new int[]{heights[0], 0});
        for(int i = 1; i < heights.length; i++){
            int start = i;
            while(!heightIndex.isEmpty() && heightIndex.peek()[0] >heights[i]){
                start = heightIndex.peek()[1];
                int tempArea = heightIndex.peek()[0] * (i-heightIndex.pop()[1]);
                if(tempArea > area){
                    area = tempArea;
                }
            }
            if(heightIndex.isEmpty()) heightIndex.push(new int[]{heights[i],start});
            else heightIndex.push(new int[]{heights[i],start});
        }
        while(!heightIndex.isEmpty()){
            int[] stat = heightIndex.pop();
            int tempArea = stat[0] * (heights.length-stat[1]);
            if(tempArea > area){
                area = tempArea;
            }
        }
        return area;
    }
}
