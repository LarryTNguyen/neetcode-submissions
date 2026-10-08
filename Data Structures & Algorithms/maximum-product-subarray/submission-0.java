/**
Initial thoughts: 
Thinking about having a dp array where each index is the max of either it or it * the previous product
note that it has to be within the array itself

base case df[0] = nums[0];

test cases
2 4 -3 5 --> 8 by only using 2 and 4


-3, 0, -2 --> 0 because can't do -3 * -2 without the 0

-3, 1, -2 --> 6 since -3 * 1 * -2 will be 6
this test case breaks my original idea
*/
class Solution {
    public int maxProduct(int[] nums) {
        int answer = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int prevMax = currMax;
            int prevMin = currMin;

            currMax = Math.max(nums[i],
                    Math.max(nums[i] * prevMax,
                            nums[i] * prevMin));

            currMin = Math.min(nums[i],
                    Math.min(nums[i] * prevMax,
                            nums[i] * prevMin));

            answer = Math.max(answer, currMax);
        }
        return answer;
    }
}
