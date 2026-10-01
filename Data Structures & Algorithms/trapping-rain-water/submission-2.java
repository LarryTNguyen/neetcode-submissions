class Solution {
    public int trap(int[] height) {
        int result = 0;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int leftPtr = 0;
        int rightPtr = height.length-1;
        while(leftPtr<=rightPtr){
            if(leftMax<rightMax){
                if(leftMax > height[leftPtr]) result += leftMax - height[leftPtr];
                else leftMax = height[leftPtr];
                leftPtr++;
            }
            else{
               if(rightMax > height[rightPtr]) result += rightMax - height[rightPtr];
               else rightMax = height[rightPtr];
                rightPtr--; 
            }
            // System.out.println("Left pointer at: " + leftPtr);
            // System.out.println("Right pointer at: " + rightPtr);
            // System.out.println("Left max at: " + leftMax);
            // System.out.println("Right max at: " + rightMax);
            // System.out.println("Result at: " + result);
        }
 
        return result;
    }
}
