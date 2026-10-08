/**
Very similar to the house robber question from last question but now there is a twist

At the very end, we have to figure out the max between the prev house (aka skip the last house) AND [last house + two houses back]

bool firstHouse = false;
max of dp[i-2] + nums[i] - nums[0] OR dp [i-1] + nums[i] -nums[i-1] but that isnt always going to be the case
2, 9, 8, 3, 6
2, 9, 10, 12, 

fH = true
2, 1, 8, 3, 6
2, 1, 10, 10, 14
max of nums[i] + dp[i-1] - nums[i-1] OR nums[i] + dp[i-2] - nums[0]
how can we tell if the last house's max also used the first house
perhaps a boolean could be set to true if house index 2 used amt of 2 and 1
it would keep flipping true and false; becomes false when
if true: then we would do dp[end] + dp[end-2] - dp[start] vs 

2, 9, 8, 3, 6

9, 8, 

a2 =
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int[] answer1 = new int[nums.length-1];
        int[] answer2 = new int[nums.length-1];
        answer1[0] = nums[0];
        answer1[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length-1; i++){
            // dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1])
            answer1[i] = Math.max(answer1[i-2] + nums[i], answer1[i-1]);
        }
        answer2[0] = nums[1];
        answer2[1] = Math.max(nums[1],nums[2]);
        for(int i = 2; i < nums.length-1; i++){
            answer2[i] = Math.max(answer2[i-2] + nums[i+1], answer2[i-1]);
        }

        return Math.max(answer1[answer1.length-1], answer2[answer2.length-1]);
    }
}
